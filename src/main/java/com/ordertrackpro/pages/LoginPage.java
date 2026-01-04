package com.ordertrackpro.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement invalidLoginMessage;



    public boolean isInvalidLoginMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(invalidLoginMessage));
        return invalidLoginMessage.isDisplayed();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isDashboardDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardHeader));
        return dashboardHeader.isDisplayed();
    }
}
