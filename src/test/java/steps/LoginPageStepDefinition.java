package steps;

import contexts.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.base.Browser;
import framework.utilities.CucumberUtil;
import pages.LoginPage;

public class LoginPageStepDefinition extends Browser {

    LoginPage loginPage;
    TestContext testContext;


    public LoginPageStepDefinition(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() {

        loginPage.navigateToLoginPage();

    }

    @When("^I submit username and password$")
    public void i_submit_username_and_password(DataTable table) {

        CucumberUtil.ConvertDataTableToDict(table);

        loginPage.enterCredentials(CucumberUtil.GetCellValue("UserName", 1),
                CucumberUtil.GetCellValue("Password", 1));
    }

    @When("^I click on Login Button$")
    public void when_i_click_on_loginbutton() {

        loginPage.clickOnLoginButton();
    }

}
