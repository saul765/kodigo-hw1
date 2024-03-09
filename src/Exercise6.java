import domain.CometProduct;
import mapper.ProdCostMapper;
import repository.CometFactoryRepository;

import java.util.List;

public class Exercise6 {


    private final CometFactoryRepository cometFactoryRepository = new CometFactoryRepository();

    private final ProdCostMapper prodCostMapper = new ProdCostMapper();

    public ConsoleUtils consoleUtils = new ConsoleUtils();

    public static void main(String[] args) {

        Exercise6 ex6 = new Exercise6();

        do {
            try {
                Double rawMaterialCost = ex6.consoleUtils.requestDoubleFromTerminal("Please enter the cost of (raw material/materia prima): ");

                List<CometProduct> productPrices = ex6.prodCostMapper.calculateProdCostMapper(ex6.cometFactoryRepository.getProducts(), rawMaterialCost);


                ex6.showProducts(productPrices);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);


    }

    private void showProducts(List<CometProduct> productPrices) {
        System.out.println("======== Products with prices=========");

        productPrices.forEach(product -> System.out.println(product.toString()));

        System.out.println("====================================");
    }


}