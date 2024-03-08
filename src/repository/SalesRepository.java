package repository;

import domain.Sale;

import java.util.ArrayList;
import java.util.List;

public class SalesRepository {

    private final List<Sale> sales = new ArrayList<>(
            List.of(
                    new Sale(1, "3D Printer", 8000.00),
                    new Sale(2, "Bugatti", 500000.81),
                    new Sale(3, "Japan Resort", 15000.90),
                    new Sale(4, "The boring company flamethrower", 17500.00),
                    new Sale(5, "PC master race", 4000.00)

            )
    );

    public List<Sale> getSales() {
        return sales;
    }



}
