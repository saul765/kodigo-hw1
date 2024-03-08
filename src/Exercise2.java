import java.util.List;
import java.util.stream.IntStream;

public class Exercise2 {

    private static final Integer INITIAL_RANGE = 0;
    private static final Integer FINAL_RANGE = 101;

    public static void main(String[] args) {

        List<Integer> numbers = IntStream.range(INITIAL_RANGE, FINAL_RANGE).boxed().toList();

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == Constants.ZERO)
                .toList();

        System.out.println("The even numbers between 0 and 100 are: " + evenNumbers.size());
        System.out.println("The even numbers between 0 and 100 are: " + evenNumbers);
    }
}
