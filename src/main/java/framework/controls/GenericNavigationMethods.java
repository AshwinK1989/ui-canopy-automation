package framework.controls;

import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GenericNavigationMethods {


    public static void navigateToUrl(WebDriver driver, String url) {

        try {
            LogUtil.info("Navigating to Url " + url);


            driver.get(url);

        } catch (Exception e) {

            LogUtil.error("Failed to navigate to the Url | Class: GenericNavigationMethods | method: navigateToUrl " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }


    }


}
