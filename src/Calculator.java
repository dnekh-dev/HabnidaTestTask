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

    /*The method calculationOfUserInput takes two input lists, operands and operators, and returns
     the result of a mathematical expression represented by the inputs. It uses two stacks,
     operandStack and operatorStack, to store operands and operators, respectively.

    The method first loops through the operands list and pushes each operand onto the operandStack.
    For each iteration, if the current index i is less than the number of elements in the operators list,
    the method retrieves the current operator and performs the following operations:

    While the operatorStack is not empty and the current operator has lower precedence than the operator
    at the top of the stack (as determined by the hasHigherPrecedence method), the method performs the operation
    at the top of the stack (using the performOperation method), updates the operandStack and continues the loop.

    The current operator is then pushed onto the operatorStack.

    Once the loop is finished, the method then repeatedly performs operations from the operatorStack until it is empty
    and the final result is stored in the operandStack. Finally, the method returns the top value of the operandStack
    as the result of the expression.

    */
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

    //In this method we do calculations
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

    //Here we check precedence of math signs that we have in inputted expression by user
    private static boolean hasHigherPrecedence(char operator1, char operator2) {
        return (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
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
