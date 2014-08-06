-- this project requires  limited database set up
-- we are assuming a single database schema (typically called SAIBOT_FINANCE ) that has a number of basic privileges granted to it:
-- quota on the default tablespace
-- system privileges to create type
-- as SYS:  grant the aq_administrator_role to user saibot_finance
-- as SYS: EXECUTE dbms_aqadm.grant_type_access('saibot_finance');

=== AS SYS

create user saibot_finance identified by saibot_finance default tablespace users temporary tablespace temp;
alter user saibot_finance quota unlimited on users;
grant create session to saibot_finance;
grant create type to saibot_finance;
grant aq_administrator_role to saibot_finance;
EXECUTE dbms_aqadm.grant_type_access('saibot_finance');

-- note: instead of creating a separate account SAITBOT_FINANCE you can also reuse schema SAIBOT, provided of course the additional privileges are granted to this schema


=== AS SAIBOT_FINANCE


CREATE or replace TYPE aircraft_movement_report_t AS OBJECT (
    message_id     NUMBER(15)
  , movement_timestamp   timestamp
  , flightnumber         number(3)
  , carrier_iata_code    varchar2(3)
  , airport_iata_code    varchar2(3)
  , arrival_or_departure varchar2(1)
  , aircraft_iata_equipment_code      varchar2(3)  
  , number_of_passengers number(4,0)
);



BEGIN
    DBMS_AQADM.CREATE_QUEUE_TABLE (
        queue_table         => 'saibot_finance.aircraft_movements_qt'
      , queue_payload_type  => 'saibot_finance.aircraft_movement_report_t'
    );
    DBMS_AQADM.CREATE_QUEUE (
        queue_name          => 'aircraft_movements_queue'
      , queue_table         => 'saibot_finance.aircraft_movements_qt'
      , queue_type          => DBMS_AQADM.NORMAL_QUEUE
      , max_retries         => 0
      , retry_delay         => 0
      , retention_time      => 1209600
      , dependency_tracking => FALSE
      , comment             => 'Aircraft Movement Reports Queue'
      , auto_commit         => FALSE
    );
    DBMS_AQADM.START_QUEUE('aircraft_movements_queue');
END;

