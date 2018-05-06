package steps;

import contexts.TestContext;
import cucumber.api.java.en.Given;
import framework.base.Browser;
import pages.HelpPage;

public class HelpPageStepDefinition extends Browser {

    HelpPage helpPage;
    TestContext testContext;


    public HelpPageStepDefinition(TestContext context) {
        testContext = context;
        helpPage = testContext.getPageObjectManager().getHelpPage();
    }


    @Given("^You Traverse to report template Design$")
    public void you_Traverse_to_report_template_Design() {

        helpPage.clickOnReportsMenu();
        helpPage.clickOnReportTemplateDesign();
    }

    @Given("^You Traverse to Account Holdings$")
    public void you_Traverse_to_Account_Holdings() {

        helpPage.clickOnUserAccounts();
        helpPage.clickOnAccountHoldings();

    }


}
