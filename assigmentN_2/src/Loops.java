import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        //1. Using For Loops
        for (int i = 1; i<=10; i++) {
            System.out.println(i);
        }

        int resultSum = 0;
        for (int i = 1; i<=10; i++) {
            resultSum = resultSum + i;
        }
        System.out.println("resultSum = " + resultSum);

        Scanner s = new Scanner(System.in);
        System.out.println("Give a number to give you its multiplication table: ");
        int userNum = s.nextInt();

        for (int i = 1; i<=10; i++) {
            System.out.println(userNum + " * " + i + " = " + userNum*i);
        }

        //2. Using While Loops
        System.out.println("Give a positive number: ");
        userNum = s.nextInt();

        int digitSum = 0;
        while(userNum > 0) {
            digitSum = digitSum + (userNum % 10);
            userNum = userNum / 10;
        }

        System.out.println("The sum of the digits is: " + digitSum);

        int userChoose;
        //3. Using Do-While Loops
        do {
            System.out.println("\n\nWelcome to the Calculator!" +
                    "\n\nPlease select an operation: " +
                    "\n1. Addition" +
                    "\n2. Subtraction" +
                    "\n3. Multiplication" +
                    "\n4. Division" +
                    "\n5. Exit" +
                    "\n\nEnter your choice: ");
            userChoose = s.nextInt();
            double num1,num2;
            switch (userChoose) {
                case 1:
                    System.out.println("Enter the first number: ");
                    num1 = s.nextDouble();
                    System.out.println("Enter the second number: ");
                    num2 = s.nextDouble();
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Enter the first number: ");
                    num1 = s.nextDouble();
                    System.out.println("Enter the second number: ");
                    num2 = s.nextDouble();
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Enter the first number: ");
                    num1 = s.nextDouble();
                    System.out.println("Enter the second number: ");
                    num2 = s.nextDouble();
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case 4:
                    System.out.println("Enter the first number: ");
                    num1 = s.nextDouble();
                    System.out.println("Enter the second number: ");
                    num2 = s.nextDouble();
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
                case 5:
                    System.out.println("Exiting the calculator. Thank you!");
                    break;
                default:
                    System.out.println("Option not available");
            }
        }while (userChoose != 5);

    }
}
