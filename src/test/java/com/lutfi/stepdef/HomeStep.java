package com.lutfi.stepdef;

import com.lutfi.page.HomePage;
import com.lutfi.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep extends BaseTest{

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
        //homePage.getEvidance();
    }

    @When("user clicks {string} button for Item")
    public void userClicksButtonFor(String buttonText) throws InterruptedException {
        homePage.addItemToCart();
    }

    @Then("the button should change to {string}")
    public void theButtonShouldChangeTo(String buttonTextChangeRemove) {
        homePage.validateRemoveButtonVisible();
    }

    @And("cart count should increase by {int}")
    public void cartCountShouldIncreaseBy(int count) {
        homePage.validateCartCount(count);
    }
}
