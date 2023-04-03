package com.tourradar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "g_email")
    public WebElement setEmail;

    @FindBy(id = "g_password")
    public WebElement setPassword;

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    public WebElement clickLogInBtn;

    @FindBy(id = "message-sign-in")
    public WebElement getWrongLoginDataMsg;

}
