package framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    public static void populateProperties() throws IOException {

        ConfigReader cr = new ConfigReader();
        cr.ReadProperty();

    }


    public void ReadProperty() throws IOException {

        Properties prop = new Properties();

        FileInputStream configStream1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/framework/config/GlobalConfig.properties");
        prop.load(configStream1);
        Settings.loginPageUrl = prop.getProperty("loginPageUrl");
        Settings.Log4jFolderPath = prop.getProperty("Log4jFolderPath");
        Settings.Log4jPropertiesFile = prop.getProperty("Log4jPropertiesFile");
        Settings.FeaturesFolder = prop.getProperty("FeaturesFolder");
        Settings.ScreenShotFolder = prop.getProperty("ScreenShotPath");
    }
}
