package framework.controls;

import framework.utilities.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericWaitMethods {


    public static void waitFor(int time) {

        try {

            LogUtil.info("waitFor method is invoked:Hardcoded wait");
            Thread.sleep(time);

        } catch (Exception e) {

            LogUtil.error("Failed to wait -- HardCoded |" +
                    " Class: GenericMethods | method: waitFor " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");
        }

    }

    public static void waitMethod(WebDriver driver, String sLocators) {


        try {
            LogUtil.info("waitMethod is invoked");

            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));


        } catch (Exception e) {


            LogUtil.error("Failed to wait |" +
                    " Class: GenericMethods | method: waitMethod " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

    }


    public static void waitToClickMethod(WebDriver driver, String sLocators) {

        try {

            LogUtil.info("waitToClickMethod is invoked");

            WebDriverWait wait = new WebDriverWait(driver, 60);

            if (sLocators.contains("//")) {

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));
            } else {

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sLocators)));

                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(sLocators)));

                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(sLocators)));
            }

        } catch (Exception e) {


            LogUtil.error("Failed to wait |" +
                    " Class: GenericMethods | method: waitToClickMethod " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

    }

    public static void waitTillElementNotPresent(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting till element is not present");

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(sLocator)));

        } catch (Exception e) {


            LogUtil.error("Failed to wait |" +
                    " Class: GenericWaitMethods | method: waitTillElementNotPresent " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

    }

}
