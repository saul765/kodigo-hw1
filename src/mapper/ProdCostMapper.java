package mapper;

import domain.CometProduct;
import domain.KeyRate;
import enums.CometProductKey;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class ProdCostMapper {

    private final static Integer PRICE_DECIMALS = 1;

    private final static Double PROFIT_MARGIN = 0.45;

    private final static Double SEVENTY_FIVE_PERCENT_COST_RATE = 0.75;

    private final static Double EIGHTY_PERCENT_COST_RATE = 0.80;

    private final static Double EIGHTY_FIVE_PERCENT_COST_RATE = 0.85;

    private final static Double THIRTY_PERCENT_COST_RATE = 0.30;

    private final static Double THIRTY_FIVE_PERCENT_COST_RATE = 0.35;

    private final static Double TWENTY_EIGHT_PERCENT_COST_RATE = 0.28;


    public List<CometProduct> calculateProdCostMapper(List<CometProduct> products, Double rawMaterialCost) {

        return products.stream().map(
                product -> new CometProduct(
                        product.getId(),
                        product.getName(),
                        formatDouble(calculateSalePrice(rawMaterialCost, product.getKey()), PRICE_DECIMALS) ,
                        product.getKey()
                )
        ).toList();
    }

    private Double calculateProductionCost(Double rawMaterialCost, Double manpowerCost, Double factoryExpenses) {
        return rawMaterialCost + manpowerCost + factoryExpenses;
    }

    private Double calculateManpowerCost(Double rawMaterialCost, CometProductKey key) {
        return rawMaterialCost * calculateKeyRates().get(key).getManPowerRate();
    }

    private Double calculateFactoryExpenses(Double rawMaterialCost, CometProductKey key) {
        return rawMaterialCost * calculateKeyRates().get(key).getFactoryExpensesRate();
    }

    private Double calculateSalePrice(Double rawMaterialCost, CometProductKey key) {

        return  calculateProductionCost(
                rawMaterialCost,
                calculateManpowerCost(rawMaterialCost, key),
                calculateFactoryExpenses(rawMaterialCost, key)) * (1 + PROFIT_MARGIN);
    }

    private Map<CometProductKey, KeyRate> calculateKeyRates() {
        return Map.of(
                CometProductKey.KEY_3, new KeyRate(SEVENTY_FIVE_PERCENT_COST_RATE, THIRTY_FIVE_PERCENT_COST_RATE),
                CometProductKey.KEY_4, new KeyRate(SEVENTY_FIVE_PERCENT_COST_RATE, TWENTY_EIGHT_PERCENT_COST_RATE),
                CometProductKey.KEY_1, new KeyRate(EIGHTY_PERCENT_COST_RATE, TWENTY_EIGHT_PERCENT_COST_RATE),
                CometProductKey.KEY_5, new KeyRate(EIGHTY_PERCENT_COST_RATE, THIRTY_PERCENT_COST_RATE),
                CometProductKey.KEY_2, new KeyRate(EIGHTY_FIVE_PERCENT_COST_RATE, THIRTY_PERCENT_COST_RATE),
                CometProductKey.KEY_6, new KeyRate(EIGHTY_FIVE_PERCENT_COST_RATE, THIRTY_FIVE_PERCENT_COST_RATE)
        );
    }

    public static Double formatDouble(Double value, Integer decimalPlaces) {
        BigDecimal bd = new BigDecimal(value);
        return bd.setScale(decimalPlaces, RoundingMode.UP).doubleValue();
    }
}
