package com.automationpractice.models;

import java.math.BigDecimal;

public class ProductModel {

    public String name;
    public BigDecimal price;

    public ProductModel(String name, BigDecimal price) {
        this.name =  name;
        this.price = price;
    }
}
