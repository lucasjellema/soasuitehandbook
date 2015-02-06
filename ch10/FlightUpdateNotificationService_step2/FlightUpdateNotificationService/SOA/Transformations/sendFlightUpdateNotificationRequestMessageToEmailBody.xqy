xquery version "1.0" encoding "utf-8";

(:: OracleAnnotationVersion "1.0" ::)

declare namespace ns2="http://platform.integration.oracle/blocks/adapter/fw/metadata/EmailSender";
(:: import schema at "../Schemas/EmailSender.xsd" ::)
declare namespace ns1="saibot.airport/services/flightupdatenotification";
(:: import schema at "../Schemas/FlightUpdateNotificationService.xsd" ::)

declare variable $sendFlightUpdateNotificationRequestMessage as element() 
(:: schema-element(ns1:sendFlightUpdateNotificationRequestMessage) ::) external;

declare function local:func($sendFlightUpdateNotificationRequestMessage as element()
(:: schema-element(ns1:sendFlightUpdateNotificationRequestMessage) ::)) 
as element() (:: schema-element(ns2:message) ::) {
    <ns2:message>
        <ns2:payload>
            {fn:data($sendFlightUpdateNotificationRequestMessage/ns1:CommunicationMetadata/ns1:Salutation)}
        </ns2:payload>
    </ns2:message>
};

local:func($sendFlightUpdateNotificationRequestMessage)
