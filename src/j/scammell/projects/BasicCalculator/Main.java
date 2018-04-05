package j.scammell.projects.BasicCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static BigDecimal subject;
    private static BigDecimal answer;
    private static Scanner scanner = new Scanner(System.in);

    private static final String NUMBER_REGEX = "^([0-9]+(\\.[0-9]+)?)|([Qq])$";

    public static void main(String[] args){
        boolean cont = true;
        boolean ask1 = true;
        boolean ask2 = false;
        subject = null;

        System.out.println("If at any point you want to quit, type Q and press enter.");

        do {
            if (subject == null) {
                String input;
                do {
                    System.out.println("Please enter a number:");
                    input = scanner.next();
                } while (!input.matches(NUMBER_REGEX));

                if (input.equalsIgnoreCase("Q")){
                    System.out.println("Ending Basic Calculator");
                    break;
                }

                subject = new BigDecimal(input);
            }

            System.out.println(String.format("What calculation would you like to perform on %s?\n" +
                    "[A]ddition, [S]ubtraction, [M]ultiplication or [D]ivision:", subject.toPlainString()));
            String calc = scanner.next();

            if (calc.toUpperCase().startsWith("A")){
                ask1 = addition();
            } else if (calc.toUpperCase().startsWith("S")){
                ask1 = subtraction();
            } else if (calc.toUpperCase().startsWith("M")){
                ask1 = multiplication();
            } else if (calc.toUpperCase().startsWith("D")){
                ask1 = division();
            } else if (calc.equalsIgnoreCase("Q")){
                System.out.println("Ending Basic Calculator");
                break;
            }

            while (ask1){
                System.out.println(String.format("Do you want to continue calculating with %s?\n" +
                        "[Y]es or [N]o:", answer.toPlainString()));
                String contin = scanner.next();
                if (contin.toUpperCase().startsWith("Y")){
                    subject = answer.stripTrailingZeros();
                    answer = null;
                    ask1 = false;
                } else if (contin.toUpperCase().startsWith("N")){
                    subject = null;
                    ask1 = false;
                    ask2 = true;
                } else if (contin.equalsIgnoreCase("Q")){
                    System.out.println("Ending Basic Calculator");
                    ask1 = false;
                    ask2 = false;
                    cont = false;
                }
            }

            while (ask2) {
                System.out.println("Do you want to perform another calculation?\n[Y]es or [N]o:");
                String another = scanner.next();
                if (another.toUpperCase().startsWith("Y")) {
                    ask2 = false;
                } else if (another.toUpperCase().startsWith("N") || another.equalsIgnoreCase("Q")){
                    System.out.println("Ending Basic Calculator");
                    ask2 = false;
                    cont = false;
                }
            }
        } while (cont);
    }

    private static boolean addition(){
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to add to %s?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")){
            System.out.println("Ending Basic Calculator");
            return false;
        }

        calc = new BigDecimal(input);
        answer = subject.add(calc).stripTrailingZeros();

        System.out.println(String.format("%s added to %s equals %s\n", calc.toPlainString(), subject.toPlainString(), answer.toPlainString()));

        return true;
    }

    private static boolean subtraction(){
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to subtract from %s?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")){
            System.out.println("Ending Basic Calculator");
            return false;
        }

        calc = new BigDecimal(input);
        answer = subject.subtract(calc).stripTrailingZeros();

        System.out.println(String.format("%s subtracted from %s equals %s\n", calc.toPlainString(), subject.toPlainString(), answer.toPlainString()));

        return true;
    }

    private static boolean multiplication(){
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to multiply %s by?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")){
            System.out.println("Ending Basic Calculator");
            return false;
        }

        calc = new BigDecimal(input);
        answer = subject.multiply(calc).stripTrailingZeros();

        System.out.println(String.format("%s multiplied by %s equals %s\n", subject.toPlainString(), calc.toPlainString(), answer.toPlainString()));

        return true;
    }

    private static boolean division(){
        BigDecimal calc;
        String input;

        do {
            System.out.println(String.format("What number do you want to divide %s by?", subject.toPlainString()));
            input = scanner.next();
        } while (!input.matches(NUMBER_REGEX));

        if (input.equalsIgnoreCase("Q")){
            System.out.println("Ending Basic Calculator");
            return false;
        }

        calc = new BigDecimal(input);
        answer = subject.divide(calc, 10, BigDecimal.ROUND_CEILING).stripTrailingZeros();

        System.out.println(String.format("%s divided by %s equals %s\n", subject.toPlainString(), calc.toPlainString(), answer.toPlainString()));

        return true;
    }
}