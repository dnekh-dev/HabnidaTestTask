import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {
    public String getInputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    public List<Integer> extractIntegers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    public List<Character> extractOperators(String input) {
        List<Character> operators = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && !Character.isWhitespace(c)) {
                operators.add(c);
            }
        }
        return operators;
    }

    public List<Character> removeEven(List<Integer> numbers, List<Character> operations) {
        Iterator<Integer> numIt = numbers.iterator();
        Iterator<Character> opIt = operations.iterator();
        int index = 0;
        while (numIt.hasNext()) {
            int num = numIt.next();
            if (num < 0) {
                for (int i = 0; i < index + 1; i++) {
                    if (opIt.hasNext()) {
                        opIt.next();
                    }
                }
                opIt.remove();
            }
            index++;
        }
        return operations;
    }

    public boolean isValidNumbers(List<Integer> numbers) throws CalculatorInputIntegersException {
        for (Integer num : numbers) {
            if (num <= -11 || num >= 11 || num == 0) {
                throw new CalculatorInputIntegersException();
            }
        }
        return true;
    }

    public boolean isValidOperator(List<Character> operators) throws CalculatorInputOperatorsException {
        for (Character op : operators) {
            if (!(op.equals('+') || op.equals('-') || op.equals('*') || op.equals('/'))) {
                throw new CalculatorInputOperatorsException();
            }
        }
        return true;
    }

}
