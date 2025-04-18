import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        double[] grades = new double[10];
        Scanner s = new Scanner(System.in);
        double average = 0, min = 11, max = -1;

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce the grade number " + (i + 1) + " : ");
            grades[i] = s.nextDouble();
            average = average + grades[i];

            if (grades[i] < min) {
                min = grades[i];
            }
            if (grades[i] > max) {
                max = grades[i];
            }
        }

        System.out.println("The average of the group is: " + average/10);
        System.out.println("The lowest grade in the group is: " + min);
        System.out.println("The highest grade in the group is: " + max);

        System.out.println("The grades are: ");
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Grade N."+ (i + 1) + " : " + grades[i]);
        }

    }
}
