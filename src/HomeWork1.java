import org.w3c.dom.ls.LSOutput;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class File1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("enter array length");
        //int arrayLength = scanner.nextInt();
        //System.out.println(maximumConsecutiveDigits(1,generateArray(arrayLength))); // решение первой задачи из семинара №1
        //printArray(arraySort(createArray(arrayLength), 3)); решение первой задачи из семинара №2

//решение домашнего задания. Семинар 1
        /*

        System.out.println(sumNumberFrom1ToN(100)); // задача 1
        System.out.println(factorialNumber(5)); // задача 1


        //printPrimeNumbersForm1ToN(1000);// решение домашнего задани. Семинар 1 Задача 2 version 1
        //printPrimeNumber(1000);// решение домашнего задания. Семинар 1 Задача 2 version 2

        //simpleCalculator(); // решение домашнего задания. Семинар 1 Задача 3
        //solveEquation("??","??", 44); // решение домашнего задания. Семинар 1 Задача 4
*/

        //printC1C2(6, 'c','a');      // решение первой задачи из семинара 2
        //System.out.println(lineCompression("I love love")); // решение второй задачи с семинара 2(с усложнением)

        //System.out.println(sqlQuery(createInfoFoSqlQuery("Sasha", "UA", null, "21"))); // решение домашнего задания Семинар 2 задание 1;

        int[] array = new int[]{5, 4, 3, 2, 1, 0};
        createLogFile("bublSort.txt");
        bublSortToPrintInLogFile("bublSort.txt", array);


        //createFile( "newFile.txt");
        //createFillFile("newFile.txt","test", 10);
        //writeFile("newFIle.txt", "Hello");
        //printFile("newFile.txt");


    }

    public static void logInFile(String filePath, String logInput) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(logInput + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        public static String simpleCalculatorFoLog () {
            StringBuilder stringBuilder = new StringBuilder();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first number:");
            double num1 = scanner.nextDouble();
            stringBuilder.append(num1);

            System.out.println("Enter the operation (+, -, , /):");
            char operator = scanner.next().charAt(0);
            stringBuilder.append(operator);

            System.out.println("Enter the second number:");
            double num2 = scanner.nextDouble();
            stringBuilder.append(num2);

            scanner.close();

            double result = 0;
            switch (operator) {
                case '+':
                    System.out.printf("Result: %.2f\n", num1 + num2);
                    result = num1 + num2;
                case '-':
                    System.out.printf("Result: %.2f\n", num1 - num2);
                    result = num1 - num2;
                case '*':
                    System.out.printf("Result: %.2f\n", num1 * num2);
                    result = num1 * num2;
                case '/':
                    if (num2 != 0) {
                        System.out.printf("Result: %.2f\n", num1 / num2);
                        result = num1 * num2;
                    } else {
                        System.out.println("You can't divide by zero!");
                        result = num1 * num2;
                    }
                default:
                    System.out.println("Error! Incorrect symbol");
            }
            return stringBuilder.append(" = " + result).toString();
        }

        public static void bublSortToPrintInLogFile (String filePath,int[] arrayFoSort){
            int temp;
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(Arrays.toString(arrayFoSort) + '\n');
                for (int i = 0; i < arrayFoSort.length; i++) {
                    for (int j = 1; j < arrayFoSort.length - i; j++) {
                        if (arrayFoSort[j] < arrayFoSort[j - 1]) {
                            temp = arrayFoSort[j - 1];
                            arrayFoSort[j - 1] = arrayFoSort[j];
                            arrayFoSort[j] = temp;
                            writer.write(Arrays.toString(arrayFoSort) + '\n');
                        }
                    }
                }
                writer.close();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        public static void createLogFile (String fileName){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.close();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }

        public static String sqlQuery (String[]dataSqlQuery){
            StringBuilder stringBuilder = new StringBuilder("Select * from student WHERE ");

            for (int i = 0; i < dataSqlQuery.length; i++) {

                switch (i) {
                    case 0:
                        stringBuilder.append(dataSqlQuery[i] != null ? "name = " + dataSqlQuery[i] : "");
                        continue;
                    case 1:
                        stringBuilder.append(dataSqlQuery[i] != null ? " country = " + dataSqlQuery[i] : "");
                        continue;
                    case 2:
                        stringBuilder.append(dataSqlQuery[i] != null ? " city = " + dataSqlQuery[i] : "");
                        continue;
                    case 3:
                        stringBuilder.append(dataSqlQuery[i] != null ? " age = " + dataSqlQuery[i] : "");
                        continue;
                }

            }
            return stringBuilder.toString();
        }

        public static String[] createInfoFoSqlQuery (String name, String country, String city, String age){
            String[] info = new String[]{name, country, city, age};
            return info;
        }

        public static void printFile (String fileName){
            File file = new File(fileName);
            try {
                FileReader fileReader = new FileReader(file);
                char[] printblChars = new char[(int) file.length()];
                fileReader.read(printblChars);
                for (char point : printblChars) {
                    System.out.print(point);
                }
                fileReader.close();
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }

        public static void writeFile (String filepath, String word){
            try {
                File file = new File(filepath);
                if (file.createNewFile()) System.out.println("File created" + " " + file.getName());
                else System.out.println("File already exists" + " " + file.getAbsolutePath());
                FileWriter writer = new FileWriter(file);
                for (int i = 0; i < 10; i++) {
                    writer.write(word + "\n");
                }
                writer.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        public static void createFillFile (String filepath, String word,int countMassage){
            try {
                FileWriter fileWriter = new FileWriter(filepath, false);
                for (int i = 0; i < countMassage; i++) {
                    fileWriter.write(word + "\n");
                }
                fileWriter.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }


        public static boolean checkForEqualityCharInString ( char check, String str){
            boolean isEquals = true;

            for (int i = 0; i < str.length(); i++) {

                if (check == str.charAt(i) && check != ' ') {
                    isEquals = false;
                }
            }
            return isEquals;
        }

        public static String lineCompression (String originalString){
            StringBuilder stringBuilder = new StringBuilder();
            char check;
            int temp = 0;

            for (int i = 0; i < originalString.length(); i++) {
                check = originalString.charAt(i);

                if (!checkForEqualityCharInString(check, stringBuilder.toString())) continue;

                if (check != '1' && check != '2' && check != '3' && check != '4' && check != '5'
                        && check != '6' && check != '7' && check != '8' && check != '9' && check != '0' && check != ' ') {

                    for (int j = 0; j < originalString.length(); j++) {
                        if (check == originalString.charAt(j) && checkForEqualityCharInString(check, stringBuilder.toString())) {
                            temp++;
                        }
                    }

                    if (temp > 1) stringBuilder.append(check).append(temp);
                    else stringBuilder.append(check);

                    temp = 0;
                }
            }
            return stringBuilder.toString();
        }

        public static String printC1C2 ( int n, char first, char second){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n / 2 && n % 2 == 0; i++) {
                stringBuilder.append(first).append(second);
            }
            System.out.println(stringBuilder);
            return stringBuilder.toString();
        }

        public static void solveEquation (String num1, String num2,int Response){
            boolean hasSolution = false;

            for (int i = 0; i < 10; i++) {
                String currentEquation1 = num1.replace('?', (char) (i + '0'));
                String currentEquation2 = num2.replace('?', (char) (i + '0'));
                int sum = Integer.parseInt(currentEquation1) + Integer.parseInt(currentEquation2);

                if (sum == Response) {
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

        public static double simpleCalculator () {
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

        public static void printPrimeNumber ( int limit){
            for (int i = 2; i < limit; i++) {
                if (isPrimeNumber(i)) {
                    System.out.print(i + ", ");
                }
            }
        }

        public static boolean isPrimeNumber ( int n){
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static void printPrimeNumbersForm1ToN ( int n){
            for (int i = 1; i <= n; i++) {
                if (i == 1 || i == 2 || i == 3 || i == 5 || i == 7) System.out.print(i + ", ");
                else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) System.out.print(i + ", ");
            }
        }

        public static int sumNumberFrom1ToN ( int n){
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }

        public static int factorialNumber ( int number){
            if (number < 1) return 1;
            return number * factorialNumber(--number);
        }

        public static void printArray ( int[] array){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
            System.out.println();
        }

        public static int[] createArray ( int arrayLength){
            Random random = new Random();
            int[] array = new int[arrayLength];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(1, 5);
                System.out.print(array[i]);
            }
            System.out.println();
            return array;
        }

        public static int[] arraySort ( int[] array, int digitsFoSort){
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

        public static int maximumConsecutiveDigits ( int digits, int[] array){
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

        public static int[] generateArray ( int lengthArray){
            Random random = new Random();
            int[] array = new int[lengthArray];

            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(0, 2);
                System.out.print(array[i]);
            }

            return array;
        }
    }
