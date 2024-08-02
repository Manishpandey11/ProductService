package com.scaler.test.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@Entity

public class Product  extends BaseModel{

    private String title;
    private Double price;
   @ManyToOne(fetch =FetchType.LAZY ,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    private String description;
    private String imageUrl;
    //private int numberOfSales;
}
