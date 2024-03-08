import domain.Discount;
import domain.Product;
import mapper.DiscountsMapper;
import repository.Product8Repository;

import java.util.ArrayList;
import java.util.List;

public class Exercise8 {

    private final Product8Repository product8Repository = new Product8Repository();

    private final DiscountsMapper discountsMapper = new DiscountsMapper();

    private ArrayList<Discount> cart = new ArrayList<>();

    private final ConsoleUtils consoleUtils = new ConsoleUtils();


    public static void main(String[] args) {

        Exercise8 ex8 = new Exercise8();

        List<Product> products = ex8.product8Repository.getProducts();

        List<Discount> discounts = ex8.discountsMapper.productsToDiscounts(products);

        do {
            try {
                ex8.menu();
                Integer option = ex8.consoleUtils.requestIntegerFromTerminal("Enter your option: ");

                switch (option) {
                    case 1:
                        ex8.printDiscounts(discounts);
                        ex8.addProductToCart(discounts);
                        break;
                    case 2:
                        ex8.showCart();
                        break;
                    case 3:
                        ex8.checkout();
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
            }

        } while (true);

    }

    private void printDiscounts(List<Discount> discounts) {

        System.out.println("=================== Discounts =====================");

        System.out.println("| ID | Product | Price | Discount | Price with discount |");

        discounts.forEach(discount -> System.out.println(discount.toString()));

        System.out.println("===================================================");
    }

    private void menu() {

        System.out.println("=================== Menu =====================");
        System.out.println("[1] Add product to cart");
        System.out.println("[2] Show cart");
        System.out.println("[3] Checkout");
    }

    private void addProductToCart(List<Discount> discounts) {
        Integer id = consoleUtils.requestIntegerFromTerminal("Enter the id of the product you want to add to the cart: ");

        Discount product = discounts.get(id - 1);
        cart.add(product);
        System.out.println("Product added to cart successfully");
    }

    private void showCart() {
        System.out.println("=================== Cart =====================");
        System.out.println("| ID | Product | Price | Discount | Price with discount |");
        cart.forEach(product -> System.out.println(product.toString()));
        System.out.println("your total with discounts is: $" + cart.stream().mapToDouble(Discount::getDiscountPrice).sum());
        System.out.println("===================================================");
    }

    private void checkout() {
        Double regularPrice = cart.stream().mapToDouble(discount -> discount.getProduct().getPrice()).sum();
        Double savings = cart.stream().mapToDouble(Discount::getDiscountPrice).sum();

        System.out.println("=================== Checkout =====================");
        System.out.println("Total sells: " + cart.size() + " products");
        System.out.println("You saved: $" + (regularPrice - savings) + " in discounts");
        System.out.println("Total amount to pay: " + cart.stream().mapToDouble(Discount::getDiscountPrice).sum());

        System.out.println("Thank you for your purchase!");
        System.out.println("===================================================");
        System.exit(Constants.ZERO);
    }

}
