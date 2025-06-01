package com.lutfi.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {

    By CheckoutOverView = By.xpath("//span[@class='title' and contains(text(),'Checkout: Overview')]");
    By CheckoutCompletePage = By.xpath("//h2[@class='complete-header' and text()='Thank you for your order!']");
    By buttonFinish = By.id("finish");

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void validateOnCheckoutOverviewPage() {
        WebElement textCheckoutOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutOverView));
        Assert.assertTrue(textCheckoutOverview.isDisplayed());
        Assert.assertEquals("Checkout: Overview", textCheckoutOverview.getText());
    }

    public void clickFinishButton() {
        WebElement finishButton = driver.findElement(buttonFinish);
        Assert.assertTrue(finishButton.isDisplayed());
        finishButton.click();
    }

    public void validateSuccessClickFinishAppear(String succesMessage) {
        WebElement textCheckoutOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutCompletePage));
        Assert.assertEquals(succesMessage, textCheckoutOverview.getText());
    }

}
