package com.automationpractice.pages.component;

import com.automationpractice.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartComponent {

    private WebDriver driver;

    public ShoppingCartComponent(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement baseElement() {
        return this.driver.findElement(By.cssSelector("div.shopping_cart"));
    }

    private WebElement expandCollapseButtonElement() {
        return baseElement().findElement(By.cssSelector("span.ajax_cart_quantity"));
    }

    private WebElement openedCartElement() {
        return this.driver.findElement(By.cssSelector("div.cart_block"));
    }

    private void hoverCart() {
        Actions builder = new Actions(driver);
        builder.moveToElement(expandCollapseButtonElement()).perform();
    }

    public boolean productInCart(ProductModel productModel) {
        hoverCart();
        String selector = String.format("a[title='%s']", productModel.name);
        boolean productIsDisplayed = openedCartElement().findElement(By.cssSelector(selector)).isDisplayed();
        return productIsDisplayed;
    }

    public boolean cartEmpty() {
        return baseElement().findElement(By.cssSelector("span.ajax_cart_no_product")).isDisplayed();
    }
}
