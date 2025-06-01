package com.lutfi.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomePage {

    By HomePage = By.xpath("(//div[normalize-space()='Sauce Labs Backpack'])[1]");
    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By imageChart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By productRemove = By.id("remove-sauce-labs-backpack");

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public void validateOnHomePage() {
        WebElement HomePageElement = driver.findElement(HomePage);
        Assert.assertTrue(HomePageElement.isDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", HomePageElement.getText());
    }

    public void addItemToCart() throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(product1));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);

        Assert.assertTrue(addButton.isDisplayed());

        try {
            addButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(product1));
    }

    public void validateRemoveButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productRemove));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productRemove, "Remove"));
        WebElement removeButton = driver.findElement(productRemove);
        Assert.assertTrue(removeButton.isDisplayed());
        Assert.assertEquals("Remove", removeButton.getText());
    }

    public void validateCartCount(int expectedCount) {
        WebElement cartBadge = driver.findElement(imageChart);
        Assert.assertTrue(cartBadge.isDisplayed());
        Assert.assertEquals(String.valueOf(expectedCount), cartBadge.getText());
    }

    public void clickCart() {
        WebElement cartBadge = driver.findElement(imageChart);
        Assert.assertTrue(cartBadge.isDisplayed());
        cartBadge.click();
    }

    public void getEvidance() {

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "screenshot_" + timestamp + ".png";
            File targetFile = new File("screenshots/HomePage/" + fileName);
            targetFile.getParentFile().mkdirs();
            FileUtils.copyFile(screenshot, targetFile);

            System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
