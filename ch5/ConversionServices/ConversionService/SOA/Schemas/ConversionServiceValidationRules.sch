<?xml version="1.0" encoding="UTF-8" ?>
<schema xmlns="http://www.ascc.net/xml/schematron">
  <ns uri="saibot.airport/services/utility/conversion" prefix="conversion" />
  <pattern name="Celsius Temperature Values not under -100">
    <rule context="//conversion:temperatureCelsiusToFahrenheitRequestMessage">
      <assert test="conversion:temperature &gt; -100">Temperature should not be below -100</assert>
    </rule>
  </pattern>
</schema>