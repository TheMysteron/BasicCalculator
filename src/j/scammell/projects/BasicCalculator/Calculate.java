package j.scammell.projects.BasicCalculator;

import java.math.BigDecimal;

import static j.scammell.projects.BasicCalculator.Appl.NUMBER_REGEX;
import static j.scammell.projects.BasicCalculator.Appl.answer;
import static j.scammell.projects.BasicCalculator.Appl.exit;
import static j.scammell.projects.BasicCalculator.Appl.scanner;
import static j.scammell.projects.BasicCalculator.Appl.subject;

class Calculate {

    /**
     * Adds the subject to another number the user supplies
     */
    static void add() {
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to add to %s?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")) {
            exit();
            return;
        }

        calc = new BigDecimal(input);
        answer = subject.add(calc).stripTrailingZeros();

        System.out.println(String.format("%s added to %s equals %s\n", calc.toPlainString(), subject.toPlainString(), answer.toPlainString()));
    }

    /**
     * Multiplies the subject by another number the user supplies
     */
    static void multiply() {
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to multiply %s by?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")) {
            exit();
            return;
        }

        calc = new BigDecimal(input);
        answer = subject.multiply(calc).stripTrailingZeros();

        System.out.println(String.format("%s multiplied by %s equals %s\n", subject.toPlainString(), calc.toPlainString(), answer.toPlainString()));
    }

    /**
     * Subtracts another number the user supplies from the subject
     */
    static void subtract() {
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to subtract from %s?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")) {
            exit();
            return;
        }

        calc = new BigDecimal(input);
        answer = subject.subtract(calc).stripTrailingZeros();

        System.out.println(String.format("%s subtracted from %s equals %s\n", calc.toPlainString(), subject.toPlainString(), answer.toPlainString()));
    }

    /**
     * Divides the subject by another number the user supplies
     */
    static void divide() {
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to Divide %s by?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")) {
            exit();
            return;
        }

        calc = new BigDecimal(input);
        answer = subject.divide(calc, 10, BigDecimal.ROUND_CEILING).stripTrailingZeros();

        System.out.println(String.format("%s divided by %s equals %s\n", subject.toPlainString(), calc.toPlainString(), answer.toPlainString()));
    }
}