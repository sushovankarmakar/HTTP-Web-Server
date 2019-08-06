import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

public class ClientHandler {

    private static final String FILE_NOT_FOUND = "fileNotFound.txt";

    void handleClient(Socket socket) {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try
        {
            LogWriter logWriter = new LogWriter("LogMessage/LogMsg.txt");
            logWriter.logger.setLevel(Level.ALL);

            inputStream = new BufferedInputStream(socket.getInputStream());
            outputStream = new BufferedOutputStream(socket.getOutputStream());

            //System.out.println("Client accepted");
            logWriter.logger.info("Client accepted");


            byte[] data = new byte[/*inputStream.available()*/256];

            inputStream.read(data);

            System.out.println("----------------------------");
            System.out.println(new String(data));
            System.out.println("----------------------------");

            Parser parser = new Parser();
            parser.parse(data);
            String methodName = parser.methodName;
            String fileRequested = parser.fileRequested;

            HttpHeader httpHeader = new HttpHeader();
            FileDataReader fileDataReader = new FileDataReader();
            if(methodName.equals("GET"))
            {
                logWriter.logger.info("GET method");

                File file = new File(fileRequested);

                if(file.exists()){
                    int fileLength = (int) file.length();
                    byte[] fileData = fileDataReader.readFileData(file, fileLength);
                    httpHeader.getHttpHeaderWithDataToClient(outputStream, fileRequested, fileLength, fileData);
                }
                else {
                    File notFoundFile = new File(FILE_NOT_FOUND);
                    int fileLength = (int) notFoundFile.length();
                    byte[] fileData = fileDataReader.readFileData(notFoundFile, fileLength);

                    httpHeader.getHttpHeaderWithDataToClient(outputStream, fileRequested, fileLength, fileData);
                }
            }
            inputStream.close();
            outputStream.close();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }/*finally {
            try{
                inputStream.close();
                outputStream.close();
                socket.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }*/
    }
}
