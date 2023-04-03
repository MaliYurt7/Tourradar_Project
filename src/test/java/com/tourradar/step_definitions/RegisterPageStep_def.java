package com.tourradar.step_definitions;

import com.tourradar.pages.WishListPage;
import com.tourradar.utilities.ConfigurationReader;
import com.tourradar.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import static com.tourradar.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

public class RegisterPageStep_def {

    WishListPage myAccountPage = new WishListPage();

    @Given("The user is on the main page")
    public void the_user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("nav.tourradarURL"));
    }

    @When("The user goes to {string} module")
    public void the_user_goes_to_module(String moduleName) {
        if (moduleName.equalsIgnoreCase("profile")) {
            hover(myAccountPage.profileIcon);
        }

    }

    @When("The user clicks {string} btn as a {string}")
    public void the_user_clicks_btn_as_a(String btnType, String registerType) {
        if (btnType.equalsIgnoreCase("Sign Up")) {
            clickWithJS(myAccountPage.accountType(registerType));
            waitForPresenceOfElement(By.xpath("//ul//div//input[@checked='true']"), 25);
            assertTrue(myAccountPage.checkTravellerBtn.getAttribute("outerHTML").contains("checked=\"true\""));
            assertEquals(registerType, myAccountPage.accountType(registerType).getAttribute("textContent").trim());
            clickWithJS(myAccountPage.clickBtns(btnType));
        } else if (btnType.equalsIgnoreCase("Log In")) {
            clickWithJS(myAccountPage.accountType(registerType));
            waitForPresenceOfElement(By.xpath("//ul//div//input[@checked='true']"), 25);
            assertTrue(myAccountPage.checkTravellerBtn.getAttribute("outerHTML").contains("checked=\"true\""));
            assertEquals(registerType, myAccountPage.accountType(registerType).getAttribute("textContent").trim());
            clickWithJS(myAccountPage.clickBtns(btnType));

        }
    }
}
