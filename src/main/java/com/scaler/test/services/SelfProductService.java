package com.scaler.test.services;

import com.scaler.test.execptions.ProductNotExistsException;
import com.scaler.test.models.Category;
import com.scaler.test.models.Product;
import com.scaler.test.repositories.CategoryRepository;
import com.scaler.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductServices{

    private ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isEmpty()) throw new RuntimeException();
        Product savedProduct=productOptional.get();

        if(product.getTitle()!=null){
            savedProduct.setTitle(product.getTitle());
        }
        if(product.getDescription()!=null){
            savedProduct.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            savedProduct.setPrice(product.getPrice());
        }
        if(product.getImageUrl()!=null){
            savedProduct.setImageUrl(product.getImageUrl());
        }

        return productRepository.save(savedProduct);
    }

    @Override
    public Product getSingleProduct(Long id)  throws ProductNotExistsException {
        Optional<Product>productOptional= productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("product with id" + id + "does not Exist");
        }
        Product product= productOptional.get();

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category=product.getCategory();
        if(category.getId()==null) {
           Category savedCategory= categoryRepository.save(category);
           product.setCategory(savedCategory);
        }


        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
