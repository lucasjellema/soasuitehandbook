xquery version "1.0";

(:: OracleAnnotationVersion "1.0" ::)

module namespace ns3="airport.saibot/validations/dateAndTime";

declare namespace ref="saibot.airport/data/reference";
(:: import schema at "../Schemas/reference.xsd" ::)
declare namespace val="saibot/validation";
(:: import schema at "../Schemas/Validation.xsd" ::)

declare function ns3:validateTimeplanningUnit($timePlanningUnit as element() ) as element() (:: element(*, val:ValidationErrorList) ::) {
        (: Validations of date and time constraints :) 
      <val:ValidationErrorList>
        {
        if (  (not(empty($timePlanningUnit/ref:endDate))) and ($timePlanningUnit/ref:endDate lt $timePlanningUnit/ref:startDate)  ) then
        <val:ValidationError>
        <val:code>11</val:code>
        <val:message>End date should be empty or equal to or later than start date</val:message>
        </val:ValidationError>
        else ''
        }
        {
        if (  ( $timePlanningUnit/ref:FiveMinuteBlock mod 5 !=0  )) then
        <val:ValidationError>
        <val:code>15</val:code>
        <val:message>The five minute block should be an integer number times 5</val:message>
        </val:ValidationError>
        else ''
        }
      </val:ValidationErrorList>
};