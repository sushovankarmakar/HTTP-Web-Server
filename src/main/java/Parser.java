import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;

public class Parser {

    String methodName = "", fileRequested = "";
    void parse(byte[] data){

        try{
            LogWriter logWriter = new LogWriter("LogMessage/LogMsg.txt");
            logWriter.logger.setLevel(Level.ALL);

            StringTokenizer parse = new StringTokenizer(new String(data));
            methodName = parse.nextToken().trim();
            fileRequested = parse.nextToken().replace('/', ' ').trim();
            //System.out.println("Method is  " + methodName);
            //System.out.println("File is " + fileRequested);
            logWriter.logger.info("Method is  " + methodName);
            logWriter.logger.info("File is " + fileRequested);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
