package saibot.airport.services.spring;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GoogleTextToSpeechConverter implements TextToSpeechConverter {
    /* based on :
         * http://jeffchien.com/2013/07/06/google-translate-text-to-speech-with-java/
         *
         * */

    /**
        This creates the output mp3 file based off the text contents and the language.
        @param destiantion - the requestesd name for the output mp3 file
        language - the language code of the text (en, es, zh, etc)
        snippets - a list of parameter strings that ar eeach less than or
        equal to 100 characters
     **/

private ContentHandler contentHandler;

    public void setContentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }


    @Override
    public byte[] convertTextToSpeech(String text, String language) {
        //convert the text to have '+' where there are spaces and create 100 charcter
        //or less snippets based off the string
        ArrayList<String> paramSnippets = getParams(text);
        //print out the snippets
        for (String snippet : paramSnippets) {
            System.out.println(snippet);
            System.out.println("------------------------------------------");
        }
        //create the mp3 file that will have an audio version of the text
        try {
            return makeAudio(language, paramSnippets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private byte[] makeAudio(String language, List<String> snippets) throws IOException {
        byte[] mp3Buffer = null;
        try {
            //byte array that is 1 MB of the file
            byte[] buffer = new byte[1 << 8];
            //This is the output stream that will create the mp3 and store it in the directory
            //after the program runs. notice that there is no second parameter so it overwrites
            //the previous mp3 with the same name if it exists prior to this function call
            // We create a Path out the file we are going to read
            Path file = Paths.get(System.getProperty("user.home"), "temp.mp3");
            
            
            SeekableByteChannel sbc =null;
           // try {
            sbc =
                Files.newByteChannel(file,
                                     EnumSet.of(StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING,
                                                StandardOpenOption.WRITE));
            //input stream where you get the mp3 from
            InputStream in = null;
            for (String snippet :
                 snippets) {
                //create a URLConnection with the language and snippet of text with spaces being '+'
                URLConnection connection =
   new URL("http://www.translate.google.com/translate_tts?tl=" + language + "&q=" + snippet).openConnection();
                //simulate a browser because Google doesn't let you get the mp3 without being able to identify it first
                connection.setRequestProperty("User-Agent",
                                              "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; .NET CLR 1.0.3705; .NET CLR 1.1.4322; .NET CLR 1.2.30703)");
                //connect to the connection
                connection.connect();
                //get the data from the connection
                in = connection.getInputStream();
                int count;
                //while there is data from the input,
                ByteBuffer bb;
                while ((count = in.read(buffer)) != -1) {
                    //write to the output file
                    bb = ByteBuffer.wrap(buffer);
                    sbc.write(bb);
                    bb.clear();
                }
                //close the input stream
                in.close();
                System.out.println("Process snippet "+snippet);
            }
            //close the input and output streams
            in.close();
            SeekableByteChannel byteChannel = Files.newByteChannel(file);
            ByteBuffer bb = ByteBuffer.allocate((int) byteChannel.size());
            byteChannel.read(bb);
            mp3Buffer = bb.array();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("mp3 buffer" + mp3Buffer.length);
        return mp3Buffer;
    }

    /**
    This takes in a string of text, converts it to URL parameter form by replacing all the spaces with '+', and separates them into an ArrayList of strings with each string in the ArrayList having a max of 100 characters including the '+'.
    @param text - A string that you want to be converted to a mp3 using Google's text to speech
     **/
    private static ArrayList<String> getParams(String text) {
        //replace all the spaces with '+'
        String paramText = text.replaceAll(" ", "+");
        //starting index of the current substring in relation to the string passed in
        int startIndex = 0;
        //list of strings that will contain strings that are <=100 characters
        ArrayList<String> result = new ArrayList<String>();
        //keep looping while the startIndex variable is not the last character in the string
        while (startIndex < text.length() - 1) {
            //get the end index of the substring, which is one plus the index of the
            //last character that is <=100 characters away from the start of the substring
            //that is not a '+' (index + 1 because the endIndex paramter of the
            //String.substring(int,int) is non-inclusive
            int endSnippetIndex = getSnippetEnd(paramText, startIndex);
            //Grab the snippet from the text parameter using the start and end index you found
            String snippet = paramText.substring(startIndex, endSnippetIndex);
            //ensure that the snippet of text has at least 2 characters
            //(sometimes there may be a '+' at the beginning of the substring)
            if (snippet.length() >= 2) {
                //if the first character is a '+', remove it
                if (snippet.substring(0, 1).equals("+")) {
                    snippet = snippet.substring(1);
                }
            }
            //add the snippet to the results array
            result.add(snippet);
            //set the startIndex to the endSnippet
            startIndex = endSnippetIndex;
        }
        //once the text has been converted into a list of <=100 character snippets, return the list
        for (String snip:result) {
            System.out.println("Snippet = "+snip);
        }
        return result;
    }

    private static int getSnippetEnd(String text,
                                     int startIndex) {
        //set the substring; if there is still 100 characters left in the origial text starting from the
        //startIndex, set the substring to be 100 cahracters. otherwise, just get the rest of the string
        //that is left starting at the startIndex
        String subtext =
            (text.substring(startIndex).length() > 100) ? text.substring(startIndex, startIndex + 100) :
            text.substring(startIndex);
        //the end index initially set as the length of the substring (you dont subtract by 1 because this is used


        //as the 2nd parameter of the String.substring(int,int) method used in getParams(String) to create the
        //substring to add to the list
        int end = subtext.length();
        //if there is <=100 characters in the substring, you are done. Otherise, you have to make sure that you
        //aren't in the middle of the word. IF you are, then decrement the 'end' index until you reach a '+' sigh.
        //Then simply remove the '+' sign, and you will not have any problems with word being cut off in the middle
        //whlie parsing
        if (text.substring(startIndex).length() > 100) {
            //while the last character is not a + sign, remove the last character of the substring
            while (!subtext.substring(subtext.length() - 1, subtext.length()).equals("+")) {
                subtext = subtext.substring(0, subtext.length() - 1);
                end--;
            }
            // get rid of the last plus sign
            subtext = subtext.substring(0, subtext.length() - 1);
            end--;
        }
        //return the end index of the substtring and offset it by the starting index
        return end + startIndex;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        GoogleTextToSpeechConverter gt= new GoogleTextToSpeechConverter();
    //    gt.setContentHandler(new DropboxClient());
        String url = gt.convertTextToSpeechAndHandle("Flight KLM 3 5 1 is now boarding at gate 25 at the end of pier D. All passengers please come forward at this moment. Bring one piece of hand luggage and do not forget any personal belongings. We hope you will have a pleasant flight", "en", "DinerTekst.mp3");
//        byte[] buffer =
//            new GoogleTextToSpeechConverter().convertTextToSpeech("Hallo lieve lex zegt de stem van Google ", "nl");
//        System.out.println("Done with the audio conversion; sending to dropbox next");
//        String url = new DropboxClient().writeFileToDropbox(buffer, "LexBoodschap.mp3", "/Public");
        System.out.println("File uploaded to dropbox = " + url);
        //            Path tempFile;
//        try {
//
//            Files.write(FileSystems.getDefault().getPath(".", "MyMp3.mp3"),
//
//                        buffer,
//
//                        StandardOpenOption.CREATE);
//
//        }
//
//        catch (IOException ioe) {
//
//            ioe.printStackTrace();
//
//        }

        //          tempFile = Files.createTempFile("finalaudio", "mp3", null);
        //    Files.write(tempFile, buffer);


    }

    @Override
    public String convertTextToSpeechAndHandle(String text, String language, String title) {
        byte[] buffer =
            convertTextToSpeech(text, language);
        String result="NONE";
        if (contentHandler!=null) {
            try {
                
            
            result  = contentHandler.handleContent(buffer, title);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("***********************************");
                System.out.println("Foutje voor "+title);
            }
        }
        return result;
    }
}


