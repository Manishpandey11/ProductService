package com.scaler.test.controller;

import com.scaler.test.commons.AuthenticationCommons;
import com.scaler.test.execptions.ProductNotExistsException;
import com.scaler.test.models.Product;
import com.scaler.test.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/products")
public class ProductController {

    private ProductServices productServices;
    private AuthenticationCommons authenticationCommons;
    private RestTemplate restTemplate;
    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductServices productServices,
                             AuthenticationCommons authenticationCommons,
                             RestTemplate restTemplate) {
        this.productServices=productServices;
        this.authenticationCommons = authenticationCommons;
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productServices.getAllProduct(); // o p q

        List<Product> finalProducts = new ArrayList<>();

        for (Product p: products) { // o  p q
            p.setTitle("Hello" + p.getTitle());
            finalProducts.add(p);
        }

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                finalProducts, HttpStatus.FORBIDDEN
        );
        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity< Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {

        return new ResponseEntity<>(productServices.getSingleProduct(id),
                HttpStatus.OK
        );
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){

        return productServices.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable ("id") Long id, @RequestBody Product product) {

        return productServices.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable ("id") Long id,@RequestBody Product product){
        return new Product();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
