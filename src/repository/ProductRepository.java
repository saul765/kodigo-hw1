package repository;

import domain.Product;
import enums.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private final List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "iPhone 11", 800.99, "worst phone", ProductCategory.SMARTPHONE, 10),
                    new Product(2, "Sony Headphones", 300.90, "best headphones", ProductCategory.AUDIO, 10),
                    new Product(3, "Lenovo legion", 2000.60, "average laptop", ProductCategory.COMPUTER, 10),
                    new Product(4, "Projector", 600.00, "just a projector", ProductCategory.VIDEO, 10)
            )
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateProductStock(int id) {
        Product product = getProductById(id);

        Optional.ofNullable(product)
                .ifPresent(p -> p.setStock(p.getStock() - 1));
    }
}
