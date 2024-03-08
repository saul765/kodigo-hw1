import enums.InputType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUtils {

    private final Scanner scanner = new Scanner(System.in);

    public List<Double> requestNumbersFromTerminal(Integer limit) {

        List<Double> numbers = new ArrayList<>();

        do {
            try {
                System.out.print("Enter a number: ");
                String input = scanner.nextLine();
                numbers.add(Double.parseDouble(input));

                if (numbers.size() != limit) {
                    System.out.println("You are missing " + (limit - numbers.size()) + " numbers to complete the list. keep going!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid number");
            }
        } while (numbers.size() < limit);

        return numbers;
    }

    public Integer requestIntegerFromTerminal(String message) {
        return requestInput(message, InputType.INTEGER).intValue();
    }

    public Double requestDoubleFromTerminal(String message) {
        return requestInput(message, InputType.DOUBLE).doubleValue();

    }

    public String requestStringFromTerminal(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    private Number requestInput(String message, InputType type) {
        do {
            try {
                System.out.print(message);

                String input = scanner.nextLine();

                return type.equals(InputType.INTEGER) ? Integer.parseInt(input) : Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid number");
            }
        } while (true);
    }
}
