package com.scaler.test.repositories;

import com.scaler.test.models.Category;
import com.scaler.test.models.Product;
import com.scaler.test.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
     extends JpaRepository<Product,Long> {

    List<Product> findByTitleContaining(String word);
    long deleteByTitleIgnoreCase(String title);

    List<Product> findByTitleAndDescription(String title,
                                            String description);
    List<Product> findByPriceBetween(double startRange, double endRange);

    List<Product> findByCategory(Category category);

    Product findByIdAndCategoryOrderByTitle(Long id, Category category);

    List<Product> findByCategory_Id(Long id);

    @Override
     Optional< Product> findById(Long id);

    Product save(Product product);

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> somethingsomething(@Param("id") Long id);

    @Query(value= "select p.id as id, p.title as tilte from Product p where p.id= :id",nativeQuery = true)
     List<ProductWithIdAndTitle> somesome2(@Param("id") Long id);

        // this may return null value and give runtime exception so it is not good so
    // we use Optional;
}
