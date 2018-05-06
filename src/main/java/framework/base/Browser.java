package framework.base;

import framework.controls.GenericBrowserMethods;
import framework.utilities.JsWaiter;
import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;

public class Browser {

    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    public static void setBrowser(String browser) throws Exception {

        if (browser.equalsIgnoreCase("Chrome")) {

            LogUtil.info("Setting the WebDriver for Chrome Browser");
            WebDriver driver = new BrowserType().create(browser);
            setWebDriver(driver);
            JsWaiter.setDriver(driver);


        } else if (browser.equalsIgnoreCase("Firefox")) {

            LogUtil.info("Setting the WebDriver for Firefox Browser");

            WebDriver driver = new BrowserType().create(browser);
            setWebDriver(driver);
            JsWaiter.setDriver(driver);


        }
    }

    public static void setWebDriver(WebDriver driver) {

        LogUtil.info("Setting the WebDriver: setWebDriver Method");
        dr.set(driver);
    }

    public static WebDriver getDriver() {

        LogUtil.info("Returning an instance of Driver");
        return dr.get();
    }

    public static void shutBrowser() {

        LogUtil.info("Quit the browser");
        GenericBrowserMethods.closeBrowser(getDriver());

    }

}