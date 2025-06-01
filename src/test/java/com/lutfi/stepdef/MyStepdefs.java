package com.lutfi.stepdef;

import com.lutfi.BaseTest;
import com.lutfi.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs extends BaseTest {

    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("user input username with {string}")
    public void userInputEmailWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.loginButton();
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMassage) {
        loginPage.userAbleToSeeErrorMessage(errorMassage);
    }
}
