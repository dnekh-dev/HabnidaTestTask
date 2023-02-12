import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();
        Handler handler = new Handler();

        //get a string from user
        handler.setUserInputInProcessing(handler.getInputString());

        //check the string has gotten from user for required format
        if (handler.isMatchingToRequiredPattern(handler.getUserInputInProcessing())) {
            //extract integers from the string has gotten from user and put them into List 'operands' of the Calculator class
            calc.setOperands(handler.extractIntegers(handler.getUserInputInProcessing()));

            //checking for too short (size < 2) or too long (size > 2) elements in List 'numbers' of the Handler class
            handler.checkSizeOfListNumbers(calc.getOperands());

            //check for variance of calculations: if the size is 2,
            // we move along the branch for calculating mathematical expressions with two operands
            if (calc.getOperands().size() == 2) {
                //collect the signs of mathematical operations in List 'symbols' of the Handler class
                calc.setOperators(handler.extractSymbols(handler.getUserInputInProcessing(), calc.getOperands()));
                //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
                //in cases of code, any condition is violated, the program throws an error and exits
                if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
                    //perform mathematical calculations and store the result in 'result' variable of the Calculator class
                    calc.setResult(calc.calculateExpressionConsistingTwoOperands(calc.getOperands(), calc.getOperators()));
                }
                //branch for calculating mathematical expressions with three operands
            } else {
                //extract characters from the string has gotten from user, remove excess signs and
                //put them into List 'operators' of the Calculator class
                calc.setOperators(handler.removeEven(handler.extractIntegers(handler.getUserInputInProcessing()),
                        handler.extractSymbols(handler.getUserInputInProcessing())));

                //set priority for signs of mathematical operations
                calc.setPriorityOfSings(handler.setOperatorsPriority(calc.getOperators()));

                //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
                //in cases of code, any condition is violated, the program throws an error and exits
                //in the same way as for the branch above
                if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
                    //perform mathematical calculations and store the result in 'result' variable of the Calculator class
                    calc.setResult(calc.calculateExpressionConsistingThreeOperands(calc.getOperands(), calc.getOperators(), calc.getPriorityOfSings()));
                }
            }

            //output the result variable of the Calculator class to the console
            System.out.println("Result of calculations is " + calc.getResult());

        } else {
            System.out.println("Incorrect format. The program terminates.");
        }









//        //extract integers from the string has gotten from user and put them into List 'operands' of the Calculator class
//        calc.setOperands(handler.extractIntegers(handler.getUserInputInProcessing()));
//
//        //checking for too short (size < 2) or too long (size > 2) elements in List 'numbers' of the Handler class
//        handler.checkSizeOfListNumbers(calc.getOperands());
//
//        //check for variance of calculations: if the size is 2,
//        // we move along the branch for calculating mathematical expressions with two operands
//        if (calc.getOperands().size() == 2) {
//            //collect the signs of mathematical operations in List 'symbols' of the Handler class
//            calc.setOperators(handler.extractSymbols(handler.getUserInputInProcessing(), calc.getOperands()));
//            //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
//            //in cases of code, any condition is violated, the program throws an error and exits
//            if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
//                //perform mathematical calculations and store the result in 'result' variable of the Calculator class
//                calc.setResult(calc.calculateExpressionConsistingTwoOperands(calc.getOperands(), calc.getOperators()));
//            }
//            //branch for calculating mathematical expressions with three operands
//        } else {
//            //extract characters from the string has gotten from user, remove excess signs and
//            //put them into List 'operators' of the Calculator class
//            calc.setOperators(handler.removeEven(handler.extractIntegers(handler.getUserInputInProcessing()),
//                    handler.extractSymbols(handler.getUserInputInProcessing())));
//
//            //set priority for signs of mathematical operations
//            calc.setPriorityOfSings(handler.setOperatorsPriority(calc.getOperators()));
//
//            //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
//            //in cases of code, any condition is violated, the program throws an error and exits
//            //in the same way as for the branch above
//            if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
//                //perform mathematical calculations and store the result in 'result' variable of the Calculator class
//                calc.setResult(calc.calculateExpressionConsistingThreeOperands(calc.getOperands(), calc.getOperators(), calc.getPriorityOfSings()));
//            }
//        }
//
//        //output the result variable of the Calculator class to the console
//        System.out.println("Result of calculations is " + calc.getResult());



        //My test section start <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//        List<String> examples = new ArrayList<>();
//        examples.add("5 - 2 + 8"); //=> 11
//        examples.add("5 + 8 - 2"); //=> 11
//        examples.add("-5 + 8 * 2"); //=> 11
//        examples.add("-10 / -10 + 7"); //=> 8
//        examples.add("-3 * 2 / -6"); //=> 1
//        examples.add("8 / -4 * 5"); //=> -10
//        //examples.add("8 + -11 / 1"); //=> CalculatorInputIntegersException
//        //examples.add("8 / 0"); //=> CalculatorInputIntegersException
//        //examples.add("7 % 3 + 1"); //=> CalculatorInputOperatorsException
//        //examples.add("4 & 3"); //=> CalculatorInputOperatorsException
//        examples.add("-5 * 2"); //=> -10
//        examples.add("4 - -4"); //=> 8
//        examples.add("8 / -2"); //=> -4
//        examples.add("2 + 7"); //=> 9
//        examples.add("7 - 2"); //=> 5
//
//        for (String str : examples) {
//            handler.setUserInputInProcessing(str);
//
//            //extract integers from the string has gotten from user and put them into List 'operands' of the Calculator class
//            calc.setOperands(handler.extractIntegers(handler.getUserInputInProcessing()));
//
//            //checking for too short (size < 2) or too long (size > 2) elements in List 'numbers' of the Handler class
//            handler.checkSizeOfListNumbers(calc.getOperands());
//
//            //check for variance of calculations: if the size is 2,
//            // we move along the branch for calculating mathematical expressions with two operands
//            if (calc.getOperands().size() == 2) {
//                //collect the signs of mathematical operations in List 'symbols' of the Handler class
//                calc.setOperators(handler.extractSymbols(handler.getUserInputInProcessing(), calc.getOperands()));
//                //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
//                //in cases of code, any condition is violated, the program throws an error and exits
//                if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
//                    //perform mathematical calculations and store the result in 'result' variable of the Calculator class
//                    calc.setResult(calc.calculateExpressionConsistingTwoOperands(calc.getOperands(), calc.getOperators()));
//                }
//                //branch for calculating mathematical expressions with three operands
//            } else {
//                //extract characters from the string has gotten from user, remove excess signs and
//                //put them into List 'operators' of the Calculator class
//                calc.setOperators(handler.removeEven(handler.extractIntegers(handler.getUserInputInProcessing()),
//                        handler.extractSymbols(handler.getUserInputInProcessing())));
//
//                //set priority for signs of mathematical operations
//                calc.setPriorityOfSings(handler.setOperatorsPriority(calc.getOperators()));
//
//                //we check for compliance of operands and signs of mathematical operations with the necessary conditions,
//                //in cases of code, any condition is violated, the program throws an error and exits
//                //in the same way as for the branch above
//                if (handler.isValidNumbers(calc.getOperands()) && handler.isValidOperator(calc.getOperators())) {
//                    //perform mathematical calculations and store the result in 'result' variable of the Calculator class
//                    calc.setResult(calc.calculateExpressionConsistingThreeOperands(calc.getOperands(), calc.getOperators(), calc.getPriorityOfSings()));
//                }
//            }
//
//            //output the result variable of the Calculator class to the console
//            System.out.println("Result of calculations is " + calc.getResult());
//
//        }

        //My test section end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }
}