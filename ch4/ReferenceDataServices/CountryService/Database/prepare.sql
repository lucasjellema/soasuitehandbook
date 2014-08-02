-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create table, type, procedure, sequence

 CREATE SEQUENCE  "CMN_CTY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 50 START WITH 1050 CACHE 20 NOORDER  NOCYCLE ;


  CREATE TABLE "CMN_COUNTRIES" 
   (	"ID" NUMBER(10,0), 
	"CODE" VARCHAR2(2), 
	"NAME" VARCHAR2(100), 
	"TAILCODE" VARCHAR2(10), 
	"FLAG" BLOB
   ) ;

