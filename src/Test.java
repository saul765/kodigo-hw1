import domain.ProductIva;
import mapper.ProductIvaMapper;

import java.util.ArrayList;
import java.util.List;

public class Test {

    ConsoleUtils consoleUtils = new ConsoleUtils();

    private final ProductIvaMapper productIvaMapper = new ProductIvaMapper();


    public static void main(String[] args) {

        Test test = new Test();

        List<ProductIva> productIvaList = test.getProductsIva();

        System.out.println("The products with IVA  " + test.productIvaMapper.calculateIva(productIvaList));

    }

    private List<ProductIva> getProductsIva() {

        ArrayList<ProductIva> productsIva = new ArrayList<>();


        for (int i = 0; i <= 2; i++) {

            String productName = consoleUtils.requestStringFromTerminal("Enter the name of the product: " + (i + 1) + ": ");

            Double price = consoleUtils.requestDoubleFromTerminal("Enter the price of the product: " + (i + 1) + ": ");

            ProductIva productIva = new ProductIva(i + 1, productName, price, 0.00);

            productsIva.add(productIva);

        }

        return productsIva;
    }
}
