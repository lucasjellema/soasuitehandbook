package saibot.airport.finance;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "FinanceAircraftMovementReporterEJB", mappedName = "FinanceAircraftMovementReporter")
public class FinanceAircraftMovementReporterBean implements FinanceAircraftMovementReporter,
                                                            FinanceAircraftMovementReporterLocal {
    @Resource
    SessionContext sessionContext;

    public FinanceAircraftMovementReporterBean() {
    }

    @Override
    public void reportAircraftMovement(AircraftMovement aircraftMovement) {
        System.out.println("AircraftMovement has been reported "+ aircraftMovement);
    }
}
