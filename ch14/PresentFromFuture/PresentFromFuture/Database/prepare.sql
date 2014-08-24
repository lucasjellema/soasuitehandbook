-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create table, type, procedure, sequence

-- first the database objects required for COMMON
-- then the set up for FUTURE
-- and finally the objects for PRESENT

  CREATE TABLE "CMN_AIRCRAFTS" 
   (	"ID" NUMBER(10,0), 
	"AML_ID" NUMBER(10,0), 
	"LAUNCH_DATE" DATE, 
	"CURRENT_REGISTRATION" VARCHAR2(30 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_AIRCRAFT_MANUFACTURERS
--------------------------------------------------------

  CREATE TABLE "CMN_AIRCRAFT_MANUFACTURERS" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(100 BYTE), 
	"CTY_ID" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_AIRCRAFT_MODELS
--------------------------------------------------------

  CREATE TABLE "CMN_AIRCRAFT_MODELS" 
   (	"ID" NUMBER(10,0), 
	"IATA_EQUIPMENT_CODE" VARCHAR2(3 BYTE), 
	"ICAO_EQUIPMENT_CODE" VARCHAR2(4 BYTE), 
	"MODEL" VARCHAR2(100 BYTE), 
	"AMR_ID" NUMBER(10,0), 
	"WAKE_CATEGORY" VARCHAR2(1 BYTE), 
	"PASSENGER_CAPACITY" NUMBER(4,0), 
	"KILOMETER_RANGE" NUMBER(5,0), 
	"CRUISE_SPEED" NUMBER(4,0), 
	"LENGTH" NUMBER(5,2), 
	"WIDTH" NUMBER(5,2), 
	"HEIGHT" NUMBER(5,2), 
	"EMPTY_WEIGHT" NUMBER(7,2), 
	"MTOW" NUMBER(7,2), 
	"NOISE_CATEGORY" VARCHAR2(2 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_AIRPORTS
--------------------------------------------------------

  CREATE TABLE "CMN_AIRPORTS" 
   (	"ID" NUMBER(10,0), 
	"IATA_CODE" VARCHAR2(3 BYTE), 
	"ICAO_CODE" VARCHAR2(4 BYTE), 
	"NAME" VARCHAR2(100 BYTE), 
	"CTY_ID" NUMBER(10,0), 
	"CITY" VARCHAR2(100 BYTE), 
	"LONGITUDE" NUMBER(10,7), 
	"LATTITUDE" NUMBER(10,7), 
	"UTC_OFFSET" NUMBER(3,1)
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_AIR_CARRIERS
--------------------------------------------------------

  CREATE TABLE "CMN_AIR_CARRIERS" 
   (	"ID" NUMBER(10,0), 
	"IATA_CODE" VARCHAR2(3 BYTE), 
	"ICAO_CODE" VARCHAR2(4 BYTE), 
	"NAME" VARCHAR2(100 BYTE), 
	"LOGO" BLOB, 
	"CTY_ID" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_COUNTRIES
--------------------------------------------------------

  CREATE TABLE "CMN_COUNTRIES" 
   (	"ID" NUMBER(10,0), 
	"CODE" VARCHAR2(2 BYTE), 
	"NAME" VARCHAR2(100 BYTE), 
	"TAILCODE" VARCHAR2(10 BYTE), 
	"FLAG" BLOB
   ) ;
--------------------------------------------------------
--  DDL for Table CMN_SEASONS
--------------------------------------------------------

  CREATE TABLE "CMN_SEASONS" 
   (	"ID" NUMBER(10,0), 
	"LABEL" VARCHAR2(3 BYTE), 
	"START_DATE" DATE, 
	"END_DATE" DATE
   ) ;


--------------------------------------------------------
--  Constraints for Table CMN_COUNTRIES
--------------------------------------------------------

  ALTER TABLE "CMN_COUNTRIES" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_COUNTRIES" MODIFY ("CODE" NOT NULL ENABLE);
  ALTER TABLE "CMN_COUNTRIES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_SEASONS
--------------------------------------------------------

  ALTER TABLE "CMN_SEASONS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_SEASONS" MODIFY ("LABEL" NOT NULL ENABLE);
  ALTER TABLE "CMN_SEASONS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_AIR_CARRIERS
--------------------------------------------------------

  ALTER TABLE "CMN_AIR_CARRIERS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_AIR_CARRIERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_AIRCRAFT_MANUFACTURERS
--------------------------------------------------------

  ALTER TABLE "CMN_AIRCRAFT_MANUFACTURERS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_AIRCRAFT_MANUFACTURERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_AIRCRAFTS
--------------------------------------------------------

  ALTER TABLE "CMN_AIRCRAFTS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_AIRCRAFTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_AIRPORTS
--------------------------------------------------------

  ALTER TABLE "CMN_AIRPORTS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_AIRPORTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CMN_AIRCRAFT_MODELS
--------------------------------------------------------

  ALTER TABLE "CMN_AIRCRAFT_MODELS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "CMN_AIRCRAFT_MODELS" MODIFY ("AMR_ID" NOT NULL ENABLE);
  ALTER TABLE "CMN_AIRCRAFT_MODELS" MODIFY ("ICAO_EQUIPMENT_CODE" NOT NULL ENABLE);
  ALTER TABLE "CMN_AIRCRAFT_MODELS" MODIFY ("IATA_EQUIPMENT_CODE" NOT NULL ENABLE);
  ALTER TABLE "CMN_AIRCRAFT_MODELS" MODIFY ("ID" NOT NULL ENABLE);



CREATE SEQUENCE  "FUT_SLT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;


--------------------------------------------------------
--  DDL for Table FUT_CODE_SHARES
--------------------------------------------------------

  CREATE TABLE "FUT_CODE_SHARES" 
   (	"ID" NUMBER(10,0), 
	"FLIGHT_ID" NUMBER(10,0), 
	"ACR_ID" NUMBER(10,0), 
	"FLIGHT_NUMBER" VARCHAR2(10 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table FUT_PLANNED_FLIGHTS
--------------------------------------------------------

  CREATE TABLE "FUT_PLANNED_FLIGHTS" 
   (	"ID" NUMBER(10,0), 
	"SLT_ID" NUMBER(10,0), 
	"START_DATE" DATE, 
	"END_DATE" DATE, 
	"DAYS_OF_WEEK" CHAR(7 BYTE), 
	"HOUR_OF_DAY" NUMBER(2,0), 
	"FIVE_MINUTE_BLOCK" NUMBER(2,0), 
	"FLIGHT_NUMBER" VARCHAR2(10 BYTE), 
	"AML_ID" NUMBER(10,0), 
	"CREATION_DATE" DATE, 
	"ACT_ID" NUMBER(10,0), 
	"STATUS" VARCHAR2(2 BYTE), 
	"APT_ID" NUMBER(10,0), 
	"TERMINAL" VARCHAR2(1 BYTE), 
	"PIER" VARCHAR2(1 BYTE), 
	"GATE" VARCHAR2(5 BYTE), 
	"CONNECTING_FLIGHT_ID" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table FUT_SLOTS
--------------------------------------------------------

  CREATE TABLE "FUT_SLOTS" 
   (	"ID" NUMBER(10,0), 
	"START_DATE" DATE, 
	"END_DATE" DATE, 
	"DAYS_OF_WEEK" CHAR(7 BYTE), 
	"HOUR_OF_DAY" NUMBER(2,0), 
	"FIVE_MINUTE_BLOCK" NUMBER(2,0), 
	"ACR_ID" NUMBER(10,0), 
	"ARR_OR_DEP" VARCHAR2(1 BYTE), 
	"DATE_OF_ALLOCATION" DATE, 
	"PRD_ID" NUMBER(10,0)
   ) ;
   
--------------------------------------------------------
--  Constraints for Table FUT_SLOTS
--------------------------------------------------------

  ALTER TABLE "FUT_SLOTS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "FUT_SLOTS" MODIFY ("ARR_OR_DEP" NOT NULL ENABLE);
  ALTER TABLE "FUT_SLOTS" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "FUT_SLOTS" MODIFY ("ID" NOT NULL ENABLE);


--------------------------------------------------------
--  Constraints for Table FUT_CODE_SHARES
--------------------------------------------------------

  ALTER TABLE "FUT_CODE_SHARES" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "FUT_CODE_SHARES" MODIFY ("ID" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table FUT_PLANNED_FLIGHTS
--------------------------------------------------------

  ALTER TABLE "FUT_PLANNED_FLIGHTS" ADD PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "FUT_PLANNED_FLIGHTS" MODIFY ("START_DATE" NOT NULL ENABLE);
  ALTER TABLE "FUT_PLANNED_FLIGHTS" MODIFY ("ID" NOT NULL ENABLE);


-----------------
--  DDL for Present
-----------------

create table cur_flights
( id                       number(10)   not null primary key
, flight_number            varchar2(10)
, aml_id                   number(10) -- aircraft model
, base_planned_flight_id   number(10) -- which planned flight is this actual flight derived from      
, creation_date            date
, act_id                   number(10) 
, status                   varchar2(1) -- a current flight can have multiple statusses (OCXD), including: open, closed (done), cancelled, diverted ; 
, action                   varchar2(2) -- E, F, T, G, B; P, O, C, D, X 
            -- for incoming (as part of Open) : en route, final approach, touched down  taxiing, at gate/disembarking, bagage on belt, other
            -- for departing (as part of Open): prepare/waiting, gate open, gate closing, gate closed, off gate and taxiing, taken off and en route, other
, apt_id                   number(10) -- airport -- destination for departing flights and origin in case of an arriving flight
, terminal                 varchar2(1)
, pier                     varchar2(1)
, gate                     varchar2(5)
, connecting_flight_id     number(10)    -- which flight (if any) is the counterpart (successor or predecessor) of this one; will be empty if aircraft goes to or comes from parking place such as for first and last flight of a day
, acr_id                   number(10)
, arr_or_dep               varchar2(1) not null
, flight_date        date         not null  
, hour_of_day        number(2)    -- 0..23
, five_minute_block  number(2)    -- 0,5,10,15,...
, last_update_timestamp      timestamp
, check_in_counters          varchar2(50)
, assigned_runway            varchar2(10)
, delayed_yn                 varchar2(1)
, bagage_location            number(3)
);


create table cur_code_shares
( id                       number(10)   not null primary key
, flight_id                number(10)    
, acr_id                   number(10)
, flight_number            varchar2(10)
);


create or replace 
package flight_data_manager
as
procedure derive_present_from_future
( p_start_time  in  date default sysdate
, p_hours       in  number default 24
, p_number_of_flights out number
);

end flight_data_manager;
/

create or replace 
package body flight_data_manager
as
procedure derive_present_from_future
( p_start_time  in  date default sysdate
, p_hours       in  number default 24
, p_number_of_flights out number
) is
begin
  insert into cur_flights
  ( id
  , arr_or_dep
  , flight_date
  )
  values
  ( (select nvl(max(id),0)+1 from cur_flights)
  , 'A'
  , nvl(p_start_time, sysdate)
  );

  p_number_of_flights := 216;
end derive_present_from_future;

end flight_data_manager;
/


