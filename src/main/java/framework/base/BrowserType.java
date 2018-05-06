package framework.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserType {


    static WebDriver create(String browser) throws IllegalAccessException {
        try {


            WebDriver driver;
            switch (browser) {

                case "Chrome":


                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/Drivers/chromedriver");
                    Dimension d = new Dimension(1280, 733);
                    driver = new ChromeDriver();
                    driver.manage().window().setSize(d);
                    break;

                default:
                    throw new IllegalAccessException();

            }

            return driver;
        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;

    }
}
