package domain;

public class KeyRate {

    private Double manPowerRate;

    private Double factoryExpensesRate;


    public KeyRate(Double manPowerRate, Double factoryExpensesRate) {
        this.manPowerRate = manPowerRate;
        this.factoryExpensesRate = factoryExpensesRate;
    }

    public Double getManPowerRate() {
        return manPowerRate;
    }

    public void setManPowerRate(Double manPowerRate) {
        this.manPowerRate = manPowerRate;
    }

    public Double getFactoryExpensesRate() {
        return factoryExpensesRate;
    }

    public void setFactoryExpensesRate(Double factoryExpensesRate) {
        this.factoryExpensesRate = factoryExpensesRate;
    }
}
