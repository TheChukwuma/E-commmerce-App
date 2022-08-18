package com.chukwuma.commerceweb.model;

import java.util.HashMap;
import java.util.Map;

public class Cart extends Product{
    int productQuantity;

    public Cart(){

    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}


