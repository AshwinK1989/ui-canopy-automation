package pages;

import framework.controls.GenericBrowserActionMethods;
import org.openqa.selenium.WebDriver;

public class HelpPage {

    public String menuReports = "//a[@id='95']";
    public String lnkReportTemplateDesign = "//a[@href='/Reporting/Manage']";
    public String lnkUserAccounts = "//a[@id='25']";
    public String lnkAccountHoldings = "//a[@href='/ControlRoom/HoldingsPerUser']";
    WebDriver driver;


    public HelpPage(WebDriver driver) {

        this.driver = driver;
    }


    public void clickOnReportsMenu() {

        GenericBrowserActionMethods.click(driver, menuReports);

    }

    public void clickOnReportTemplateDesign() {

        GenericBrowserActionMethods.click(driver, lnkReportTemplateDesign);

    }

    public void clickOnUserAccounts() {

        GenericBrowserActionMethods.click(driver, lnkUserAccounts);
    }

    public void clickOnAccountHoldings() {

        GenericBrowserActionMethods.click(driver, lnkAccountHoldings);
    }
}
