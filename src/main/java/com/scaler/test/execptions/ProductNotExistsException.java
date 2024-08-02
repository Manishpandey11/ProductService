package com.scaler.test.execptions;

public class ProductNotExistsException  extends Exception{
    public ProductNotExistsException (String message) {
        super(message);
    }
}
