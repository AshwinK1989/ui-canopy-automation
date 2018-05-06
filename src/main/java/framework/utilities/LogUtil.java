package framework.utilities;

import framework.config.Settings;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class LogUtil {


    public static Logger log = Logger.getLogger(LogUtil.class);

    public static void startTestCase(String TestCaseName) {

        log.info("Running" + TestCaseName);

    }

    public static void endTestCase(String TestCaseName) {

        log.info("End of " + TestCaseName);

    }

    public static void trace(String message) {

        log.trace(message);

    }

    public static void info(String message) {

        log.info(message);
    }

    public static void debug(String message) {

        log.debug(message);

    }

    public static void warn(String message) {

        log.warn(message);

    }

    public static void error(String message) {

        log.error(message);

    }

    public static void fatal(String message) {

        log.fatal(message);

    }

    public static void setLogger() {

        try {

            final String Path_Log4jConfiguraton = System.getProperty("user.dir") + Settings.Log4jPropertiesFile;
            final String Path_LogFolder = System.getProperty("user.dir") + "/" + "Logs_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + "/" + Settings.Log4jFolderPath;
            Properties po1 = new Properties();
            FileInputStream configStream1 = new FileInputStream(Path_Log4jConfiguraton);
            po1.load(configStream1);
            PropertyConfigurator.configure(Path_Log4jConfiguraton);

            String logFolderPath = Path_LogFolder;
            po1.setProperty("log4j.appender.file.File", logFolderPath);
            FileOutputStream output1 = new FileOutputStream(Path_Log4jConfiguraton);
            po1.store(output1, null);
            configStream1.close();
            output1.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
