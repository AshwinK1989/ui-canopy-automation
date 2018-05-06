package framework.helper;

import framework.controls.GenericBrowserActionMethods;
import framework.utilities.LogUtil;
import framework.utilities.ScrollDownUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Helper {

    public static WebElement getElement(WebDriver driver, String sLocator) {

        try {

            if (sLocator.contains("//")) {

                return driver.findElement(By.xpath(sLocator));
            } else {

                return driver.findElement(By.cssSelector(sLocator));

            }
        } catch (Exception e) {

            LogUtil.error("Failed to return the WebElement | Class: GenericMethods | method: getElement " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

        return null;
    }

    public static List<WebElement> getElements(WebDriver driver, String sLocator) {

        try {

            if (sLocator.contains("//")) {
                return driver.findElements(By.xpath(sLocator));
            } else {

                return driver.findElements(By.cssSelector(sLocator));
            }

        } catch (Exception e) {

            LogUtil.error("Failed to return the list of WebElements | Class: Helper | method: getElement " + e.getMessage());
            Assert.assertFalse(true, "e.getMessage()");

        }

        return null;
    }

    public static double returnSumOfContractTypeHeaderValues (WebDriver driver, String headerCountsLocator,String headerContractTypeLocator, String totalValueLocator)  {

        try {

            double total=0;
            int i = 1;
            List<WebElement> headerCountElements = Helper.getElements(driver, headerCountsLocator);

            System.out.println("The Header count " + headerCountElements.size());

            for (WebElement headerCount : headerCountElements) {

                System.out.println("The header text " + headerCount.getText());
                if (!headerCount.getText().contains("0")) {

                    WebElement element = Helper.getElement(driver, headerContractTypeLocator + "[" + i + "]");

                    ScrollDownUtils.bringIntoView(element, driver);

                    GenericBrowserActionMethods.click(driver, headerContractTypeLocator + "[" + i + "]");

                    ScrollDownUtils.bringIntoView(Helper.getElement(driver, totalValueLocator + "[" + i + "]"), driver);

                    Double d = Double.parseDouble(GenericBrowserActionMethods.getElementText(driver, totalValueLocator + "[" + i + "]").replaceAll("[^0-9.]+", ""));
                    total = total + d;

                    LogUtil.info("The sum of values is "+total);

                }

                i++;
            }

            return  total;


        }
        catch (Exception e)  {

            LogUtil.error("Failed to return the sum of Contract Type Header Values | Class: Helper | method: returnSumOfContractTypeHeaderValues " + e.getMessage());

        }

        return 0;
    }

}