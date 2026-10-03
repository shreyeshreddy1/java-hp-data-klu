import java.util.*;
//Question 13: Quiz
public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter question number to submit at: ");
        int submitAt = sc.nextInt();
        boolean submit = false;

        for (int q = 1; q <= 20; q++) {
            System.out.println("Question " + q);
            if (q == submitAt) {
                submit = true;
            }
            if (submit) {
                System.out.println("Quiz submitted!");
                break;
            }
        }
        sc.close();
    }
}