-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create table, type, procedure, sequence

CREATE SEQUENCE  "FUT_SLT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;


CREATE OR REPLACE TYPE "WEEKDAY_TBL_T" force
as table of varchar2(3)
/

  CREATE OR REPLACE TYPE "TIMEUNIT_T" force
as object (
  start_date date
, end_date   date  
, days_of_week weekday_tbl_t
, hour_of_day number(2)
, five_minute_block number(2)
)

/


  CREATE OR REPLACE TYPE "SLOT_ALLOCATION_T" force
as object (
  allocation_timestamp timestamp
, result_code  number(1,0)
, slot_id      number(10,0)
)

/
--------------------------------------------------------
--  DDL for Type SLOT_ALLOCATION_TBL_T
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SLOT_ALLOCATION_TBL_T" force
as table of slot_allocation_t

/

  CREATE OR REPLACE TYPE "SLOT_T" force
as object (
  aircarrier_code          varchar2(3)
, timeblock                timeunit_t 
, arrival_or_departure     varchar2(1)
, aircraft_model_iata_code varchar2(3)
, aircraft_model_icao_code varchar2(4)
)
/

  CREATE OR REPLACE TYPE "SLOT_TBL_T" force
as table of slot_t

/

  CREATE TABLE "FUT_SLOTS" 
   (	"ID" NUMBER(10,0), 
	"START_DATE" DATE, 
	"END_DATE" DATE, 
	"DAYS_OF_WEEK" CHAR(7), 
	"HOUR_OF_DAY" NUMBER(2,0), 
	"FIVE_MINUTE_BLOCK" NUMBER(2,0), 
	"ACR_ID" NUMBER(10,0), 
	"ARR_OR_DEP" VARCHAR2(1), 
	"DATE_OF_ALLOCATION" DATE, 
	"PRD_ID" NUMBER(10,0)
   ) ;



CREATE TABLE "CMN_AIR_CARRIERS" 
   (	"ID" NUMBER(10,0), 
	"IATA_CODE" VARCHAR2(3), 
	"ICAO_CODE" VARCHAR2(4), 
	"NAME" VARCHAR2(100), 
	"LOGO" BLOB, 
	"CTY_ID" NUMBER(10,0)
   ) ;
   
Insert into CMN_AIR_CARRIERS (ID,IATA_CODE,ICAO_CODE,NAME,CTY_ID) values (123,'KLM',null,'Royal Dutch Airlines',null);
   


CREATE OR REPLACE PACKAGE "FUT_SLOT_API" 
as

procedure allocate_slots
( p_slots            in  slot_tbl_t
, p_slot_allocations out slot_allocation_tbl_t
);

end fut_slot_api;

/

  CREATE OR REPLACE PACKAGE BODY "FUT_SLOT_API" 
as

-- this next function is taken from the blog article http://technology.amis.nl/2011/06/08/replace-by-position/
-- by Patrick Barel, published on the AMIS Technology Blog
FUNCTION replacepos
  ( source_in      IN VARCHAR2
  , replacechar_in IN VARCHAR2
  , position_in    IN NUMBER) RETURN VARCHAR2 IS
  l_returnvalue VARCHAR2(32767);
BEGIN
  -- copy from the source string up to, but not including,
  -- the character position
  -- to be replaced
  l_returnvalue := substr( str1 => source_in
                         , pos => 1
                         , len => position_in - 1);
  -- add the replacement character
  -- just a single character, but more can be sent in,
  -- so substring the parameter
  l_returnvalue := l_returnvalue ||
                    substr( str1 => replacechar_in
                          , pos => 1
                          , len => 1);
  -- copy the rest of the source string
  l_returnvalue := l_returnvalue ||
                    substr( str1 => source_in
                          , pos => position_in + 1);
  RETURN l_returnvalue;
END replacepos;

procedure allocate_slots
( p_slots            in  slot_tbl_t
, p_slot_allocations out slot_allocation_tbl_t
) is
  l_slot_allocation_tbl slot_allocation_tbl_t:= slot_allocation_tbl_t();
  l_index   pls_integer;
  i   pls_integer;
  l_slot_id pls_integer;
  l_acr_id pls_integer;
  l_result_code pls_integer;
  l_days_of_week char(7);
begin
    if p_slots is not null and p_slots.count >0
  then
    l_index := p_slots.first;
    loop
      exit when l_index is null;
      -- convert days of week
      -- YNYYNNN for Mon, Tue, Wed, Thu, Fri, Sat, Sun  
      l_days_of_week:='NNNNNNN';
      for i in 1..p_slots(l_index).timeblock.days_of_week.count loop
         l_days_of_week:= replacepos
                          ( l_days_of_week
                          , 'Y'
                          , case upper(p_slots(l_index).timeblock.days_of_week(i))
                            when 'MON' then 1
                            when 'TUE' then 2
                            when 'WED' then 3
                            when 'THU' then 4
                            when 'FRI' then 5
                            when 'SAT' then 6
                            when 'SUN' then 7
                            end 
                          );
                          
      end loop;
      
      
      insert into fut_slots
      ( id , start_date , end_date
      , days_of_week, hour_of_day, five_minute_block,acr_id,arr_or_dep,date_of_allocation 
      )
      values
      ( fut_slt_seq.nextval , p_slots(l_index).timeblock.start_date , p_slots(l_index).timeblock.end_date
      , l_days_of_week, p_slots(l_index).timeblock.hour_of_day, p_slots(l_index).timeblock.five_minute_block, (select acr.id from cmn_air_carriers acr where acr.iata_code = p_slots(l_index).aircarrier_code), p_slots(l_index).arrival_or_departure, sysdate 
      )
      returning id, acr_id into l_slot_id, l_acr_id
      ;
      l_result_code:=0;
      if l_acr_id is null
      then -- no aircarrier found
        delete fut_slots where id = l_slot_id;
        l_result_code := 1;
      end if;  
      l_slot_allocation_tbl.extend();
      l_slot_allocation_tbl(l_slot_allocation_tbl.last):= slot_allocation_t( systimestamp, l_result_code, case l_result_code when 0 then l_slot_id end);

      l_index := p_slots.next(l_index);
    end loop;
  end if;  

  p_slot_allocations:= l_slot_allocation_tbl;

end;

end fut_slot_api;

/

