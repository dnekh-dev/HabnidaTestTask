import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {

    //In this method we try to get a string from a user
    public String getInputString() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            return scanner.nextLine();
        }
    }

    //This method parses a string has gotten from user and extract integers from the string and put them to the List of integers
    public List<Integer> extractIntegers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    //This method does the same thing as that's above one but only for Characters that come from inputted string
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

    /*This method compares integers from List on integers and match them to zero then remove chars from List of Character
    depends on the result of comparison. If integer[0] < 0, we remove an element from List of characters where index is 0,
    then an element where index is 2...4...6 and etc.*/
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

    /*Here we check against a given range of numbers from -10 to -1 and from 1 to 10 excluding 0
    and throws custom exception if we find illegal integer */
    public boolean isValidNumbers(List<Integer> numbers) throws CalculatorInputIntegersException {
        for (Integer num : numbers) {
            if (num <= -11 || num >= 11 || num == 0) {
                throw new CalculatorInputIntegersException();
            }
        }
        return true;
    }

    //Here we do the same  things for math signs
    public boolean isValidOperator(List<Character> operators) throws CalculatorInputOperatorsException {
        for (Character op : operators) {
            if (!(op.equals('+') || op.equals('-') || op.equals('*') || op.equals('/'))) {
                throw new CalculatorInputOperatorsException();
            }
        }
        return true;
    }

}
