package com.example.menuManagement.implDependency.tightCoupling;

import com.example.menuManagement.implDependency.Product;

public class Market {

    public static void main(String[] args) {
        Product product = new Product(350,"bread","bakery");
        Product product1 = new Product();
        System.out.println(product1.getProductName());
        System.out.println(product1.getPrice());
        System.out.println(product1.getManufacturingCoy());
    }
}
