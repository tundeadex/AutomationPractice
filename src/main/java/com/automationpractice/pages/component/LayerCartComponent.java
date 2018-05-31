package com.automationpractice.pages.component;

import com.automationpractice.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartComponent {

    private WebDriver driver;

    public LayerCartComponent(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement baseElement() {
        return this.driver.findElement(By.id("layer_cart"));
    }

    public boolean productAdded(ProductModel product) {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        String layerCartProductTitleSelector = "layer_cart_product_title";
        String layerCartPriceSelector = "layer_cart_product_price";

        wait.until(ExpectedConditions.textToBe(By.id(layerCartProductTitleSelector), product.name));
        String productName = baseElement().findElement(By.id(layerCartProductTitleSelector)).getText();
        String productPrice = baseElement().findElement(By.id(layerCartPriceSelector)).getText();
        return productName.equals(product.name) && productPrice.endsWith(product.price.toString());
    }

    public void closeWindow() {
        baseElement().findElement(By.cssSelector("span[title='Close window']")).click();
    }
}
