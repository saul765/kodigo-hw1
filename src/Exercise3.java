import java.util.ArrayList;
import java.util.List;

public class Exercise3 {


    public static void main(String[] args) {


        ConsoleUtils consoleUtils = new ConsoleUtils();

        Integer term = consoleUtils.requestIntegerFromTerminal("Enter the N term of the fibonacci sequence you want to check: ");

        System.out.println("The fibonacci numbers of the " + term + " term is: " + fibonacciIterative(term));

    }

    private static List<Integer> fibonacciIterative(Integer term) {
        Integer firstTerm = Constants.ZERO;

        Integer secondTerm = Constants.ONE;

        Integer result;


        if (term.equals(Constants.ZERO)) {
            return List.of(firstTerm);
        }

        if (term.equals(Constants.ONE)) {
            return List.of(firstTerm, secondTerm);
        }

        ArrayList<Integer> fibonacciSequence = new ArrayList<>(List.of(firstTerm, secondTerm));


        // Using 3 because we already have the first two terms
        for (int i = 3; i <= term; i++) {
            result = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = result;
            fibonacciSequence.add(result);
        }
        return fibonacciSequence;
    }

}
