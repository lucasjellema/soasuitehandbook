package oracle.soa;

import com.oracle.bpel.sensor.DataPublisher;
import com.oracle.bpel.sensor.schemas.ITHeaderInfo;
import com.oracle.bpel.sensor.schemas.ITSensorAction;
import com.oracle.bpel.sensor.schemas.ITSensorActionData;

import com.oracle.bpel.sensor.schemas.ITSensorData;

import com.oracle.bpel.sensor.schemas.ITVariableData;

import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.fabric.logging.LogFormatter;

import org.w3c.dom.Element;

public class SensorDataPublisher implements DataPublisher {
   
    private static final Logger logger = Logger.getLogger("oracle.soa.SensorDataPublisher");
    public SensorDataPublisher () {
      LogFormatter.configFormatter(logger);
    }
        
    @Override
    public void publish(ITSensorAction sensorAction, ITSensorActionData actionData,
                        Element element) throws Exception {
        ITHeaderInfo header = actionData.getHeader();
        ITSensorData data = actionData.getPayload();
          System.out.println( "Custom Sensor Data Publisher "
                            +  header.getSensor().getSensorName()
                            + " published for  "+header.getCompositeName());
            StringBuilder sb = new StringBuilder();
            sb.append("Logging by sensor ").
               append(header.getSensor().getSensorName()).
               append(", evaluated at ").
               append(data.getActivityData().getEvalPoint());
            logger.log(Level.WARNING, sb.toString());
   }
    
    private void publishSensorToLog(ITSensorAction iTSensorAction,
                        ITSensorActionData iTSensorActionData,
                        Element element) {
        StringBuilder sb = new StringBuilder();
                
                //
                // Really simple implementation, just iterates thru the received variables and print them out
                //
                try {
                    // Basic info
                    sb.append("Variable(s) for sensor ").
                       append(iTSensorActionData.getHeader().getSensor().getSensorName()).
                       append(", evaluated at ").
                       append(iTSensorActionData.getPayload().getActivityData().getEvalPoint()).append(":");
                    
                    // Print variables
                    for (int i = 0; i < iTSensorActionData.getPayload().getVariableDataCount(); i++) {
                        ITVariableData data = iTSensorActionData.getPayload().getVariableData(i);

                        // Fixed part
                        sb.append("\nVariable ").append(data.getTarget()).append(": ");

                        if ("oracle.xml.parser.v2.XMLElement".equalsIgnoreCase(data.getData().
                                                                                    getClass().getName())) {
                            // XML
                            oracle.xml.parser.v2.XMLElement xmlPayload = ((oracle.xml.parser.v2.XMLElement)
                                                                           data.getData());
                            java.io.StringWriter writer = new java.io.StringWriter(); 
                            xmlPayload.print(writer); 

                            sb.append("\n").append(writer.toString());
                        } else if ("java.lang.String".equalsIgnoreCase(data.getData().getClass().getName())) {
                            // String
                            sb.append(data.getData().toString());
                        } else {
                            // Specific type treatment
                        }
                    }
                    
                    // Write log message
                    logger.log(Level.WARNING, sb.toString());
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
    
}
