import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork2 {
    public static void main(String[] args) {
        //{"surname": "Ivanov", "grade": "5", "subject": "Mathematics"},{"surname": "Petrova", "grade": "4", "subject": "Computer Science"},{"surname": "Krasnov", "grade": "5", "subject": "Physics"}
        //printC1C2(6, 'c','a');      // решение первой задачи из семинара 2
        //System.out.println(lineCompression("I love love")); // решение второй задачи с семинара 2(с усложнением)

        //System.out.println(sqlQuery(createInfoFoSqlQuery("Sasha", "UA", null, "21"))); // решение домашнего задания Семинар 2 задание 1;

        //int[] array = new int[]{5, 4, 3, 2, 1, 0};                                    //решение домашнего задания Семинар 2 задание 2
        //createLogFile("bublSort.txt");
        //bublSortToPrintInLogFile("bublSort.txt", array);

        printGradesFromFile("School_Subjects_and_Students.txt");              // решение дополнительного домашнего задания семинара 2

        //logInFile("simpleCalculatorWithLog.txt", simpleCalculatorFoLog());                          //решение домашнего задания Семинар 2 задание 4

    }

    public static void printGradesFromFile(String pathFile){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseLine(line);

            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void parseLine(String line) {
        Pattern pattern = Pattern.compile("\\{\"surname\": \"(.*?)\", \"grade\": \"(.*?)\", \"subject\": \"(.*?)\"}");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String surname = matcher.group(1);
            String grade = matcher.group(2);
            String subject = matcher.group(3);
            String result = String.format("Student %s has taken %s in the course %s", surname, grade, subject);
            System.out.println(result);
        }
    }

    public static void logInFile(String filePath, String logInput) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(logInput + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String simpleCalculatorFoLog() {
        StringBuilder stringBuilder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();
        stringBuilder.append(num1);

        System.out.println("Enter the operation (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        stringBuilder.append(operator);

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();
        stringBuilder.append(num2);

        scanner.close();

        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 * num2;
                    break;
                } else {
                    return stringBuilder.append(" = " + "You can't divide by zero!").toString();
                }
        }
        return stringBuilder.append(" = " + result).toString();
    }

    public static void bublSortToPrintInLogFile(String filePath, int[] arrayFoSort) {
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


    public static void createLogFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String[] createInfoFoSqlQuery(String name, String country, String city, String age) {
        String[] info = new String[]{name, country, city, age};
        return info;
    }

    public static void printFile(String fileName) {
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


    public static String sqlQuery(String[] dataSqlQuery) {
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


    public static String lineCompression(String originalString) {
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

    public static boolean checkForEqualityCharInString(char check, String str) {
        boolean isEquals = true;

        for (int i = 0; i < str.length(); i++) {

            if (check == str.charAt(i) && check != ' ') {
                isEquals = false;
            }
        }
        return isEquals;
    }

    public static String printC1C2(int n, char first, char second) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2 && n % 2 == 0; i++) {
            stringBuilder.append(first).append(second);
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public static void solveEquation(String num1, String num2, int Response) {
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
}


