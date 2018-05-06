package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.base.Browser;
import framework.config.ConfigReader;
import framework.utilities.LogUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(features = "Features", glue = {"steps"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty", "rerun:target/rerun.txt"}
        , tags = {"~@ignore"})
public class TestRunner extends AbstractTestNGCucumberTests {


    @Parameters({"browser"})
    @BeforeClass
    public static void beforeSetup(String browser) throws Exception {

        System.out.println("Setting the properties");
        ConfigReader.populateProperties();
        LogUtil.setLogger();
        LogUtil.info("Setting the properties");

        LogUtil.info("Set the browser");
        Browser.setBrowser(browser);


    }


    @AfterClass
    public void shutDown() throws Exception {

        LogUtil.info("Shut the browser");
        Browser.shutBrowser();

    }

}
