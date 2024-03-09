package repository;

import domain.CometProduct;
import enums.CometProductKey;

import java.util.List;

public class CometFactoryRepository {

    private final static Double ZERO = 0.00;

    private final List<CometProduct> products = List.of(
            new CometProduct(1, "Product 1", ZERO, CometProductKey.KEY_1),
            new CometProduct(2, "Product 2", ZERO, CometProductKey.KEY_2),
            new CometProduct(3, "Product 3", ZERO, CometProductKey.KEY_2),
            new CometProduct(4, "Product 4", ZERO, CometProductKey.KEY_3),
            new CometProduct(5, "Product 5", ZERO, CometProductKey.KEY_4),
            new CometProduct(6, "Product 6", ZERO, CometProductKey.KEY_5),
            new CometProduct(7, "Product 7", ZERO, CometProductKey.KEY_6),
            new CometProduct(8, "Product 8", ZERO, CometProductKey.KEY_1),
            new CometProduct(9, "Product 9", ZERO, CometProductKey.KEY_5)
    );

    public List<CometProduct> getProducts() {
        return products;
    }
}
