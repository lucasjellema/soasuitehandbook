-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create table, type, procedure, sequence

  CREATE TABLE "CMN_AIRPORTS" 
   (	"ID" NUMBER(10,0), 
	"IATA_CODE" VARCHAR2(3), 
	"ICAO_CODE" VARCHAR2(4), 
	"NAME" VARCHAR2(100), 
	"CTY_ID" NUMBER(10,0), 
	"CITY" VARCHAR2(100), 
	"LONGITUDE" NUMBER(10,7), 
	"LATTITUDE" NUMBER(10,7), 
	"UTC_OFFSET" NUMBER(3,1)
   ) ;

  CREATE TABLE "CMN_COUNTRIES" 
   (	"ID" NUMBER(10,0), 
	"CODE" VARCHAR2(2), 
	"NAME" VARCHAR2(100), 
	"TAILCODE" VARCHAR2(10), 
	"FLAG" BLOB
   ) ;

Insert into CMN_AIRPORTS (ID,IATA_CODE,ICAO_CODE,NAME,CTY_ID,CITY,LONGITUDE,LATTITUDE,UTC_OFFSET) values (1,'AMS','AMS','Schiphol Airport',1,'Amsterdam',null,null,1);

Insert into CMN_COUNTRIES (ID,CODE,NAME,TAILCODE) values (1,'NL','The Netherlands','PH');
Insert into CMN_COUNTRIES (ID,CODE,NAME,TAILCODE) values (2,'UK','United Kingdom','G');
Insert into CMN_COUNTRIES (ID,CODE,NAME,TAILCODE) values (3,'US','United States of America','N');
Insert into CMN_COUNTRIES (ID,CODE,NAME,TAILCODE) values (4,'FR','France','F');
