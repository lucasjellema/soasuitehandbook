package saibot.airport.security.monitor.jms;

public interface SuspiciousCreditCardEventHandler {
    
    public void handleEvent(SuspiciousCreditCardEvent event);
}
