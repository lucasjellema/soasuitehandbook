package saibot.airport.services.spring;

public interface TwitterMessageSender {
    void sendDirectMessage(String message, String recipient);
}
