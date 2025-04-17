import java.util.Scanner;

public class firstAssignment {
    public static void main(String[] args) {
        //1. Exploring Variables and Primitive Types
        int age = 23;
        double height = 62.20;
        char initial = 'J';
        boolean isStudent = false;

        System.out.println("age = " + age);
        System.out.println("height = " + height);
        System.out.println("initial = " + initial);
        System.out.println("isStudent = " + isStudent);

        //2. Increment and Decrement Operations
        int counter = 10;
        counter++;
        System.out.println("counter = " + counter);

        counter--;
        System.out.println("counter = " + counter);

        for (;counter<=15;counter++){
            System.out.println("counter = " + counter);
        }

        while(counter>10){
            counter--;
            System.out.println("counter = " + counter);
        }

        //3. Working with Strings and User Input
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String firstName = s.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = s.nextLine();
        String fullName = firstName + ' ' + lastName;

        String fullNameUpperCase = fullName.toUpperCase();
        char first = fullName.charAt(0);
        int times = 1;

        for(int i = 1; i < fullName.length(); i++) {
            if(first == fullName.charAt(i)){
                times++;
            }
        }

        System.out.println(fullName);
        System.out.println(fullNameUpperCase);
        System.out.println("The number of times "+ first +" appears in " + fullName + " is : " + times);

        //4. Using Conditionals, Logical Operators, and Switch
        int testScore1 = 33;
        int testScore2 = 66;
        int testScore3 = 99;
        int averageScore = (testScore1 + testScore2 + testScore3) / 3;

        if( averageScore >=90 ) {
            System.out.println("Excellent");
        } else if ( averageScore >= 70 && averageScore <= 89) {
            System.out.println("Good");
        } else if (averageScore >= 50 && averageScore <= 69) {
            System.out.println("Average");
        } else {
            System.out.println("Poor");
        }

        int day = 5;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }

        //5. Basic Calculator
        double num1,num2,result = 0;
        String operation;

        System.out.println("Enter the first number: ");
        num1 = s.nextInt();

        System.out.println("Enter the second number: ");
        num2 = s.nextInt();

        System.out.println("Enter the operation (+, -, *, /): ");
        s.nextLine();
        operation = s.nextLine();

        switch (operation.charAt(0)) {
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
                result = num1 / num2;
                break;
        }
        System.out.println("result = " + result);
        System.out.println(result++);
        System.out.println(result--);

        System.out.println("");

    }
}
