xquery version "1.0" ;

(:: OracleAnnotationVersion "1.0" ::)

declare namespace fse="saibot.airport/services/flightschedule";
(:: import schema at "../Schemas/FlightScheduleService.xsd" ::)
declare namespace ns1="saibot/validation";
(:: import schema at "../Schemas/Validation.xsd" ::)
declare namespace ref="saibot.airport/data/reference";
(:: import schema at "../Schemas/reference.xsd" ::)

 import module namespace ns3='airport.saibot/validations/dateAndTime' at "TimePlanningUnitValidations.xqy"; 

declare variable $submitScheduledFlightRequest as element() (:: schema-element(fse:submitScheduledFlightRequestMessage) ::) external;

declare function local:validateSubmitScheduledFlight($submitScheduledFlightRequest as element() (:: schema-element(fse:submitScheduledFlightRequestMessage) ::)) as element() (:: element(*, ns1:Validation) ::) {
    <ns1:Validation>
      <ns1:Payload>{$submitScheduledFlightRequest/.}</ns1:Payload>
      <ns1:ValidationErrorList>
        {
        (: Validations of required fields:) 
        if (empty($submitScheduledFlightRequest/fse:TimePlanningUnit/ref:HourOfDay/text())) then
        <ns1:ValidationError>
        <ns1:code>1</ns1:code>
        <ns1:message>Hour of Day is required</ns1:message>
        </ns1:ValidationError>
        else ''
        }
        {for $validationError in local:validateSubmitScheduledFlightDateAndTimeConstraints($submitScheduledFlightRequest)/ns1:ValidationError
         return $validationError         
        }
         {
        (: using the function validateTimeplanningUnit in the XQuery library TimePlanningUnitValidations.xqy :)
        for $validationError in ns3:validateTimeplanningUnit($submitScheduledFlightRequest/fse:TimePlanningUnit)/ns1:ValidationError
         return $validationError         
        }  
        </ns1:ValidationErrorList>
    </ns1:Validation>
};

declare function local:validateSubmitScheduledFlightDateAndTimeConstraints($submitScheduledFlightRequest as element() (:: schema-element(fse:submitScheduledFlightRequestMessage) ::)) as element()  (:: element(*, ns1:ValidationErrorList) ::) {
      (: Validations of date and time constraints for ScheduledFlight submission :) 
    <ns1:ValidationErrorList>
      {
      if (true() and (  xs:date($submitScheduledFlightRequest/fse:TimePlanningUnit/ref:startDate) lt (fn:current-date() - xs:dayTimeDuration('P3D')))) then
      <ns1:ValidationError>
      <ns1:code>21</ns1:code>
      <ns1:message>Start date should be more than three days from now</ns1:message>
      </ns1:ValidationError>
      else ''
      }
    </ns1:ValidationErrorList>
};

local:validateSubmitScheduledFlight($submitScheduledFlightRequest)