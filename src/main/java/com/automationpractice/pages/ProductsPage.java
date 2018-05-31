package com.automationpractice.pages;

import com.automationpractice.models.ProductModel;
import com.automationpractice.pages.component.LayerCartComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    public LayerCartComponent layerCartComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.layerCartComponent = new LayerCartComponent(this.driver);
    }

    public List<WebElement> getProductItemsGrid() {
        return this.driver.findElements(By.cssSelector("div.product-container span.product-price"));
    }

    public BigDecimal convertPriceToBigDecimal(String price) {
        return new BigDecimal(price.substring(1));
    }

    public ProductModel mostExpensiveItem() {
        List<WebElement> productItemsGrid = getProductItemsGrid();
        BigDecimal highestPrice = productItemsGrid.stream()
                .filter(el -> el.isDisplayed() && el.getText().length() > 0)
                .map(it -> convertPriceToBigDecimal(it.getText()))
                .max(BigDecimal::compareTo)
                .get();

        String selector = String.format("//div[@class='product-container'][.//span[contains(text(), '%s')]]", highestPrice.toString());
        WebElement productContainerElement = this.driver.findElement(By.xpath(selector));
        String productName = productContainerElement.findElement(By.cssSelector("h5[itemprop='name']")).getText();
        productContainerElement.click();
        productContainerElement = this.driver.findElement(By.xpath(selector));

        WebElement addToCartElement = productContainerElement.findElements(By.xpath("//span[text()='Add to cart']"))
                .stream()
                .filter(WebElement::isDisplayed).collect(Collectors.toList())
                .get(0);

        addToCartElement.click();
        return new ProductModel(productName, highestPrice);
    }


}
