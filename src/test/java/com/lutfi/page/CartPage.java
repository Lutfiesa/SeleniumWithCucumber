package com.lutfi.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    By PageCart = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By buttonCheckout = By.xpath("//button[@id='checkout']");

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validateOnCartPage() {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(PageCart, "Your Cart"));
        WebElement textCart = driver.findElement(PageCart);
        Assert.assertTrue(textCart.isDisplayed());
        Assert.assertEquals("Your Cart", textCart.getText());
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(buttonCheckout);
        Assert.assertTrue(checkoutButton.isDisplayed());
        checkoutButton.click();
    }


}