package com.teachmeskills.homework7.calculator;

public class ArithmeticOperations extends Calculator implements Calculation {

    @Override
    public void calculations() {
        double firstNumber = getNumber();
        double secondNumber = getNumber();
        double result = arithmeticCalculation(firstNumber, secondNumber);
        System.out.println(result);
        while (true) {
            System.out.println(MENU);
            String str = scanner.nextLine();
            isQorM(str);
            if (str.toLowerCase().equals("c")) {
                firstNumber = result;
                secondNumber = getNumber();
                result = arithmeticCalculation(firstNumber, secondNumber);
                System.out.println(result);
            }
        }
    }

    private double arithmeticCalculation(double firstNumber, double secondNumber) {
        double result = 0;
        switch (getOperation()) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                try {
                    if (secondNumber == 0) {
                        throw new ArithmeticException("Нельзя делить на ноль.");
                    } else {
                        result = firstNumber / secondNumber;
                    }
                } catch (ArithmeticException exception) {
                    System.out.println(exception.getMessage());
                }
        }
        return result;
    }

    private double getNumber() {
        System.out.println(INPUT_NUMBER);
        double value;
        String str = scanner.nextLine();
        isQorM(str);
        try {
            value = Double.parseDouble(str);
        } catch (NumberFormatException exception) {
            System.out.println(INVALID_VALUE);
            value = getNumber();
        }
        return value;
    }

    private String getOperation() {
        System.out.println("Введите операцию: +, -, *, /");
        String operation = scanner.nextLine();
        isQorM(operation);
        if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
            System.out.println(INVALID_VALUE);
            operation = getOperation();
        }
        return operation;
    }
}
