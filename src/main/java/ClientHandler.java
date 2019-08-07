import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

public class ClientHandler {

    void handleClient(Socket socket) {

        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try
        {
            inputStream = new BufferedInputStream(socket.getInputStream());
            outputStream = new BufferedOutputStream(socket.getOutputStream());

            LogWriter.logWrite("Client accepted");


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
            if(methodName.equals("GET"))
            {
                LogWriter.logWrite("GET method");
                GETMethodHandler getMethodHandler = new GETMethodHandler();
                getMethodHandler.handler(fileRequested, outputStream, httpHeader);
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
