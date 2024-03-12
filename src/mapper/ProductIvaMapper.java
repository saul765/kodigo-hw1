package mapper;

import domain.ProductIva;

import java.util.List;

public class ProductIvaMapper {

    private static final Double IVA = 0.13;


    public List<ProductIva> calculateIva(List<ProductIva> products) {
        return products.stream().map(product ->
                new ProductIva(product.getId(), product.getName(), product.getPrice(), calculatePriceWithIva(product.getPrice()))).toList();
    }


    private Double calculatePriceWithIva(Double price) {
        return price + (price * IVA);
    }
}
