import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDataReader {
    byte[] readFileData(File file, int fileLength) {

        byte[] fileData = new byte[fileLength];
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
        } catch(IOException e){
            e.printStackTrace();
        }
        return fileData;
    }
}
