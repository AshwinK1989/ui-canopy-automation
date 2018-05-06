package pages;

import framework.config.Settings;
import framework.controls.GenericBrowserActionMethods;
import framework.controls.GenericNavigationMethods;
import framework.utilities.LogUtil;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public String txtUserName = "//input[@name='username']";
    public String txtPassword = "//input[@name='password']";
    public String btnLogin = "//button[@name='returnUrl']";
    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToLoginPage() {

        LogUtil.info("Navigating to Url " + Settings.loginPageUrl);
        System.out.println(Settings.loginPageUrl);
        GenericNavigationMethods.navigateToUrl(driver, Settings.loginPageUrl);
    }

    public void enterCredentials(String userName, String password) {

        LogUtil.info("Enter Credentials");
        GenericBrowserActionMethods.input(driver, txtUserName, userName);
        GenericBrowserActionMethods.input(driver, txtPassword, password);

    }

    public void clickOnLoginButton() {

        GenericBrowserActionMethods.click(driver, btnLogin);

    }

}
