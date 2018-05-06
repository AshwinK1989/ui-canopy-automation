package pages;

import framework.controls.GenericBrowserActionMethods;
import framework.controls.GenericWaitMethods;
import framework.utilities.JsWaiter;
import org.openqa.selenium.WebDriver;

public class ManageReportsPage {

    public String btnCreate = "//a[contains(@class,'k-grid-addReport')]";
    public String txtReportName = "//input[@id='reportName']";
    public String ddStyleTemplate = "//span[text()='Choose style template...']";
    public String ddStyleTemplates = "//li[text()='BaseTemplateDL']";
    public String btnSave = "//button[contains(@class,'btn-success')]";
    public String txtName = "(//input[@data-text-field='name'])[1]";
    public String gridCellName = "(//td[@role='gridcell'])[3]";
    public String ddLogout = "//a[@class='dropdown-toggle']";
    public String btnLogout = "//a[@href='/Account/LogOff']";
    public String lnkEditTemplate = "//a[contains(@class,'editCustom')]";
    public String chkBoxSelectTemplate = "(//input[starts-with(@class,'__chkBox')])[3]";
    public String chkBoxCopySelectTemplate = "(//input[starts-with(@class,'__chkBox')])[4]";
    public String ddStatus = "//span[text()='In Progress']";
    public String ddStatusValue = "(//li[text()='Ready To Assign'])[2]";
    public String gridCellStatus = "(//td[@role='gridcell' and text()='Ready To Assign'])[1]";
    public String lnkCopyTemplate = "(//a[contains(@class,'k-grid-copyCustom')])[1]";
    public String gridCopyCellName = "(//td[@role='gridcell'])[3]";
    public String txtDescription = "//input[@id='reportDescription']";
    public String btnDelete = "//a[contains(@class,'grid-delete-button')]";
    public String btnOk = "//button[@data-bb-handler='confirm']";
    public String gridCellNames = "//td[text()='Test5001']";
    public String gridCellCopyNames = "//td[text()='Test500']";
    WebDriver driver;


    public ManageReportsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickOnCreateButton() {

        GenericBrowserActionMethods.click(driver, btnCreate);
    }

    public void enterReportDetails(String reportName, String ddStyleTemplateValue) {

        GenericBrowserActionMethods.input(driver, txtReportName, reportName);
        GenericBrowserActionMethods.click(driver, ddStyleTemplate);
        GenericBrowserActionMethods.click(driver, ddStyleTemplates);

    }

    public void clickOnSaveButton() {

        GenericBrowserActionMethods.click(driver, btnSave);
        JsWaiter.waitJQueryAngular();
    }

    public void enterName(String name) {

        GenericBrowserActionMethods.input(driver, txtName, name);
        GenericBrowserActionMethods.pressEnter(driver, txtName);
    }

    public void logout() {

        JsWaiter.waitJQueryAngular();
        GenericWaitMethods.waitFor(2000);
        GenericBrowserActionMethods.click(driver, ddLogout);
        GenericBrowserActionMethods.click(driver, btnLogout);

    }

    public void setChkBoxSelectTemplate() {

        GenericBrowserActionMethods.click(driver, chkBoxSelectTemplate);
    }

    public void setChkBoxCopySelectTemplateSelectTemplate() {

        GenericBrowserActionMethods.click(driver, chkBoxCopySelectTemplate);
    }

    public void clickOnEditTemplate() {

        GenericBrowserActionMethods.click(driver, lnkEditTemplate);
    }

    public void selectStatus() {

        GenericBrowserActionMethods.click(driver, ddStatus);
        GenericBrowserActionMethods.click(driver, ddStatusValue);

    }

    public void copyTemplate() {

        GenericBrowserActionMethods.click(driver, lnkCopyTemplate);
    }

    public void enterUniqueReportName(String reportName) {

        GenericBrowserActionMethods.clearField(driver, txtReportName);
        GenericBrowserActionMethods.input(driver, txtReportName, reportName);
        GenericBrowserActionMethods.click(driver, txtDescription);
        JsWaiter.waitJQueryAngular();

    }

    public void deleteTemplates() {

        GenericBrowserActionMethods.click(driver, btnDelete);
        GenericBrowserActionMethods.click(driver, btnOk);
    }

}
