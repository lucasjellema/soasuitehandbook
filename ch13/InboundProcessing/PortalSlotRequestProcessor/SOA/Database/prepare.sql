-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create table, type, procedure, sequence


  CREATE TABLE "PORTAL_SLOT_ALLOCATIONS" 
   ("PORTAL_SLOT_REFERENCE" NUMBER(10,0) not null primary key, 
	"START_DATE_FOR_SLOT" DATE, 
	"END_DATE_FOR_SLOT" DATE, 
	"WEEKDAYS_BITMAP" CHAR(7), 
	"HOUR_OF_DAY" NUMBER(2,0), 
	"FIVE_MINUTE_BLOCK" NUMBER(2,0), 
	"CARRIER" VARCHAR2(10), 
	"DEPARTURE_YN" VARCHAR2(1), 
	"IATA_AIRCRAFT_MODEL_TYPE" VARCHAR2(10) default 'N',
	"PROCESS_STATUS" VARCHAR2(1) default 'N'
   ) ;


rem some sample data


insert into  PORTAL_SLOT_ALLOCATIONS
(PORTAL_SLOT_REFERENCE     
,START_DATE_FOR_SLOT       
,END_DATE_FOR_SLOT         
,WEEKDAYS_BITMAP           
,HOUR_OF_DAY               
,FIVE_MINUTE_BLOCK         
,CARRIER                   
,DEPARTURE_YN              
,IATA_AIRCRAFT_MODEL_TYPE  
)
values
(342
,to_date('25-01-2015', 'DD-MM-YYYY')
,to_date('25-04-2015', 'DD-MM-YYYY')
,'1100011'
,16
,35
,'KL'
,'N'
, null
);

insert into  PORTAL_SLOT_ALLOCATIONS
(PORTAL_SLOT_REFERENCE     
,START_DATE_FOR_SLOT       
,END_DATE_FOR_SLOT         
,WEEKDAYS_BITMAP           
,HOUR_OF_DAY               
,FIVE_MINUTE_BLOCK         
,CARRIER                   
,DEPARTURE_YN              
,IATA_AIRCRAFT_MODEL_TYPE  
)
values
(345
,to_date('03-01-2016', 'DD-MM-YYYY')
,to_date('18-02-2016', 'DD-MM-YYYY')
,'1100011'
,20
,05
,'MH'
,'N'
, null
);

insert into  PORTAL_SLOT_ALLOCATIONS
(PORTAL_SLOT_REFERENCE     
,START_DATE_FOR_SLOT       
,END_DATE_FOR_SLOT         
,WEEKDAYS_BITMAP           
,HOUR_OF_DAY               
,FIVE_MINUTE_BLOCK         
,CARRIER                   
,DEPARTURE_YN              
,IATA_AIRCRAFT_MODEL_TYPE  
)
values
(349
,to_date('11-06-2015', 'DD-MM-YYYY')
,to_date('20-06-2015', 'DD-MM-YYYY')
,'0011100'
,6
,10
,'QA'
,'Y'
, null
);
