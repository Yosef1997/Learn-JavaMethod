import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chooseMethod();
    }

    static void chooseMethod() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("""
            1. SimpleCalculator
            2. CalculateFibonacci
            3. RemoveOddNumber
            4. FizzBuzzInsert
            5. FindTargetInRange\s
            Insert method that you want to use:""");
    int method = scanner.nextInt();

    switch (method){
        case 1: {
            simpleCalculator();
            break;
        }
        case 2: {
            calculateFibonacciIteration();
            break;
        }
        case 3: {
            removeOddNumber();
            break;
        }
        case 4: {
            fizzBuzzInsert();
            break;
        }
        case 5: {
            findTargetInRange();
            break;
        }
        default: {
            System.out.println("Method doesn't found");
            break;
        }
    }
    scanner.close();

}

    static void simpleCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Insert second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Insert one of the operators (+,-,*,/): ");
        String operator = scanner.next();

        var result = switch (operator){
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> "operator is invalid";
        };

        scanner.close();

        System.out.println("result = " + result);
    }

    static void calculateFibonacciIteration() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert fibonacci number: ");
        int fibonacciNumber = scanner.nextInt();

        System.out.println("Which method do you want to use? Iteration / Restructive (i/r): ");
        String method = scanner.next();

        if(Objects.equals(method, "i") || Objects.equals(method, "I")) {
            if (fibonacciNumber == 0) {
                System.out.println(fibonacciNumber);
                return;
            }

            if (fibonacciNumber == 1) {
                System.out.println(fibonacciNumber + 1);
                return;
            }

            int previous = 0;
            int current = 1;
            int result = 0;

            for (int i = 2; i <= fibonacciNumber; i++) {
                result = previous + current;
                previous = current;
                current = result;
            }

            System.out.println("fibonacci iteration= " + result);
        }

        if(Objects.equals(method, "r") || Objects.equals(method, "R")){
            System.out.println("fibonacci restructive= " + calculateFibonacciRestructive(fibonacciNumber));
        }

        scanner.close();
    }

    static int calculateFibonacciRestructive(int input) {
        if (input == 0){
            return 0;
        }

        if (input == 1) {
            return 1;
        }

        return calculateFibonacciRestructive(input-1) + calculateFibonacciRestructive(input-2);
    }

    static void removeOddNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert range number: ");
        int number = scanner.nextInt();

        scanner.close();

        ArrayList<Integer> range = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= number; ++i){
            range.add(i);
        }

        for (Integer integer : range) {
            if (integer % 2 == 0) {
                result.add(integer);
            }
        }

        System.out.println(result);
    }

    static void fizzBuzzInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert range to insert fizz and buzz: ");
        int number = scanner.nextInt();

        scanner.close();

        ArrayList<Integer> range = new ArrayList<>();
        ArrayList<Object> result = new ArrayList<>();

        for (int i = 1; i <= number; ++i){
            range.add(i);
        }

        for (Integer integer : range) {
            if (integer % 3 == 0 && integer % 5 == 0) {
                result.add("FizzBuzz");
            }
            else if (integer % 3 == 0) {
                result.add("Fizz");
            }
            else if (integer % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(integer);
            }
        }

        System.out.println(result);
    }

    static void findTargetInRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert range: ");
        int number = scanner.nextInt();

        System.out.println("Insert target: ");
        int target = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> range = new ArrayList<>();

        for (int i = 1; i <= number; ++i){
            range.add(i);
        }

        for (int i = 0; i < (range.size() - 1); i++){
            for (int j = i + 1; j < range.size(); j++){
                if (range.get(i) + range.get(j) == target) {
                    ArrayList<Object> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    System.out.println("result = " + result);
                    return;
                }
            }
        }
    }
}