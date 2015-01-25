xquery version "1.0" encoding "utf-8";

(:: OracleAnnotationVersion "1.0" ::)

declare namespace ns1="saibot.airport/services/private/flightschedule";
(:: import schema at "../Schemas/PrivateSubmitFlightScheduleService.xsd" ::)

declare namespace ref="saibot.airport/data/reference";
(:: import schema at "../Schemas/reference.xsd" ::)

declare variable $submitPrivateScheduledFlightRequestMessage as element() (:: schema-element(ns1:submitScheduledFlightRequestMessage) ::) external;

declare function local:func($submitPrivateScheduledFlightRequestMessage as element() (:: schema-element(ns1:submitScheduledFlightRequestMessage) ::)) as element() (:: schema-element(ns1:submitScheduledFlightResponseMessage) ::) {
    <ns1:submitScheduledFlightResponseMessage>
      <ns1:FlightSchedule>
        <ns1:FlightId>42</ns1:FlightId>
        <ns1:SlotId>{data($submitPrivateScheduledFlightRequestMessage/ns1:SlotId)}</ns1:SlotId>
        <ns1:TentativeGateLocation>
           <ref:Terminal >2</ref:Terminal>
           <ref:Pier >D</ref:Pier>
           <ref:Gate >23</ref:Gate>
       </ns1:TentativeGateLocation>
  </ns1:FlightSchedule>
    </ns1:submitScheduledFlightResponseMessage>
};

local:func($submitPrivateScheduledFlightRequestMessage)