package steps;

import contexts.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import framework.base.Browser;
import framework.controls.GenericBrowserActionMethods;
import org.testng.Assert;
import pages.AccountHoldingsPage;

import java.math.BigDecimal;

public class AccountsHoldingPageStepDefinition extends Browser {

    AccountHoldingsPage accountHoldingsPage;
    TestContext testContext;


    public AccountsHoldingPageStepDefinition(TestContext context) {
        testContext = context;
        accountHoldingsPage = testContext.getPageObjectManager().getAccountHoldingsPage();
    }

    @And("^Select account as \"([^\"]*)\"$")
    public void select_account_as(String accountName) {

        accountHoldingsPage.selectAccount(accountName);

    }

    @And("^Save the USD Value$")
    public void save_usd_value() {

        accountHoldingsPage.saveUSDValue();

    }

    @And("^Sum up the values from Contract Type Headers$")
    public void sum_values_contract_type_headers() {

        accountHoldingsPage.sumContractTypeHeaderValues();

    }

    @Then("^Verify whether Current Value USD is present$")
    public void verify_whether_Current_USD_Value_present() {

        Assert.assertTrue(GenericBrowserActionMethods
                .isElementPresentWithoutFailingTest
                        (Browser.getDriver(), accountHoldingsPage.valCurrentUsdValue));

    }

    @Then("^Verify whether Current Value USD is equal to sum$")
    public void verify_current_usd_value_equalto_sum() {

        Assert.assertEquals(BigDecimal.valueOf(accountHoldingsPage.usdValue).setScale(2, BigDecimal.ROUND_HALF_DOWN),
                BigDecimal.valueOf(accountHoldingsPage.total).setScale(2, BigDecimal.ROUND_HALF_DOWN));


    }

}
