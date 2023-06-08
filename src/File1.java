import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("enter array length");
        //int arrayLength = scanner.nextInt();
        //System.out.println(maximumConsecutiveDigits(1,generateArray(arrayLength))); // решение первой задачи из семинара №1
        //printArray(arraySort(createArray(arrayLength), 3)); решение первой задачи из семинара №2

        /*
                                                    //решение домашнего задания. Задача 1
        System.out.println(sumNumberFrom1ToN(100));
        System.out.println(factorialNumber(5));
         */
        //printPrimeNumbersForm1ToN(1000);// решение домашнего задани. Задача 2 version 1
        //printPrimeNumber(1000);// решение домашнего задания. Задача 2 version 2

        //simpleCalculator(); // решение домашнего задания. Задача 3
        //solveEquation("??","??", 44); // решение домашнего задания. Задача 4

    }

    public static void solveEquation(String num1, String num2, int Response) {
        boolean hasSolution = false;

        for (int i = 0; i < 10; i++) {
            String currentEquation1 = num1.replace('?', (char) (i + '0'));
            String currentEquation2 = num2.replace('?', (char) (i + '0'));
            int sum = Integer.parseInt(currentEquation1) + Integer.parseInt(currentEquation2);

            if(sum == Response){
                System.out.println("Solution: " + Integer.parseInt(currentEquation1) +
                        " + " + Integer.parseInt(currentEquation2) + " = " + sum);
                hasSolution = true;
                break;
            }
        }
        if (!hasSolution) {
            System.out.println("No solutions");
        }
    }

    public static double simpleCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter the operation (+, -, , /):");
        char operator = scanner.next().charAt(0);
        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();
        scanner.close();

        switch (operator) {
            case '+':
                System.out.printf("Result: %.2f\n", num1 + num2);
                return num1 + num2;
            case '-':
                System.out.printf("Result: %.2f\n", num1 - num2);
                return num1 - num2;
            case '*':
                System.out.printf("Result: %.2f\n", num1 * num2);
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    System.out.printf("Result: %.2f\n", num1 / num2);
                } else {
                    System.out.println("You can't divide by zero!");
                }
                return num1 / num2;
            default:
                System.out.println("Error! Incorrect symbol");

                return 10 / 0;
        }
    }

    public static void printPrimeNumber(int limit) {
        for (int i = 2; i < limit; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeNumbersForm1ToN(int n) {
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 5 || i == 7) System.out.print(i + ", ");
            else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) System.out.print(i + ", ");
        }
    }

    public static int sumNumberFrom1ToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorialNumber(int number) {
        if (number < 1) return 1;
        return number * factorialNumber(--number);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static int[] createArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 5);
            System.out.print(array[i]);
        }
        System.out.println();
        return array;
    }

    public static int[] arraySort(int[] array, int digitsFoSort) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != digitsFoSort) {
                array[index] = array[i];
                index++;
            }
        }
        while (index < array.length) {
            array[index++] = digitsFoSort;
        }
        return array;
    }

    public static int maximumConsecutiveDigits(int digits, int[] array) {
        int temp = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == digits) {
                temp++;
                if (temp > count) count = temp;
            } else {
                temp = 0;
            }
        }
        System.out.println();

        return count;
    }

    public static int[] generateArray(int lengthArray) {
        Random random = new Random();
        int[] array = new int[lengthArray];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 2);
            System.out.print(array[i]);
        }

        return array;
    }
}
