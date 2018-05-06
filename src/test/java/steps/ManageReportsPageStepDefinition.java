package steps;

import contexts.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import framework.base.Browser;
import framework.controls.GenericBrowserActionMethods;
import framework.helper.Helper;
import framework.utilities.CucumberUtil;
import org.testng.Assert;
import pages.ManageReportsPage;

public class ManageReportsPageStepDefinition extends Browser {


    ManageReportsPage manageReports;
    TestContext testContext;


    public ManageReportsPageStepDefinition(TestContext context) {
        testContext = context;
        manageReports = testContext.getPageObjectManager().getManageReportsPage();
    }


    @And("^Click on Create Button$")
    public void click_on_Create_Button() {

        manageReports.clickOnCreateButton();
    }

    @And("^On the popup fill required details$")
    public void on_the_popup_fill_required_details(DataTable table) {

        CucumberUtil.ConvertDataTableToDict(table);
        manageReports.enterReportDetails(CucumberUtil.GetCellValue("ReportName", 1), CucumberUtil.GetCellValue("StyleTemplateValue", 1));

    }

    @And("^Click on Save Button$")
    public void click_on_Save_Button() {

        manageReports.clickOnSaveButton();
    }

    @And("^In the name column enter name entered previously$")
    public void in_the_name_column_enter_name_entered_previously(DataTable table) {

        CucumberUtil.ConvertDataTableToDict(table);
        manageReports.enterName(CucumberUtil.GetCellValue("ReportName", 1));

    }

    @Then("^Verify whether Template is present$")
    public void verify_whether_Template_is_present() {

        Assert.assertEquals(GenericBrowserActionMethods.getElementText(Browser.getDriver(), manageReports.gridCellName), "Test5001");

        //Assert.assertEquals(Helper.getElement(Browser.getDriver(), manageReports.gridCellName).getText(), "Test5001");

    }

    @And("^Logout from the application$")
    public void logout_from_the_application() {

        manageReports.logout();
    }

    @And("^Select Template created in first Scenario$")
    public void select_Template_created_in_first_Scenario() {

        manageReports.setChkBoxSelectTemplate();
    }

    @And("^Select Status Ready to Assign$")
    public void select_status_ready_to_assign() {

        manageReports.selectStatus();
    }

    @And("^Click on edit template icon$")
    public void click_on_edit_template_icon() {

        manageReports.clickOnEditTemplate();

    }


    @And("^Vefiy whether the status is Ready to Assign$")
    public void vefiy_whether_the_status_is_Ready_to_Assign() {

        System.out.println(Helper.getElement(Browser.getDriver(), manageReports.gridCellStatus).getText());
        Assert.assertEquals(GenericBrowserActionMethods.getElementText(Browser.getDriver(), manageReports.gridCellStatus), "Ready To Assign");

        //Assert.assertEquals(Helper.getElement(Browser.getDriver(), manageReports.gridCellStatus).getText(), "Ready To Assign");

    }

    @And("^Click on the copy template icon$")
    public void click_On_Copy_Template() {

        manageReports.copyTemplate();
    }

    @And("^On the popup fill unique name$")
    public void fill_Unique_Name(DataTable table) {

        CucumberUtil.ConvertDataTableToDict(table);
        manageReports.enterUniqueReportName(CucumberUtil.GetCellValue("ReportName", 1));

    }

    @Then("^Verify whether Template Copy is present$")
    public void verify_whether_Template_Copy_is_present() {

        System.out.println(Helper.getElement(Browser.getDriver(), manageReports.gridCopyCellName).getText());
        Assert.assertEquals(GenericBrowserActionMethods.getElementText(Browser.getDriver(), manageReports.gridCopyCellName), "Test500");
        // Assert.assertEquals(Helper.getElement(Browser.getDriver(), manageReports.gridCopyCellName).getText(), "Test50012");

    }

    @And("^Select Template created in second Scenario$")
    public void select_template_second_scenario() {

        manageReports.setChkBoxCopySelectTemplateSelectTemplate();

    }

    @And("^Click on Delete as well as Ok button$")
    public void click_Delete_Ok_Button() {

        manageReports.deleteTemplates();

    }

    @Then("^Verify whether created templates are not present$")
    public void verify_whether_Template_Copies_are_not_present() {

        Assert.assertTrue(GenericBrowserActionMethods.isElementNotPresent(Browser.getDriver(), manageReports.gridCellNames));
        Assert.assertTrue(GenericBrowserActionMethods.isElementNotPresent(Browser.getDriver(), manageReports.gridCellCopyNames));


    }
}
