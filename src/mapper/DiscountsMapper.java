package mapper;

import domain.Discount;
import domain.Product;

import java.util.List;

public class DiscountsMapper {

    private static final Double TWO_HUNDRED = 200.00;

    private static final Double ONE_HUNDRED = 100.00;

    private static final Double FIFTEEN_PERCENT_DISCOUNT = 0.15;

    private static final Double TWELVE_PERCENT_DISCOUNT = 0.12;

    private static final Double TEN_PERCENT_DISCOUNT = 0.10;

    private static final String FIFTEEN_PERCENT_DISCOUNT_STR = "15%";

    private static final String TWELVE_PERCENT_DISCOUNT_STR = "12%";

    private static final String TEN_PERCENT_DISCOUNT_STR = "10%";


    public List<Discount> productsToDiscounts(List<Product> products) {

        return products
                .stream()
                .map(product -> new Discount(product, getDiscountPercentage(product.getPrice()), getDiscountPrice(product.getPrice())))
                .toList();
    }

    private String getDiscountPercentage(Double price) {
        if (price >= TWO_HUNDRED) {
            return FIFTEEN_PERCENT_DISCOUNT_STR;
            // 200 validation could be removed since it is already checked in the previous if
        } else if (price > ONE_HUNDRED && price < TWO_HUNDRED) {
            return TWELVE_PERCENT_DISCOUNT_STR;
        } else {
            return TEN_PERCENT_DISCOUNT_STR;
        }
    }

    public Double getDiscountPrice(Double price) {
        if (price >= TWO_HUNDRED) {
            return price - (price * FIFTEEN_PERCENT_DISCOUNT);
            // 200 validation could be removed since it is already checked in the previous if
        } else if (price > ONE_HUNDRED && price < TWO_HUNDRED) {
            return price - (price * TWELVE_PERCENT_DISCOUNT);
        } else {
            return price - (price * TEN_PERCENT_DISCOUNT);
        }
    }
}
