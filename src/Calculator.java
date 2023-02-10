import java.util.*;

public class Calculator implements Calculable {

    private int result;

    private List<Integer> operands = new ArrayList<>();
    private List<Character> operators = new ArrayList<>();
    private Map<Character, Integer> priorityOfSings = new HashMap<>();


    //This method does calculations in the case when size of List 'operands' equals 3.
    public int calculateExpressionConsistingThreeOperands(List<Integer> operands, List<Character> operators, Map<Character, Integer> priorityOfSings) {
        int meow = 0;
        for (Integer num : priorityOfSings.values()) {
            meow += num;
        }

        //Case for signs with low priority: '+', '-'.
        if (meow == 2) {
            int result = operands.get(0);
            for (int i = 0; i < operators.size(); i++) {
                char operation = operators.get(i);
                int number = operands.get(i + 1);
                switch (operation) {
                    case '+' -> result += number;
                    case '-' -> result -= number;
                }
            }
            return result;
        }

        //Case for signs with high priority: '*', '/'.
        if (meow == 4) {
            int result = operands.get(0);
            for (int i = 0; i < operators.size(); i++) {
                char operation = operators.get(i);
                int number = operands.get(i + 1);
                switch (operation) {
                    case '*' -> result *= number;
                    case '/' -> result /= number;
                }
            }
            return result;
        }

        //Case for mathematical expressions with signs of different priorities
        if (meow == 3) {
            int index = -1;
            for (Map.Entry<Character, Integer> entry : priorityOfSings.entrySet()) {
                if (entry.getValue() == 2) {
                    index = operators.indexOf(entry.getKey());
                    break;
                }
            }
            int result;
            if (index == 0) {
                result = performOperation(operators.get(index), operands.get(0), operands.get(1));
                result = performOperation(operators.get(index + 1), result, operands.get(2));
            } else if (index == 1) {
                result = performOperation(operators.get(index), operands.get(1), operands.get(2));
                result = performOperation(operators.get(index - 1), operands.get(0), result);
            } else {
                return -1;
            }
            return result;
        }
        return -2;
    }

    //Method for calculations that using for third case in the method above.
    private static int performOperation(char operator, int operand1, int operand2) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> -1;
        };
    }

    //This method is used to evaluate mathematical expressions consisting of two operands.
    public int calculateExpressionConsistingTwoOperands(List<Integer> operands, List<Character> operators) {
        int innerResult = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            char operator = operators.get(i - 1);
            int value = operands.get(i);
            if (operator == '+') {
                innerResult += value;
            } else if (operator == '-') {
                innerResult -= value;
            } else if (operator == '*') {
                innerResult *= value;
            } else if (operator == '/') {
                innerResult /= value;
            }
        }
        return innerResult;
    }


    //GETTERS AND SETTERS could be removed with Lombok :)
    public List<Integer> getOperands() {
        return operands;
    }

    public void setOperands(List<Integer> operands) {
        this.operands = operands;
    }

    public List<Character> getOperators() {
        return operators;
    }

    public void setOperators(List<Character> operators) {
        this.operators = operators;
    }

    public Map<Character, Integer> getPriorityOfSings() {
        return priorityOfSings;
    }

    public void setPriorityOfSings(Map<Character, Integer> priorityOfSings) {
        this.priorityOfSings = priorityOfSings;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
