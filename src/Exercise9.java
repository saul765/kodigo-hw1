import domain.Sale;
import repository.SalesRepository;

import java.util.List;
import java.util.function.Predicate;

public class Exercise9 {

    private static final Double TEN_THOUSAND = 10000.00;

    private static final Double TWENTY_THOUSAND = 20000.00;
    SalesRepository salesRepository = new SalesRepository();


    public static void main(String[] args) {

        Exercise9 ex9 = new Exercise9();
        ex9.getSalesAnalytics();
    }

    private void getSalesAnalytics() {
        getTotalSales();
        getSalesByCondition(sale -> sale.getPrice() <= TEN_THOUSAND, " less or equal than " + TEN_THOUSAND);
        getSalesByCondition(sale -> sale.getPrice() > TEN_THOUSAND && sale.getPrice() < TWENTY_THOUSAND, " greater than " + TEN_THOUSAND + " and less than " + TWENTY_THOUSAND);
        getSalesByDetail();
    }

    private void getTotalSales() {

        Double totalSales = salesRepository.getSales().stream().mapToDouble(Sale::getPrice).sum();

        System.out.println("Total sales: $" + totalSales);
    }

    private void getSalesByCondition(Predicate<Sale> condition, String message) {

        List<Sale> sales = salesRepository.getSales().stream().filter(condition).toList();

        System.out.println("The sales with condition" + message + " are: " + sales.size() + " items");
    }

    private void getSalesByDetail() {
        System.out.println("Total sales by detail: ");
        salesRepository.getSales().forEach(sale -> System.out.println(sale.toString()));
    }
}
