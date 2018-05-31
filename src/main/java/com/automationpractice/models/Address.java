package com.automationpractice.models;

import org.apache.commons.lang3.RandomStringUtils;

public class Address {

    public String addressLine1;

    public String addressLine2;

    public String city;

    public String state;

    public String country;

    public String zipPostalCode;

    public String addressAlias;


    public static Address getDefault() {
        Address address = new Address();
        address.addressLine1 = "1 Street";
        address.city = "New York";
        address.state = "New York";
        address.country = "United States";
        address.zipPostalCode = "67876";
        address.addressAlias = RandomStringUtils.randomAlphabetic(10);
        return address;
    }
}
