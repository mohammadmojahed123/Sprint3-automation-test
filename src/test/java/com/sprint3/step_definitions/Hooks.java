package com.sprint3.step_definitions;

import com.sprint3.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDownScenario(Scenario scenario){

        if (scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());

        }

        //BrowserUtils.sleep(5);
        Driver.closeDriver();

    }
}
