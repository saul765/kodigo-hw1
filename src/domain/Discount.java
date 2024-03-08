package domain;

public class Discount {


    private Product product;

    private String discount;

    private Double discountPrice;


    public Discount(Product product, String discount, Double discountPrice) {
        this.product = product;
        this.discount = discount;
        this.discountPrice = discountPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return
                "[" + product.getId() + "] | " + product.getName() + " | " +
                        " $" + product.getPrice() + " | " +
                        discount + " | " +
                        "$" + discountPrice + " | "
                ;
    }
}
