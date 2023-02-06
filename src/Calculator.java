import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator implements Calculable {

    private int a;
    private int b;
    private int c;
    private int result;

    List<Integer> operands = new ArrayList<>();
    List<Character> operators = new ArrayList<>();

    @Override
    public int calculationOfUserInput(List<Integer> operands, List<Character> operators) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < operands.size(); i++) {
            operandStack.push(operands.get(i));
            if (i < operators.size()) {
                char currentOperation = operators.get(i);
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), currentOperation)) {
                    int result = performOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
                    operandStack.push(result);
                }
                operatorStack.push(currentOperation);
            }
        }

        while (!operatorStack.isEmpty()) {
            int result = performOperation(operatorStack.pop(), operandStack.pop(), operandStack.pop());
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    private static int performOperation(char operation, int secondOperand, int firstOperand) {
        switch (operation) {
            case '+' -> {
                return firstOperand + secondOperand;
            }
            case '-' -> {
                return firstOperand - secondOperand;
            }
            case '*' -> {
                return firstOperand * secondOperand;
            }
            case '/' -> {
                if (secondOperand == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return firstOperand / secondOperand;
            }
        }
        return 0;
    }

    private static boolean hasHigherPrecedence(char operator1, char operator2) {
        return (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
    }


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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
