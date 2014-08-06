dynamic routing worked for JMS JCA with this expression:
<ctx:route >
  <ctx:service>AircraftMovementService/Business Service/FinanceAircraftMovementsReporter</ctx:service>
  <ctx:operation>report</ctx:operation>
</ctx:route>

routing to the business service (not the pipeline)

this one works for the JMS Transport:

<ctx:route >
<ctx:service>AircraftMovementService/Business Service/FinanceAircraftMovementsReporter2</ctx:service>
<ctx:operation></ctx:operation>
</ctx:route>
