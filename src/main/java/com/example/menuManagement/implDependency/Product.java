package com.example.menuManagement.implDependency;

public class Product {
    private float price;
    private String productName;
    private String manufacturingCoy;

    public Product(float price, String productName, String manufacturingCoy) {
        this.price = price;
        this.productName = productName;
        this.manufacturingCoy = manufacturingCoy;
    }

    public Product() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturingCoy() {
        return manufacturingCoy;
    }

    public void setManufacturingCoy(String manufacturingCoy) {
        this.manufacturingCoy = manufacturingCoy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productName='" + productName + '\'' +
                ", manufacturingCoy='" + manufacturingCoy + '\'' +
                '}';
    }
}
