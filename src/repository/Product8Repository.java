package repository;

import domain.Product;
import enums.ProductCategory;

import java.util.List;

public class Product8Repository {


    private final List<Product> products = List.of(
            new Product(1, "Product 1", 100.00, " ", ProductCategory.COMPUTER, 6),
            new Product(2, "Product 2", 150.00, " ", ProductCategory.VIDEO, 4),
            new Product(3, "Product 3", 2000.00, " ", ProductCategory.SMARTPHONE, 5),
            new Product(4, "Product 4", 2500.00, " ", ProductCategory.VIDEO, 11),
            new Product(5, "Product 5", 3000.00, " ", ProductCategory.AUDIO, 100)
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(Integer id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }


}
