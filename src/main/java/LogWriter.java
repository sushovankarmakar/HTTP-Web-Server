import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LogWriter {
    public static LogManager lm;
    public static Logger logger;
    FileHandler fileHandler;

    LogWriter(String fileName) throws IOException{
        File logFile = new File(fileName);
        if(!logFile.exists()){
            logFile.createNewFile();
        }

        fileHandler = new FileHandler(fileName,true);
        lm = LogManager.getLogManager();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "My first log message");
        logger.log(Level.INFO, "Another Message");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
    }
}
