public class Exercise3 {


    public static void main(String[] args) {


        ConsoleUtils consoleUtils = new ConsoleUtils();

        Integer term = consoleUtils.requestIntegerFromTerminal("Enter the N term of the fibonacci sequence you want to check: ");


        System.out.println("The fibonacci number of the term using iterative " + term + " is: " + fibonacciIterative(term));

        // subtracting 1 because the sequence starts at 0
        System.out.println("The fibonacci number of the term using recursive " + term + " is: " + fibonacciRecursive(term - Constants.ONE));

    }

    private static Integer fibonacciIterative(Integer term) {
        Integer firstTerm = Constants.ZERO;

        Integer secondTerm = Constants.ONE;

        Integer result = Constants.ZERO;

        if (term.equals(Constants.ZERO)) {
            return firstTerm;
        }

        if (term.equals(Constants.ONE)) {
            return secondTerm;
        }

        // Using 3 because we already have the first two terms
        for (int i = 3; i <= term; i++) {
            result = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = result;
        }
        return result;
    }

    // Fibonacci sequence using recursion
    private static Integer fibonacciRecursive(Integer term) {

        if (term.equals(Constants.ZERO)) return Constants.ZERO;

        if (term.equals(Constants.ONE)) return Constants.ONE;

        return fibonacciRecursive(term - 1) + fibonacciRecursive(term - 2);

    }
}
