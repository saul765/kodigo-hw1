import java.time.Year;

public class Exercise10 {

    private static final Double INITIAL_INVESTMENT = 1500.00;
    private static final Double ANNUAL_INTEREST_RATE = 0.15;
    private static final Integer INITIAL_INVESTMENT_YEAR = 1961;


    public static void main(String[] args) {

        Integer currentYear = Year.now().getValue();

        Double totalInvestment = INITIAL_INVESTMENT * Math.pow(Constants.ONE + ANNUAL_INTEREST_RATE, (currentYear - INITIAL_INVESTMENT_YEAR));

        System.out.printf("The total value of investment from %s to %s is: $%.2f", INITIAL_INVESTMENT_YEAR, currentYear, totalInvestment);
    }
}
