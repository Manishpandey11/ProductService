package com.scaler.test.services;

import com.scaler.test.execptions.ProductNotExistsException;
import com.scaler.test.models.Product;

import java.util.List;


public interface ProductServices {

   // Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProduct();

    Product replaceProduct(Long id, Product product);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long id);

}
