package j.scammell.projects.BasicCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

import static j.scammell.projects.BasicCalculator.Calculate.add;
import static j.scammell.projects.BasicCalculator.Calculate.divide;
import static j.scammell.projects.BasicCalculator.Calculate.multiply;
import static j.scammell.projects.BasicCalculator.Calculate.subtract;

class Appl {

    static final String NUMBER_REGEX = "^([0-9]+(\\.[0-9]+)?)|([Qq])$"; // Regex to check if a number (or Q/q) is entered
    static final Scanner scanner = new Scanner(System.in); // Scanner for console input

    static BigDecimal subject; // The subject of the calculations
    static BigDecimal answer; // The answer of the calculations

    private static boolean loop = true; // boolean for the whole calculation loop
    private static boolean askUseAnswer = true; // boolean for the first continue question (use answer)
    private static boolean askNewCalculation = true; // boolean for the second continue question (new calculation)

    /**
     * Runs the loop, and runs the program in the correct order.
     */
    static void run() {
        while (loop) {
            setSubject();
            action();
            newCalculation();
            useAnswer();
        }
    }

    /**
     * Sets ths subject of the calculation if it is not already set.
     */
    private static void setSubject() {
        if (subject == null) {
            String input;
            do {
                System.out.println("Please enter a number:");
                input = scanner.next();
            } while (!input.matches(NUMBER_REGEX));

            if (input.equalsIgnoreCase("Q")) {
                exit();
                return;
            }
            subject = new BigDecimal(input);
        }
    }

    /**
     * Asks the user what action they would like to take on the subject of the calculation
     */
    private static void action() {
        if (loop) {
            System.out.println(String.format("What calculation would you like to perform on %s?\n" +
                    "[A]ddition, [S]ubtraction, [M]ultiplication or [D]ivision:", subject.toPlainString()));
            String input = scanner.next().toUpperCase();

            // Can only use switch with integral/exact values.
            // So need to use a series of if/else if/else statements
            if (input.startsWith("A")) {
                add();
            } else if (input.startsWith("S")) {
                subtract();
            } else if (input.startsWith("M")) {
                multiply();
            } else if (input.startsWith("D")) {
                divide();
            } else if (input.equals("Q")) {
                exit();
            }
        }
    }

    /**
     * Asks the user whether they want to use the answer of the current calculation in the next calculation
     */
    private static void useAnswer() {
        while (askUseAnswer) {
            System.out.println(String.format("Do you want to continue using %s?\n" +
                    "[Y]es or [N]o:", answer.toPlainString()));
            String input = scanner.next();
            if (input.toUpperCase().startsWith("Y")) {
                subject = answer; // set the new subject to the old answer
                answer = null; // clear the old answer
                break; // exit the loop
            } else if (input.toUpperCase().startsWith("N")) {
                subject = null; // clear the subject
                break; // exit the loop
            } else if (input.equalsIgnoreCase("Q")) {
                exit();
            }
        }
    }

    /**
     * Asks the user if they would like to do another calculation
     */
    private static void newCalculation() {
        while (askNewCalculation) {
            System.out.println("Do you want to perform another calculation?\n[Y]es or [N]o:");
            String input = scanner.next();
            if (input.toUpperCase().startsWith("Y")) {
                break;
            } else if (input.toUpperCase().startsWith("N") || input.equalsIgnoreCase("Q")) {
                exit();
            }
        }
    }

    /**
     * Sets all run booleans to false so the program will end.
     */
    static void exit() {
        loop = false;
        askUseAnswer = false;
        askNewCalculation = false;
        System.out.println("Ending Basic Calculator");
    }
}