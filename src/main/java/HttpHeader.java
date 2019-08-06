import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Date;

public class HttpHeader {
    void getHttpHeaderWithDataToClient(BufferedOutputStream outputStream,
                                       int fileLength, byte[] fileData)
    {
        try{
            outputStream.write(("HTTP/1.1 200 OK").getBytes());
            outputStream.write(("\nServer: Java HTTP Server : 1.0").getBytes());
            outputStream.write(("\nDate: "+new Date()).getBytes());
            outputStream.write(("\nContent-type: text").getBytes());
            outputStream.write(("\nContent-length: "+ fileLength).getBytes());
            outputStream.write(("\n\n").getBytes());
            outputStream.write(fileData,0,fileLength);
            outputStream.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
