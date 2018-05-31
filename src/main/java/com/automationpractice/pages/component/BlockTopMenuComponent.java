package com.automationpractice.pages.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class BlockTopMenuComponent {

    private WebDriver driver;

    public BlockTopMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategory(String category) {
        String selector = String.format("#block_top_menu li a[title='%s']", category);
        List<WebElement> elements = this.driver.findElements(By.cssSelector(selector));
        List<WebElement> visibleWebElements = elements.stream().filter(e -> e.isDisplayed()).collect(Collectors.toList());
        visibleWebElements.get(0).click();
    }


}
