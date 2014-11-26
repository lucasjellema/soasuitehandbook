<?xml version="1.0" encoding="UTF-8"?>
<ns0:businessIndicators xmlns:ns0="http://xmlns.oracle.com/bpm/analytics/businessIndicator" fileVersion="20130625">
   <ns0:businessIndicator name="SecurityChecksCounter">
      <ns0:id>f55c7e6c-2aa2-4bcf-b99a-ecfd4ce64ae5</ns0:id>
      <ns0:type>COUNTER</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings/>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="ManualCheckCounter">
      <ns0:id>b635950c-5871-40fe-8a7a-be6fc72045e2</ns0:id>
      <ns0:type>COUNTER</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationService" componentType="BPMN">bpmn:getDataObject('projectDataObjectCounter1')</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="AccreditationRequestCounter">
      <ns0:id>e8f4b475-aefd-4a75-bc4e-25c5d9704c23</ns0:id>
      <ns0:type>COUNTER</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL"></ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="requestingOrganization">
      <ns0:id>30bd4bd7-857e-44ed-926f-c7a96ea66317</ns0:id>
      <ns0:type>DIMENSION</ns0:type>
      <ns0:dataType>String</ns0:dataType>
      <ns0:dataRange>
         <ns0:dataRangeInfo name="Otherwise"/>
      </ns0:dataRange>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationService" componentType="BPMN">bpmn:getDataObject('requestingOrganisation')</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="RequiredLevel">
      <ns0:id>4a5b36fd-9ba2-4f86-a7b5-f299a221d611</ns0:id>
      <ns0:type>DIMENSION</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:dataRange>
         <ns0:dataRangeInfo name="Range2" startPoint="2"/>
         <ns0:dataRangeInfo name="Range1" startPoint="0"/>
         <ns0:dataRangeInfo name="Otherwise"/>
      </ns0:dataRange>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationRequestProcessor" componentType="BPEL">$inputVariable.part1/ns1:RequiredSecurityLevel</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
   <ns0:businessIndicator name="Measure0">
      <ns0:id>c8bebee7-5220-4985-9f65-b13e252dd363</ns0:id>
      <ns0:type>MEASURE</ns0:type>
      <ns0:dataType>Integer</ns0:dataType>
      <ns0:mappings>
         <ns0:mapping componentName="AirportAccreditationService" componentType="BPMN">bpmn:getDataObject('projectDataObjectMeasure1')</ns0:mapping>
      </ns0:mappings>
      <ns0:properties/>
   </ns0:businessIndicator>
</ns0:businessIndicators>
