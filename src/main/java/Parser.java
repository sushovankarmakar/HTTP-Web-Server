import java.util.StringTokenizer;

public class Parser {

    String methodName = "", fileRequested = "";
    void parse(byte[] data){
        StringTokenizer parse = new StringTokenizer(new String(data));
        methodName = parse.nextToken().trim();
        fileRequested = parse.nextToken().replace('/', ' ').trim();
        LogWriter.logWrite("Method is  " + methodName);
        LogWriter.logWrite("File is " + fileRequested);
    }
}
