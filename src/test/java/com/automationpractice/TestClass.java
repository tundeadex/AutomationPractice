package com.automationpractice;

import com.automationpractice.models.ProductModel;
import com.automationpractice.models.User;
import com.automationpractice.pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestClass {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = Helpers.getChromeDriverInstance();
        driver.navigate().to("http://automationpractice.com");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void createAccountAddMostExpensiveDressAssertItsAddedToBasketSignOutAndBackIn() {
        User user = User.getDefault();
        // sign in
        HomePage homePage = new HomePage(driver);
        homePage.navComponent.selectSignIn();

        // create account
        LoginMyStorePage loginMyStorePage = new LoginMyStorePage(driver);
        loginMyStorePage.createAccount(user.emailAddress);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.create(user);

        // ensure account created and signed in
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.isSignedIn());

        // select Dresses category
        myAccountPage.blockTopMenuComponent.selectCategory("Dresses");

        // add most expensive dress to cart and assert successfully added
        ProductsPage productsPage = new ProductsPage(driver);
        ProductModel mostExpensiveItem = productsPage.mostExpensiveItem();
        Assert.assertTrue(productsPage.layerCartComponent.productAdded(mostExpensiveItem));
        productsPage.layerCartComponent.closeWindow();

        // check product is in cart
        boolean productInCart = productsPage.shoppingCartComponent.productInCart(mostExpensiveItem);
        Assert.assertTrue(productInCart);

        //sign out and assert cart empty
        productsPage.navComponent.selectSignOut();
        boolean cartEmpty = productsPage.shoppingCartComponent.cartEmpty();
        Assert.assertTrue(cartEmpty);

        //sign in again
        homePage.navComponent.selectSignIn();
        loginMyStorePage.signIn(user.emailAddress, user.password);
        Assert.assertTrue(myAccountPage.isSignedIn());

        //you asked to assert that items are still in basket but they are not after signing back in
        boolean productStillInCart = myAccountPage.shoppingCartComponent.productInCart(mostExpensiveItem);
        Assert.assertTrue(productStillInCart);
    }
}
