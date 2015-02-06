package saibot.airport.services.spring;

public interface ContentHandler {

    /**
     * @param content the payload that needs to be handled
     * @param title a description of the content (e.g. a filename)
     * @return a reference to the result or final location (such as a URL) of the handled content
     */
    public String handleContent(byte[] content, String title);
}
