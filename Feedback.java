import java.util.*;
//Question 17: Feedback
public class Feedback {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Feedback");
            System.out.print("Enter choice (0 to Exit): ");
            choice = sc.nextInt();
        } while (choice != 0);

        System.out.println("Thank you for your feedback!");
        sc.close();
    }
}