package com.tourradar.step_definitions;

import com.tourradar.pages.WishListPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.tourradar.utilities.BrowserUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WishListPageStep_def {

    WishListPage myAccountPage = new WishListPage();
    public List<String> tourTitleName = new ArrayList<>();
    public List<String> popupTourTitleName = new ArrayList<>();

    @Then("Validate that page title should be {string}")
    public void validate_that_page_title_should_be(String expectedTitle) {
        waitForPresenceOfElement(By.tagName("title"), 25);
        verifyTitle(expectedTitle);
    }

    @Then("Validate that the {string} should displayed in profile account")
    public void validate_that_the_should_displayed_in_profile_account(String userName) {
        hover(myAccountPage.getProfileLink);
        assertTrue(myAccountPage.getProfileName(userName).getAttribute("textContent").contains(userName));
    }

    @Then("The user clicks the {string} link")
    public void the_user_clicks_the_link(String links) {
        if (links.equalsIgnoreCase("My Account")) {
            clickWithJS(myAccountPage.getMyAccountLink);
        } else if (links.equalsIgnoreCase("Logout")) {
            clickWithJS(myAccountPage.getLogOutBtn);
        }
    }

    @Then("Validate that the {string} and {string} address should be displayed")
    public void validate_that_the_and_address_should_be_displayed(String userName, String emailAddress) {
        assertTrue(myAccountPage.getProfileName(userName).getAttribute("textContent").contains(userName));
        assertTrue(myAccountPage.getEmailAddress.getAttribute("textContent").contains(emailAddress));
    }

    @Then("The user clicks  the {string} heart icon in Recomended Tours to save")
    public void the_user_clicks_the_heart_icon_in_recomended_tours_to_save(String numthOfHeartToBeSelected) {
        if (numthOfHeartToBeSelected.contains(";")) {
            String[] numthOfHeartToBeSelect = numthOfHeartToBeSelected.split(";");
            for (int j = 0; j < numthOfHeartToBeSelect.length; j++) {
                for (int i = 0; j < myAccountPage.heartIcons.size(); i++) {
                    if (i == (Integer.parseInt(numthOfHeartToBeSelect[j]) - 1)) {
                        String x = myAccountPage.getTourTitleName.get(i).getText();
                        tourTitleName.add(x);
                        clickWithJS(myAccountPage.heartIcons.get(i));
                        waitForClickablility(myAccountPage.clickSavedTours, 25);
                        clickWithJS(myAccountPage.clickSavedTours);
                        popupTourTitleName.add(myAccountPage.getPopupTourTitleName.getText());
                        clickWithJS(myAccountPage.getDoneBtn);
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < myAccountPage.heartIcons.size(); i++) {
                if (i == Integer.parseInt(numthOfHeartToBeSelected) - 1) {
                    String x = myAccountPage.getTourTitleName.get(i).getText();
                    tourTitleName.add(x);
                    clickWithJS(myAccountPage.heartIcons.get(i));
                    clickWithJS(myAccountPage.popupHeartIcon);
                    popupTourTitleName.add(myAccountPage.getPopupTourTitleName.getText());
                    clickWithJS(myAccountPage.getDoneBtn);
                    break;
                }
            }

        }
        assertEquals(tourTitleName, popupTourTitleName);
    }

    @Then("the user remove  already saved all tours from wishlist")
    public void the_user_remove_already_saved_all_tours_from_wishlist() {
        tourTitleName.add("mali");
        clickWithJS(myAccountPage.getWishistsToursIcons);
        for (WebElement eachWishlistsTour : myAccountPage.getWishlistsTours) {
            waitForClickablility(eachWishlistsTour, 25);
            clickWithJS(eachWishlistsTour);
            waitForClickablility(myAccountPage.unsavedWishlistsTour, 25);
            clickWithJS(myAccountPage.unsavedWishlistsTour);
            clickWithJS(myAccountPage.getPopupCloseBtn);
        }
        assertTrue(myAccountPage.getWishlistsTours.size() == 0);
    }

}
