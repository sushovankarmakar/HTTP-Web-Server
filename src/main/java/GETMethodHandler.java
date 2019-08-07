import java.io.BufferedOutputStream;
import java.io.File;

public class GETMethodHandler {

    private static final String FILE_NOT_FOUND = "fileNotFound.txt";

    public void handler(String fileRequested, BufferedOutputStream outputStream, HttpHeader httpHeader){
        File file = new File(fileRequested);

        FileManager fileManager = new FileManager();

        if(file.exists()){
            fileManager.manager(file, fileRequested, outputStream, httpHeader);
        }
        else {
            File notFoundFile = new File(FILE_NOT_FOUND);
            fileManager.manager(notFoundFile, fileRequested, outputStream, httpHeader);
        }
    }
}
