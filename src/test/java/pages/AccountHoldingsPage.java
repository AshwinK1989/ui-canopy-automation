package pages;

import framework.controls.GenericBrowserActionMethods;
import framework.helper.Helper;
import framework.utilities.JsWaiter;
import framework.utilities.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AccountHoldingsPage {


    public String txtAccount = "//input[contains(@aria-owns,'userId_taglist')]";
    public String ddAccountName = "//div[contains(@class,'k-multiselect-wrap')]";
    public String clear = "//span[@title='clear']";
    public String btnApplyFilters = "//button[contains(@class,'btn-success')]";
    public String valCurrentUsdValue = "//span[contains(@data-bind,'totalNetworthInUSDFormatted')]";
    public String headerCounts = "//span[contains(@class,'k-header')]/span[contains(@data-bind,'resultCount')]";
    public String headerContractType = "(//span[contains(@class,'k-header')]/span[contains(@data-bind,'header')])";
    public String totalValue = "(//td[contains(text(),'Total')][1])";

    public double usdValue;
    public double total = 0;

    WebDriver driver;

    public AccountHoldingsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void selectAccount(String accountName) {

        GenericBrowserActionMethods.mouseHover(driver, ddAccountName);
        GenericBrowserActionMethods.click(driver, clear);
        GenericBrowserActionMethods.input(driver, txtAccount, accountName);
        JsWaiter.waitJQueryAngular();
        driver.findElement(By.xpath(txtAccount)).sendKeys(Keys.ENTER);
        GenericBrowserActionMethods.click(driver, btnApplyFilters);

    }

    public void saveUSDValue() {

        JsWaiter.waitJQueryAngular();
        usdValue = Double.parseDouble(GenericBrowserActionMethods.getElementText(driver, valCurrentUsdValue).replaceAll("[^0-9.]+", ""));
        LogUtil.info("The USD Value is " + usdValue);

    }

    public void sumContractTypeHeaderValues() {

        total = Helper.returnSumOfContractTypeHeaderValues(driver, headerCounts, headerContractType, totalValue);

    }
}
