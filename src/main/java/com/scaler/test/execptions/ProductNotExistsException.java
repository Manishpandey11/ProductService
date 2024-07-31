package com.scaler.test.execption;

public class ProductNotExistsException  extends Exception{
    public ProductNotExistsException (String message) {
        super(message);
    }
}
