package framework.utilities;

import framework.base.Browser;
import framework.config.Settings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShotUtil {


    public static void captureScreen(String scenarioName) {

        try {

            LogUtil.info("Taking the Screenshot of WebPage");
            File scrFile = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.FILE);

            LogUtil.info("Copying Screenshot to the desired location");
            FileUtils.copyFile(scrFile,
                    new File(System.getProperty("user.dir") + Settings.ScreenShotFolder
                            + "/" + "Shot_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
                            .format(new Date()) + "/" + scenarioName + ".jpg"));

        } catch (Exception e) {

            LogUtil
                    .error("Failed to take the Web Screenshot | Class:CaptureScreenShotUtil | method:captureScreen " +
                            "" + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

    }
}
