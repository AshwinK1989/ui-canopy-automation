package framework.controls;

import framework.helper.Helper;
import framework.utilities.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GenericBrowserActionMethods {


    public static void click(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be clickable");
            GenericWaitMethods.waitToClickMethod(driver, sLocator);

            LogUtil.info("Clicking on an element");
            Helper.getElement(driver, sLocator).click();

        } catch (Exception e) {

            LogUtil.error("Failed to Click | Class: GenericBrowserActionMethods | method: click " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }

    }

    public static void input(WebDriver driver, String sLocator, String inputValue) {

        try {

            LogUtil.info("Waiting for an element to be clickable");
            GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Entering value in an input field");
            Helper.getElement(driver, sLocator).sendKeys(inputValue);

        } catch (Exception e) {

            LogUtil.error("Failed to input | Class: GenericMethods | method: input " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }
    }

    public static boolean isElementNotPresent(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be visible");
            GenericWaitMethods.waitTillElementNotPresent(driver, sLocator);

            LogUtil.info("Checking whether an element is present");
            return Helper.getElements(driver, sLocator).size() == 0;

        } catch (Exception e) {

            LogUtil.error("Failed to check whether element is present" +
                    " | Class: GenericMethods | method: isElementPresent " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }

        return false;
    }


    public static String getElementText(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be visible");
            GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Reading the text of an element");
            return Helper.getElement(driver, sLocator).getText();

        } catch (Exception e) {

            LogUtil.error("Failed to get Element Text | Class: GenericBrowserActionMethods | method: getElementText " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }

        return null;
    }

    public static void selectByText(WebDriver driver, String sLocator, String text) {

        try {

            Select oSelect = new Select(Helper.getElement(driver, sLocator));
            oSelect.selectByVisibleText(text);

        } catch (Exception e) {

            LogUtil.error("Failed to select value from dropdown list |" +
                    " Class: GenericBrowserActionMethods | method: selectValue " + e.getMessage());

        }
    }

    public static void clearField(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be clickable");
            GenericWaitMethods.waitToClickMethod(driver, sLocator);

            LogUtil.info("Entering value in an input field");
            Helper.getElement(driver, sLocator).clear();


        } catch (Exception e) {

            LogUtil.error("Failed to input | Class: GenericMethods | method: input " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }
    }


    public static void pressEnter(WebDriver driver, String sLocator) {

        try {

            driver.findElement(By.xpath(sLocator)).sendKeys(Keys.RETURN);

        } catch (Exception e) {

            LogUtil.error("Failed to select value from dropdown list |" +
                    " Class: GenericBrowserActionMethods | method: selectValue " + e.getMessage());

        }
    }

    public static void mouseHover(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for few Seconds");
            GenericWaitMethods.waitToClickMethod(driver, sLocator);

            LogUtil.info("Hovering over an element");
            getActionsInstance(driver).moveToElement(Helper.getElement(driver, sLocator)).click().build().perform();

        } catch (Exception e) {

            LogUtil.info("Failed to hover over an element | Class:GenericMethods | method:mouseHover " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");


        }
    }

    public static boolean isElementPresentWithoutFailingTest(WebDriver driver, String sLocator) {

        try {

            LogUtil.info("Waiting for an element to be visible");
            GenericWaitMethods.waitMethod(driver, sLocator);

            LogUtil.info("Checking whether an element is present");
            return Helper.getElements(driver, sLocator).size() > 0;

        } catch (Exception e) {

            LogUtil.error("Element is not present" +
                    " | Class: GenericMethods | method: isElementPresentWithoutFailingTest " + e.getMessage());


        }

        return false;
    }

    public static Actions getActionsInstance(WebDriver driver) {

        try {

            return new Actions(driver);

        } catch (Exception e) {

            LogUtil.info("Failed to return the instance of Actions Class | " +
                    "Class: GenericMethods| method: getActionsInstance " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

        return null;
    }

}
