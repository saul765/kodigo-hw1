import domain.Product;
import enums.ProductCategory;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercise5 {

    private static final Double ONE_THOUSAND = 1000.00;

    private static final Double FIVE_HUNDRED = 500.00;

    private final ConsoleUtils consoleUtils = new ConsoleUtils();

    private final ProductRepository productRepository = new ProductRepository();

    private final List<Product> sales = new ArrayList<>();


    public static void main(String[] args) {

        Exercise5 ex = new Exercise5();

        do {
            try {
                menu();
                int option = ex.consoleUtils.requestIntegerFromTerminal("Enter your option: ");

                switch (option) {
                    case 1:
                        ex.sellProduct();
                        break;
                    case 2:
                        ex.showProducts();
                        break;
                    case 3:
                        ex.checkAnalytics();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        System.exit(Constants.ZERO);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
            }

        } while (true);


    }

    private static void menu() {
        System.out.println("===================MENU =====================");
        System.out.println("[1] - Sell product from stock");
        System.out.println("[2] - Show products");
        System.out.println("[3] - Check analytics");
        System.out.println("[4] - Exit");
    }

    private void showProducts() {
        List<Product> products = productRepository.getProducts();
        products.forEach(product -> System.out.println(product.toString()));
    }

    private void sellProduct() {

        showProducts();
        Integer id = consoleUtils.requestIntegerFromTerminal("Enter the id of the product you want to sell: ");

        productRepository.updateProductStock(id);

        Product product = productRepository.getProductById(id);

        sales.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getCategory(), 1));

        System.out.println("Product sold successfully");
    }

    private void checkAnalytics() {
        System.out.println("Total sells: " + sales.size() + " products");
        System.out.println("Total sells amount: " + sales.stream().mapToDouble(Product::getPrice).sum());
        sellsByCondition(product -> product.getPrice() > ONE_THOUSAND, " greater than " + ONE_THOUSAND);
        sellsByCondition(product -> (product.getPrice() > FIVE_HUNDRED && product.getPrice() <= ONE_THOUSAND), " greater than " + FIVE_HUNDRED + " and lower or equal than" + ONE_THOUSAND);
        sellsByCondition(product -> product.getPrice() <= FIVE_HUNDRED, " lower or equal than " + FIVE_HUNDRED);
        sellsByCategory();

    }

    private void sellsByCondition(Predicate<Product> condition, String message) {
        List<Product> saleCondition = sales.stream().filter(condition).toList();

        if (saleCondition.isEmpty()) {
            System.out.println("Sales with condition" + message + " : " + "WITHOUT SALES");

        } else {
            System.out.println("Sales with condition" + message + " : " + saleCondition.size() + " products");
        }
    }

    private void sellsByCategory() {
        System.out.println("Total sells amount by category :");

        Arrays.stream(ProductCategory.values()).toList().forEach(productCategory -> {
            System.out.print(productCategory.name() + " | ");

            List<Product> category =
                    sales.stream()
                            .filter(product -> product.getCategory().equals(productCategory)).toList();
            if (category.isEmpty()) {
                System.out.println("No sells");
            } else {
                category.forEach(product -> System.out.println(product.toString()));
            }
        });

    }
}
