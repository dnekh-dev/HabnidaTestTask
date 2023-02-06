public class Main {
    public static void main(String[] args) throws CalculatorInputIntegersException, CalculatorInputOperatorsException {

        Calculator calc = new Calculator();
        Handler handler = new Handler();

        String str = handler.getInputString();

        if (handler.isValidNumbers(handler.extractIntegers(str)) && handler.isValidOperator(handler.extractOperators(str))) {
            calc.setOperands(handler.extractIntegers(str));
            calc.setOperators(handler.removeEven(handler.extractIntegers(str), handler.extractOperators(str)));
            calc.setResult(calc.calculationOfUserInput(calc.getOperands(), calc.getOperators()));
        }

//        System.out.println(calc.getOperands());
//        System.out.println(calc.getOperators());
        System.out.println(calc.getResult());

    }

}