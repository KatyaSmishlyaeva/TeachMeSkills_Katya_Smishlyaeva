package com.teachmeskills.homework7.calculator;

import com.teachmeskills.homework7.calculator.exeptions.*;

public class Calculator {

    private Menu menu;

    public Calculator() {
        this.menu = new Menu();
    }

    public void start() {
        while (true) {
            try {
                menu.getInput();
            } catch (ExitException e) {
                System.out.println("Пока...");
                break;
            } catch (InvalidInputException e) {
                System.err.println(e.getMessage());
            } catch (BackToMenuException e) {
                continue;
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            } catch (CalculationException e) {
                e.printStackTrace();
            }
        }
    }
}
