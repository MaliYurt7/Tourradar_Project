package com.tourradar.pages;

import com.tourradar.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    public WebElement accountType(String acocuntTypes) {
        String accType = "//label[contains(text(),'" + acocuntTypes + "')]";
        return Driver.getDriver().findElement(By.xpath(accType));
    }

    @FindBy(css="ul div input[id='traveller']")
    public WebElement checkTravellerBtn;

    public WebElement clickBtns(String btnName) {
        String btn="//a[contains(text(),'"+btnName+"')]";
        return Driver.getDriver().findElement(By.xpath(btn));
    }

    @FindBy(css="span.initials")
    public WebElement getProfileLink;


    public WebElement getProfileName(String userName){
        String user= "//h4[contains(text(),'"+userName+"')]";
        return Driver.getDriver().findElement(By.xpath(user));
    }

    @FindBy(xpath="//a[@href='/account']")
    public WebElement getMyAccountLink;


    @FindBy(css="p.ao-profile-top__profile-details-email")
    public WebElement getEmailAddress;

    @FindBy(css="span.js-ao-profile-tours-carousel__wishlist.ao-profile-tours-carousel__wishlist")
    public List<WebElement> heartIcons;

    @FindBy(css="h3.ao-profile-tours-carousel__title")
    public List<WebElement> getTourTitleName;

    @FindBy(xpath = "(//span[@class='icon'])[1]")
    public WebElement popupHeartIcon;

    @FindBy(xpath = "//span[@class='name']/..")
    public WebElement clickSavedTours;

    @FindBy(css = "button.mfp-close")
    public WebElement getPopupCloseBtn;

    @FindBy(css = "div.info h3")
    public WebElement getPopupTourTitleName;

    @FindBy(xpath = "//a[text()='Done']")
    public WebElement getDoneBtn;

    @FindBy(xpath = "//li[contains(@class,'desktop')]//a[contains(@class,'js-wishlist-tours')]")
    public WebElement getWishistsToursIcons;

    @FindBy(css = "div.sbtn.cpr.active")
    public List<WebElement> getWishlistsTours;

    @FindBy(css = "li.active")
    public WebElement unsavedWishlistsTour;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement getLogOutBtn;







}



