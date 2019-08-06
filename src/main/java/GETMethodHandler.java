import java.io.BufferedOutputStream;
import java.io.File;

public class GETMethodHandler {

    private static final String FILE_NOT_FOUND = "fileNotFound.txt";

    public void handler(String fileRequested, BufferedOutputStream outputStream, HttpHeader httpHeader){

        File file = new File(fileRequested);
        FileHandler fileHandler = new FileHandler();

        if(file.exists()){
            fileHandler.handleFile(file, fileRequested, outputStream, httpHeader);
        }
        else {
            File notFoundFile = new File(FILE_NOT_FOUND);
            fileHandler.handleFile(notFoundFile, fileRequested, outputStream, httpHeader);
        }
    }
}
