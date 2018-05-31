package com.automationpractice.pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavComponent {

    private WebDriver driver;

    private WebElement signInElement() {
        return this.driver.findElement(By.cssSelector("a.login"));
    }

    private WebElement signOutElement() {
        return this.driver.findElement(By.cssSelector("a.logout"));
    }

    public NavComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSignIn() {
        signInElement().click();
    }

    public void selectSignOut() {
        signOutElement().click();
    }

    public boolean signOutElementIsVisible() {
        return signOutElement().isDisplayed();
    }

}
