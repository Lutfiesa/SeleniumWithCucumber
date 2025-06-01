package com.lutfi.stepdef;

import com.lutfi.page.HomePage;
import com.lutfi.BaseTest;
import com.lutfi.page.CartPage;
import com.lutfi.page.CheckoutOverviewPage;
import com.lutfi.page.CheckoutYourInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStep  extends BaseTest {

    CartPage cartPage = new CartPage(driver);
    HomePage homePage;
    CheckoutYourInfoPage checkoutInfoPage = new CheckoutYourInfoPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    @Given("user is on the cart page")

    @And("user clicks the cart icon")
    public void userClickCartPage() {
        homePage = new HomePage(driver);
        homePage.clickCart();
    }

    @When("user clicks the Checkout button")
    public void userClicksTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Then("user should be on the checkout information page")
    public void userOnInformationPage() {
        checkoutInfoPage.validateOnCheckoutInfoPage();
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String firstname) {
        checkoutInfoPage.setInputFirstname(firstname);
    }

    @And("user enters last name {string}")
    public void userEntersLastName(String lastname) {
        checkoutInfoPage.setInputLastname(lastname);
    }

    @And("user enters postal code {string}")
    public void userEntersPostalCode(String zipcode) {
        checkoutInfoPage.setInputZipCode(zipcode);
    }

    @When("user clicks the Continue button")
    public void userClicksTheContinueButton() {
        checkoutInfoPage.clickContinueButton();
    }

    @Then("user should be on the checkout overview page")
    public void userOnOverviewPage() {
        checkoutOverviewPage.validateOnCheckoutOverviewPage();
    }

    @Then("user should see a error message {string}")
    public void userShouldSeeAErrorMessage(String errorMessage) {
        checkoutInfoPage.validateErrorClickContinueAppear(errorMessage);
    }

    @When("user clicks the Finish button")
    public void userClicksTheFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String successMessage) {
        checkoutOverviewPage.validateSuccessClickFinishAppear(successMessage);
    }

}
