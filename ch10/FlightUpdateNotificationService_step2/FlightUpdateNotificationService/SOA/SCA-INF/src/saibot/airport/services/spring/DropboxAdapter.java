package saibot.airport.services.spring;

public interface DropboxAdapter {
    
    /**
     *
     * @param fileContents the bytes that for the contents of the file
     * @param fileName the name of the file that should be created on Dropbox
     * @param path the target folder on Dropbox into which the file should be created (for example /Public)
     * @return the public, shareable URL where the file can be accessed on dropbox 
     */
    public String writeFileToDropbox( byte[] fileContents, String fileName, String path);
}
