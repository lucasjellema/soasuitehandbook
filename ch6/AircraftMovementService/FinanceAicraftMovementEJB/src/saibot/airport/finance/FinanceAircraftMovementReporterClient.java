package saibot.airport.finance;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FinanceAircraftMovementReporterClient {
    public static void main(String[] args) throws NamingException {
        final Context context = getInitialContext();
        FinanceAircraftMovementReporter financeAircraftMovementReporter =
            (FinanceAircraftMovementReporter) context.lookup("FinanceAircraftMovementReporter#saibot.airport.finance.FinanceAircraftMovementReporter");
        AircraftMovement am = new AircraftMovement();
        am.setMovementTimestamp(new Date());
        am.setCarrierIataCode("KLM");
        financeAircraftMovementReporter.reportAircraftMovement(am);

    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x/12.x connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://soa2admin2:8011");
        return new InitialContext(env);
    }
}
