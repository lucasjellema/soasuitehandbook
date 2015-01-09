<?xml version="1.0" encoding="UTF-8" ?>
<schema xmlns="http://www.ascc.net/xml/schematron">
  <ns uri="saibot.airport/services/utility/conversion" prefix="conversion" />
  <pattern name="Celsius Temperature Values not under -273">
    <rule context="//conversion:temperatureCelsiusToFahrenheitRequestMessage">
      <assert test="conversion:temperature &gt; -273">Temperature should not be below -273</assert>
    </rule>
  </pattern>
  <pattern name="Kelvin Temperature Values be under 0">
    <rule context="//conversion:temperatureKelvinToFahrenheitRequestMessage">
      <assert test="conversion:temperature &gt; 0">Temperature should not be below 0</assert>
    </rule>
  </pattern>
</schema>