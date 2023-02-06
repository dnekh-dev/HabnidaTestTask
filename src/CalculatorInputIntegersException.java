public class CalculatorInputIntegersException extends Exception {
    public CalculatorInputIntegersException() {
        super("The calculator can only work with integers from -10 to 10 inclusive, with the exception of 0.");
    }
}
