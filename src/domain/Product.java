package domain;

import enums.ProductCategory;

public class Product {

    private Integer id;

    private String name;

    private Double price;

    private String description;

    private ProductCategory category;

    private Integer stock;

    public Product(Integer id, String name, Double price, String description, ProductCategory category, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return
                "[" + id + "] -" +
                        " name='" + name + '\'' +
                        ", price=" + price +
                        ", description='" + description + '\'' +
                        ", category=" + category +
                        ", stock=" + stock;

    }
}
