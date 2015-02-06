package saibot.airport.services.spring;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxClient;

import com.dropbox.core.DbxEntry;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxUrlWithExpiration;
import com.dropbox.core.DbxWriteMode;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.RandomAccessFile;

import java.util.Locale;

public class DropboxClient implements DropboxAdapter, ContentHandler {
    
    private final String accessToken = "JGTKd2WoKPoAAAAAAAALYp-4BeEQMUKRSdu9_P8Sfwt9DnHHGf18z9G0AbuCppxK";
    // Get your app key and secret from the Dropbox developers website.
    final String APP_KEY = "x6jopf3htkwnn5g";
    final String APP_SECRET = "jgy6szmtlcg3ow7";
        /*
         * When running on WebLogic :
         * /u01/Oracle/Middleware/Oracle_Home/WORK/system12.1.3.0.41.140108.0730/DefaultDomain/bin/startWebLogic.sh
         * set JAVA_OPTIONS=%JAVA_OPTIONS% -DUseSunHttpHandler=true
         * see: http://stackoverflow.com/questions/18512009/weblogic-net-http-soaphttpsurlconnection-cannot-be-cast-to-javax-net-ssl-httpsur
         * http://idmoim.blogspot.nl/2014/03/javalangclasscastexception.html
         * 1. Login to the Web Logic Server Machine.
2  Go to the $DOMAIN_HOME/bin directory and edit the setDomainEnv.sh file and add the following system property to the JAVA_OPTIONS
JAVA_OPTIONS="${JAVA_OPTIONS} -DUseSunHttpHandler=true"
         * 
         */
private DbxRequestConfig config ;
    public DropboxClient() {

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        config = new DbxRequestConfig(
            "SaibotAirport0", Locale.getDefault().toString());
    }

    @Override
    public String writeFileToDropbox(byte[] fileContents, String fileName, String path)  {
        DbxClient client = new DbxClient(config, accessToken);
        String shareableURL="";
//        File inputFile = new File("/u01/work/ch10/Spring/GoogleTextToSpeech/testOne.mp3");
  //      FileInputStream inputStream = new FileInputStream(inputFile);
        ByteArrayInputStream contentStream = new ByteArrayInputStream(fileContents);
        try {
            DbxEntry.File uploadedFile = client.uploadFile(path +"/"+fileName,
                DbxWriteMode.add(), fileContents.length, contentStream);
            shareableURL = client.createShareableUrl(uploadedFile.path);
              //  System.out.println("URL to uploaded file "+ url);
            DbxUrlWithExpiration tempurl = client.createTemporaryDirectUrl(uploadedFile.path);
            shareableURL = tempurl.url;
             // uploadFile
        } catch (DbxException e) {
        } catch (IOException e) {
        } finally {
            try {
                contentStream.close();
            } catch (IOException e) {
            }
        }        
        return shareableURL;
    }
    
    
    public static byte[] readFile(String file) throws IOException {
           return readFile(new File(file));
       }

       public static byte[] readFile(File file) throws IOException {
           // Open file
           RandomAccessFile f = new RandomAccessFile(file, "r");
           try {
               // Get and check length
               long longlength = f.length();
               int length = (int) longlength;
               if (length != longlength)
                   throw new IOException("File size >= 2 GB");
               // Read file and return data
               byte[] data = new byte[length];
               f.readFully(data);
               return data;
           } finally {
               f.close();
           }
       }

    public static void main(String[] args) {
       byte[] contents;
         try {
             contents = DropboxClient.readFile("/u01/work/ch10/Spring/GoogleTextToSpeech/testOne.mp3");
         
         String url = new DropboxClient().writeFileToDropbox(contents, "ImportantAnnouncement.mp3", "/Public");
       System.out.println("File uploaded = "+url);
        } catch (IOException e) {
             e.printStackTrace();
        }  
   }

    @Override
    public String handleContent(byte[] content, String title) {
        String url = writeFileToDropbox(content, title, "/Public");
        return url;
    }
}
