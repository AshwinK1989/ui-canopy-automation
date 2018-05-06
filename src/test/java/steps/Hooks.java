package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import framework.base.Browser;
import framework.utilities.CaptureScreenShotUtil;

public class Hooks extends Browser {


    @After
    public void shutDown(Scenario scenario) {

        if (scenario.isFailed()) {

            CaptureScreenShotUtil.captureScreen(scenario.getName());

        }

    }
}
