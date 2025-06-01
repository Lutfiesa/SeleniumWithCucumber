package com.lutfi.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    By InputUsername = By.xpath("//input[@id='user-name']");
    By InputPassword = By.xpath("//input[@id='password']");
    By ButtonLogin = By.xpath("//input[@id='login-button']");
    By LoginPage = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        driver.findElement(InputUsername).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(InputPassword).sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(ButtonLogin).click();
    }

    public void userAbleToSeeErrorMessage(String errorMassage) {
        Assert.assertTrue(driver.getPageSource().contains(errorMassage));
    }

}
