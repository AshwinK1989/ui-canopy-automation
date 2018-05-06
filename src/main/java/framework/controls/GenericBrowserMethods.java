package framework.controls;

import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GenericBrowserMethods {

    public static void closeBrowser(WebDriver driver) {

        try {

            LogUtil.info("Closing the browser");

            driver.quit();

        } catch (Exception e) {

            LogUtil.error("Failed to close the browser | Class: GenericBrowserMethods | method: closeBrowser " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

    }

}

