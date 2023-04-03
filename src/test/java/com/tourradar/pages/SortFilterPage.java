package com.tourradar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortFilterPage extends BasePage {

    @FindBy(name = "sort")
    public WebElement sortFilterDropdown;

}
