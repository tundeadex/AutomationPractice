package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMyStorePage extends BasePage {

    public LoginMyStorePage(WebDriver driver) {
        super(driver);
    }

    private WebElement createEmailAddressElement() {
        return this.driver.findElement(By.id("email_create"));
    }

    private WebElement logInEmailAddressElement() {
        return this.driver.findElement(By.id("email"));
    }

    private WebElement logInPasswordElement() {
        return this.driver.findElement(By.id("passwd"));
    }

    private WebElement logInButton() {
        return this.driver.findElement(By.id("SubmitLogin"));
    }

    private WebElement createAccountButtonElement() {
        return this.driver.findElement(By.id("SubmitCreate"));
    }

    public void createAccount(String email) {
        createEmailAddressElement().sendKeys(email);
        createAccountButtonElement().click();
    }

    public void signIn(String emailAddress, String password) {
        logInEmailAddressElement().sendKeys(emailAddress);
        logInPasswordElement().sendKeys(password);
        logInButton().click();
    }
}
