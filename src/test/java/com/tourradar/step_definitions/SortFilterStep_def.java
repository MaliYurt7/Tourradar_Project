package com.tourradar.step_definitions;

import com.tourradar.pages.SortFilterPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.tourradar.utilities.BrowserUtils.dropdownOptionsAsString;
import static org.junit.Assert.assertEquals;

public class SortFilterStep_def {

    SortFilterPage sortFilterPage = new SortFilterPage();

    String expectedOption;
    String actualOption;


    @When("The user clicks the Sort by filter dropdown")
    public void the_user_clicks_the_sort_by_filter_dropdown() {
        sortFilterPage.sortFilterDropdown.click();
    }

    @When("the user should able to see the following list")
    public void the_user_should_able_to_see_the_following_list(List<String> sortFilterList) {

        dropdownOptionsAsString(sortFilterPage.sortFilterDropdown);
//        List<String> dropdown_list = new ArrayList<>();
//        Select sortFilterDropDownList = new Select(sortFilterPage.sortFilterDropdown);
//        List<WebElement> options = sortFilterDropDownList.getOptions();
//        for (WebElement option : options) {
//            dropdown_list.add(option.getText());
//        }

        assertEquals(dropdownOptionsAsString(sortFilterPage.sortFilterDropdown), sortFilterList);


    }

    @When("The user selects one option from dropdown by {string} standing for {string}")
    public void the_user_selects_one_option_from_dropdown_by_standing_for(String value, String abbrOfValue) {
        Select sortFilterDropDownList = new Select(sortFilterPage.sortFilterDropdown);
        List<WebElement> options = sortFilterDropDownList.getOptions();
        sortFilterDropDownList.selectByValue(value);
        expectedOption = abbrOfValue;
        actualOption = sortFilterDropDownList.getFirstSelectedOption().getText();
        assertEquals(actualOption, expectedOption);
    }

}
