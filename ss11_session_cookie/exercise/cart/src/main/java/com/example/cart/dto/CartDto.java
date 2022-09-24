package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {

    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void deleteCart(ProductDto productDto) {
        productMap.remove(productDto);
    }

    public Double totalPay() {
        double pay = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            pay += entry.getKey().getPrice() * entry.getValue();
        }
        return pay;
    }

    public void minusCart(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);

            if (currentValue > 1)
                productMap.replace(productDto, currentValue - 1);
        }

    }
}
