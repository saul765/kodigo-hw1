public class Exercise4 {


    private static final Integer WORK_HOURS = 8;
    private static final Integer WORK_DAYS = 6;


    public static void main(String[] args) {

        ConsoleUtils consoleUtils = new ConsoleUtils();

        Double hourRate = consoleUtils.requestDoubleFromTerminal("Enter the value on USD per hour: ");

        System.out.printf("The total payment for the %d hours worked is: $%.2f", (WORK_DAYS * WORK_HOURS), calculatePayment(hourRate));
    }

    public static Double calculatePayment(Double hourRate) {
        return hourRate * WORK_DAYS * WORK_HOURS;
    }
}
