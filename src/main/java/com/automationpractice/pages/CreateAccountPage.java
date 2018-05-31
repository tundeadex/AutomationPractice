package com.automationpractice.pages;

import com.automationpractice.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private WebElement mrElement() {
        return this.driver.findElement(By.cssSelector("label[for='id_gender1']"));
    }

    private WebElement mrsElement() {
        return this.driver.findElement(By.cssSelector("label[for='id_gender2']"));
    }

    private WebElement firstNameElement() {
        return this.driver.findElement(By.id("customer_firstname"));
    }

    private WebElement lastNameElement() {
        return this.driver.findElement(By.id("customer_lastname"));
    }

    private WebElement emailElement() {
        return this.driver.findElement(By.id("email"));
    }

    private WebElement passwordElement() {
        return this.driver.findElement(By.id("passwd"));
    }

    private WebElement dobDayElement() {
        return this.driver.findElement(By.id("days"));
    }

    private WebElement dobMonthElement() {
        return this.driver.findElement(By.id("months"));
    }

    private WebElement dobYearElement() {
        return this.driver.findElement(By.id("years"));
    }

    private WebElement addressFirstNameElement() {
        return this.driver.findElement(By.id("firstname"));
    }

    private WebElement addressLastNameElement() {
        return this.driver.findElement(By.id("lastname"));
    }

    private WebElement addressLine1Element() {
        return this.driver.findElement(By.id("address1"));
    }

    private WebElement cityElement() {
        return this.driver.findElement(By.id("city"));
    }

    private WebElement stateElement() {
        return this.driver.findElement(By.id("id_state"));
    }

    private WebElement zipPostalCodeElement() {
        return this.driver.findElement(By.id("postcode"));
    }

    private WebElement countryElement() {
        return this.driver.findElement(By.id("id_country"));
    }

    private WebElement mobilePhoneElement() {
        return this.driver.findElement(By.id("phone_mobile"));
    }

    private WebElement addressAliasElement() {
        return this.driver.findElement(By.id("alias"));
    }

    private WebElement registerElement() {
        return this.driver.findElement(By.id("submitAccount"));
    }

    private void selectDobDay(int day) {
        Select select = new Select(dobDayElement());
        select.selectByValue(Integer.toString(day));
    }

    private void selectDobMonth(int month) {
        Select select = new Select(dobMonthElement());
        select.selectByValue(Integer.toString(month));
    }

    private void selectDobYear(int year) {
        Select select = new Select(dobYearElement());
        select.selectByValue(Integer.toString(year));
    }

    private void selectState(String state) {
        Select select = new Select(stateElement());
        select.selectByVisibleText(state);
    }

    private void selectCountry(String country) {
        Select select = new Select(countryElement());
        select.selectByVisibleText(country);
    }

    public void create(User user) {
        if (user.title.equals("Mr")) {
            mrElement().click();
        } else {
            mrsElement().click();
        }

        firstNameElement().sendKeys(user.firstName);
        lastNameElement().sendKeys(user.lastName);
        passwordElement().sendKeys(user.password);

        selectDobDay(user.dateOfBirth.getDayOfMonth());
        selectDobMonth(user.dateOfBirth.getMonthValue());
        selectDobYear(user.dateOfBirth.getYear());

        addressFirstNameElement().sendKeys(user.firstName);
        addressLastNameElement().sendKeys(user.lastName);
        addressLine1Element().sendKeys(user.address.addressLine1);
        cityElement().sendKeys(user.address.city);

        selectState(user.address.state);
        zipPostalCodeElement().sendKeys(user.address.zipPostalCode);
        selectCountry(user.address.country);

        mobilePhoneElement().sendKeys(user.mobilePhone);

        registerElement().click();


    }


}
