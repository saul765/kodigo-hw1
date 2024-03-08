import java.util.List;

public class Exercise1 {


    public static void main(String[] args) {

        ConsoleUtils consoleUtils = new ConsoleUtils();

        Integer quantity = consoleUtils.requestIntegerFromTerminal("Enter the quantity of numbers you want to check: ");

        List<Double> numbers = consoleUtils.requestNumbersFromTerminal(quantity);

        Integer positiveNumbers = Constants.ZERO;

        Integer negativeNumbers = Constants.ZERO;

        for (Double number : numbers) {
            if (number >= Constants.ZERO) {
                positiveNumbers++;
            } else {
                negativeNumbers++;
            }
        }

        System.out.println("The quantity of numbers greater than zero are: " + positiveNumbers);

        System.out.println("The quantity of numbers less than zero are: " + negativeNumbers);

    }
}
