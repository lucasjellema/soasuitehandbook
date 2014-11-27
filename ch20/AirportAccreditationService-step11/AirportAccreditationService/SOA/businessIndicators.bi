<?xml version="1.0" encoding="UTF-8"?>
<ns0:businessIndicators xmlns:ns0="http://xmlns.oracle.com/bpm/analytics/businessIndicator" fileVersion="20130625">
   <ns0:businessIndicator name="UnknownRequestorCounter">
      <ns0:id>cac309d8-17d8-4b43-ac90-812281cff4f9</ns0:id>
      <ns0:type>COUNTER</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL"></ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="AccreditationRequestCounter">
      <ns0:id>26d89bff-3e21-4b26-8112-3f8fee5f7fd3</ns0:id>
      <ns0:type>COUNTER</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL"></ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="RequestedSecurityLevel">
      <ns0:id>e08ddb46-4b76-4630-8fe3-621d1d87ccdc</ns0:id>
      <ns0:type>DIMENSION</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:dataRange>
         <ns0:dataRangeInfo name="Range6" startPoint="5"/>
         <ns0:dataRangeInfo name="Range5" startPoint="4"/>
         <ns0:dataRangeInfo name="Range4" startPoint="3"/>
         <ns0:dataRangeInfo name="Range3" startPoint="2"/>
         <ns0:dataRangeInfo name="Range2" startPoint="1"/>
         <ns0:dataRangeInfo name="Range1" startPoint="0"/>
         <ns0:dataRangeInfo name="Otherwise"/>
      </ns0:dataRange>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL">$inputVariable.part1/ns1:RequiredSecurityLevel</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="RequestingOrganization">
      <ns0:id>86bb36e8-cd43-4025-8941-05f0cb023742</ns0:id>
      <ns0:type>DIMENSION</ns0:type>
      <ns0:dataType>String</ns0:dataType>
      <ns0:dataRange>
         <ns0:dataRangeInfo name="Otherwise"/>
      </ns0:dataRange>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL">$inputVariable.part1/ns1:RequestingOrganizationId</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="RequiredSecurityLevel">
      <ns0:id>8c9182d2-699d-4d7e-989f-35597552ceaa</ns0:id>
      <ns0:type>MEASURE</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationService" componentType="BPMN">bpmn:getDataObject('projectDataObjectMeasure1')</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
</ns0:businessIndicators>
