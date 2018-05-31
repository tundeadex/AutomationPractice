package com.automationpractice.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;

public class User {

    public String title;

    public String firstName;

    public String lastName;

    public String emailAddress;

    public LocalDate dateOfBirth;

    public String password;

    public String homePhone;

    public String mobilePhone;

    public Address address;

    public static User getDefault() {
        User user = new User();
        user.title = "Mr";
        user.firstName = RandomStringUtils.randomAlphabetic(12);
        user.lastName = RandomStringUtils.randomAlphabetic(15);
        user.emailAddress = user.firstName + "." + user.lastName + "@example.com";
        user.dateOfBirth = LocalDate.of(1987, 1, 1);
        user.password = "Password";
        user.mobilePhone = "01234567890";
        user.address = Address.getDefault();
        return user;
    }
}
