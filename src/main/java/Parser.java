import java.util.StringTokenizer;

public class Parser {

    String methodName = "", fileRequested = "";
    void parse(byte[] data){
        StringTokenizer parse = new StringTokenizer(new String(data));
        methodName = parse.nextToken().trim();
        fileRequested = parse.nextToken().replace('/', ' ').trim();
        System.out.println("Method is  " + methodName);
        System.out.println("File is " + fileRequested);
    }
}
