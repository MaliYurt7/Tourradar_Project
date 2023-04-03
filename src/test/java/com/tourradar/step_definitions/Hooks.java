package com.tourradar.step_definitions;


import com.tourradar.utilities.BrowserUtils;
import com.tourradar.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.tourradar.utilities.BrowserUtils.clickWithJS;
import static com.tourradar.utilities.BrowserUtils.waitFor;

public class Hooks {

    @Before
    public void setUp() {
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        BrowserUtils.sleep(5);
        Driver.closeDriver();
    }

    @BeforeStep
    public void testBeforeStep() {
        List<WebElement> cookie = Driver.getDriver().findElements(By.xpath("//button[contains(text(),'Accept All Cookies')]"));
        waitFor(2);
        if (cookie.size()>0) {
            try {
                clickWithJS(cookie.get(0));
            } catch (Exception e) {
                System.out.println("*********************************Exception Hook");
            }
        }else{
            System.out.println("COOKIE SETUP IS DISPLAYED FOR THIS PAGE" );
        }

    }


}
