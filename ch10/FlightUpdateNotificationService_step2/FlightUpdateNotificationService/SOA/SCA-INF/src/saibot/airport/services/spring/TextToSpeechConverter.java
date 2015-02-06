package saibot.airport.services.spring;

public interface TextToSpeechConverter {

    /**
     * @param text the text to turn into audio
     * @param language the language of the text - values such as en, nl, de, fr, zn, it, es
     * @return an MP3 byte array that contains the audio-ization of the text
     */
    public byte[] convertTextToSpeech(String text, String language);
    
    /**
     * @param text the text to turn into audio
     * @param language the language of the text - values such as en, nl, de, fr, zn, it, es
     * @return a string that refers to the result of whatever handling the injected ContentHandler performed
     */
    public String convertTextToSpeechAndHandle(String text, String language, String title);
}
