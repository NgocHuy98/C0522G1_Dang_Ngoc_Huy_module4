package com.example.test.dto;

import com.example.test.model.ProductType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto {

    private int id;

    @NotBlank
    @Size(min = 5, max = 50, message = "5 or more characters (< 50)")
    private String name;

    @Min(value = 100000)
    private double price;

    private String status;

    private ProductType productType;


    public ProductDto() {
    }

    public ProductDto(int id, String name, double price, String status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
