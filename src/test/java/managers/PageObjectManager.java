package managers;

import org.openqa.selenium.WebDriver;
import pages.AccountHoldingsPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.ManageReportsPage;

public class PageObjectManager {

    WebDriver driver;
    LoginPage loginPage;
    HelpPage helpPage;
    ManageReportsPage manageReportsPage;
    AccountHoldingsPage accountHoldingsPage;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;
    }


    public LoginPage getLoginPage() {

        return (loginPage == null) ? new LoginPage(driver) : loginPage;
    }

    public HelpPage getHelpPage() {

        return (helpPage == null) ? new HelpPage(driver) : helpPage;
    }

    public ManageReportsPage getManageReportsPage() {

        return (manageReportsPage == null) ? new ManageReportsPage(driver) : manageReportsPage;
    }

    public AccountHoldingsPage getAccountHoldingsPage() {

        return (accountHoldingsPage == null) ? new AccountHoldingsPage(driver) : accountHoldingsPage;
    }

}
