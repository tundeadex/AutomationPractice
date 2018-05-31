package com.automationpractice.pages;

import com.automationpractice.pages.component.BlockTopMenuComponent;
import com.automationpractice.pages.component.NavComponent;
import com.automationpractice.pages.component.ShoppingCartComponent;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    public NavComponent navComponent;
    public BlockTopMenuComponent blockTopMenuComponent;
    public ShoppingCartComponent shoppingCartComponent;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        navComponent = new NavComponent(this.driver);
        blockTopMenuComponent = new BlockTopMenuComponent(this.driver);
        shoppingCartComponent = new ShoppingCartComponent(this.driver);
    }

    public boolean isSignedIn() {
        return this.navComponent.signOutElementIsVisible();
    }



}
