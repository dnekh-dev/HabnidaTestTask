import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {
    private String userInputInProcessing;


    //In this method we try to get a string from a user
    public String getInputString() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            return scanner.nextLine();
        }
    }

    //This method does not use in this version of app <<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    public String removeWhitespaces(String input) {
//        return input.replaceAll("\\s+", "");
//    }

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
    public List<Character> extractSymbols(String input) {
        List<Character> symbols = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && !Character.isWhitespace(c)) {
                symbols.add(c);
            }
        }
        return symbols;
    }

    /*
      This is an overloaded "extractSymbols" method that takes a string that's gotten from user and 'numbers'.
      Then extracts all symbols from the string and referring to the elements of the List "numbers",
      compares each element with 0. If the element is less than 0,
      we remove the corresponding element from the List "symbols"
     */
    public List<Character> extractSymbols(String input, List<Integer> numbers) {
        List<Character> symbols = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') {
                symbols.add(c);
            }
        }

        if (numbers.size() > 0 && numbers.get(0) < 0) {
            symbols.remove(0);
        }

        if (numbers.size() > 0 && numbers.get(1) < 0) {
            symbols.remove(1);
        }

        return symbols;
    }

    /*
      This method compares integers from List 'numbers' and match them to zero then remove chars from List 'symbols'
      depends on the result of comparison. If integer[0] < 0, we remove an element from List 'numbers' where index is 0,
      and going to next iteration. Going through List 'symbols' with a step i+1.
    */
    public List<Character> removeEven(List<Integer> numbers, List<Character> symbols) {
        Iterator<Integer> numIt = numbers.iterator();
        Iterator<Character> opIt = symbols.iterator();
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
        return symbols;
    }

    //This method sets priority for math signs from List 'symbols'.
    public Map<Character, Integer> setOperatorsPriority(List<Character> symbols) {
        Map<Character, Integer> setMapOfOperatorsAndTheirPriority = new HashMap<>();
        for (Character operator : symbols) {
            if (operator == '*' || operator == '/') {
                setMapOfOperatorsAndTheirPriority.put(operator, 2);
            } else if (operator == '+' || operator == '-') {
                setMapOfOperatorsAndTheirPriority.put(operator, 1);
            }
        }
        return setMapOfOperatorsAndTheirPriority;
    }

    /*
      Here we check against a given range of numbers from -10 to -1 and from 1 to 10 excluding 0
      and throws custom exception if we find illegal integer.
    */
    public boolean isValidNumbers(List<Integer> numbers) throws CalculatorInputIntegersException {
        for (Integer num : numbers) {
            if (num <= -11 || num >= 11 || num == 0) {
                throw new CalculatorInputIntegersException();
            }
        }
        return true;
    }

    //This method checking size of List 'numbers' and throw en exception if it returns true.
    public void checkSizeOfListNumbers(List<Integer> numbers) throws Exception {
        if (numbers.size() < 2 || numbers.size() > 3) {
            throw new Exception("The mathematical expression must contain at least two and no more than three numbers.");
        }
    }


    //Here we do the same  things for math signs
    public boolean isValidOperator(List<Character> symbols) throws CalculatorInputOperatorsException {
        for (Character op : symbols) {
            if (!(op.equals('+') || op.equals('-') || op.equals('*') || op.equals('/'))) {
                throw new CalculatorInputOperatorsException();
            }
        }
        return true;
    }


    //GETTERS AND SETTERS
    public String getUserInputInProcessing() {
        return userInputInProcessing;
    }

    public void setUserInputInProcessing(String userInputInAction) {
        this.userInputInProcessing = userInputInAction;
    }

}
