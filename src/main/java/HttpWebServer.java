import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpWebServer implements Runnable {

    private static ServerSocket server = null;
    private boolean isAcceptingMoreClient = true;
    private static Socket socket = null;

    HttpWebServer(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("Server has started.");
            System.out.println("Server is listening at port 8080.");
            ClientHandler clientHandler = new ClientHandler();

            while(isAcceptingMoreClient ){
                socket = server.accept();
                new Thread( ()->clientHandler.handleClient(socket)).start();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        // closing the server
       try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        HttpWebServer httpWebServer = new HttpWebServer(port);
    }

    @Override
    public void run() {
        ClientHandler clientHandler = new ClientHandler();
        clientHandler.handleClient(socket);

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
