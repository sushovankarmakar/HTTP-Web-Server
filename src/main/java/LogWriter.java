import java.io.File;
import java.util.logging.*;

public class LogWriter {
    public static LogManager lm;
    public static Logger logger;
    public static FileHandler fileHandler;
    public static String fileName = "LogMessage/LogMsg.txt";

    static void logWrite(String message) {

        try{
            File logFile = new File(fileName);
            if(!logFile.exists()){
                logFile.createNewFile();
            }

            logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            fileHandler = new FileHandler(fileName,true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, message);
            fileHandler.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
