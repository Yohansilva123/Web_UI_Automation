package utils;

import java.util.logging.Logger;

public class LoggerUtil {

    public static final String LOGGER_ERROR_MESSAGE = "ERROR!";

    private LoggerUtil(){
        throw new IllegalAccessError();
    }

    public static void log(Exception e){
        LoggerUtil.log(LOGGER_ERROR_MESSAGE + e);
    }

    public static void log(Throwable t){
        LoggerUtil.log(LOGGER_ERROR_MESSAGE + t);
    }

    public static void log(String msg){
        Logger logger = Logger.getLogger("logger");
        logger.info(msg);
    }
}
