import java.util.Scanner;

public class GradeIE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grade (E/V/G/A/F/e/v/g/a/f): ");
        char grade = sc.next().charAt(0);

        if (grade == 'E' || grade == 'e') {
            System.out.println("Excellent");
        } else if (grade == 'V' || grade == 'v') {
            System.out.println("Very Good");
        } else if (grade == 'G' || grade == 'g') {
            System.out.println("Good");
        } else if (grade == 'A' || grade == 'a') {
            System.out.println("Average");
        } else if (grade == 'F' || grade == 'f') {
            System.out.println("Fail");
        } else {
            System.out.println("Invalid Grade");
        }
        sc.close();
    }
}