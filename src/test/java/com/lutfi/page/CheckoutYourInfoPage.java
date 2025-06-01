package com.lutfi.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutYourInfoPage {

    By CheckoutInfoPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By FirstName = By.id("first-name");
    By LastName = By.id("last-name");
    By ZipCode = By.id("postal-code");
    By buttonContinue = By.xpath("//input[@id='continue']");

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutYourInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void validateOnCheckoutInfoPage() {
        WebElement textCheckoutInfoPage = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutInfoPage));
        assertTrue(textCheckoutInfoPage.isDisplayed());
        assertEquals("Checkout: Your Information", textCheckoutInfoPage.getText());
    }

    public void setInputFirstname(String firstname){
        driver.findElement(FirstName).sendKeys(firstname);
    }
    public void setInputLastname(String lastname){
        driver.findElement(LastName).sendKeys(lastname);
    }
    public void setInputZipCode(String zipCode){
        driver.findElement(ZipCode).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(buttonContinue);
        assertTrue(continueButton.isDisplayed());
        continueButton.click();
    }

    public void validateErrorClickContinueAppear(String errorMessage) {
        assertTrue(driver.getPageSource().contains(errorMessage));
    }

}
