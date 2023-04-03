package com.tourradar.step_definitions;

import com.tourradar.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;

import static com.tourradar.utilities.BrowserUtils.*;
import static org.junit.Assert.assertEquals;

public class LoginPageStep_def {

    LoginPage loginPage =new LoginPage();

    @When("The user navigates to {string} page")
    public void the_user_navigates_to_page(String expectedTitle) {
        verifyTitle(expectedTitle);
    }
    @When("The user fills the login form with {string} and {string} and clicks {string} btn")
    public void the_user_fills_the_login_form_with_and_and_clicks_btn(String email, String password, String logInBtn) {
        loginPage.setEmail.sendKeys(email);
        loginPage.setPassword.sendKeys(password);
        clickWithJS(loginPage.clickLogInBtn);
    }

    @Then("Validate that {string} message should be showed up")
    public void validate_that_message_should_be_showed_up(String wrongLoginData) {
        waitForPresenceOfElement(By.xpath("//div[text()='Wrong login data.']"),15);
        assertEquals(wrongLoginData, loginPage.getWrongLoginDataMsg.getText());

    }

}
