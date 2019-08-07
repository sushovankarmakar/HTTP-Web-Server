import java.io.BufferedOutputStream;
import java.io.File;

public class FileManager {

    void manager(File file, String fileRequested, BufferedOutputStream outputStream, HttpHeader httpHeader){
        FileDataReader fileDataReader = new FileDataReader();
        int fileLength = (int) file.length();
        byte[] fileData = fileDataReader.readFileData(file, fileLength);
        httpHeader.getHttpHeaderWithDataToClient(outputStream, fileRequested, fileLength, fileData);
    }
}
