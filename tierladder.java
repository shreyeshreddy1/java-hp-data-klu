import java.util.Scanner;
public class tierladder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter the score: ");
        int score = scanner.nextInt();
        if (score >= 0 && score <= 100) {
            if (score >= 90) {
                System.out.println("Tier: S");
            } else if (score >= 80) {
                System.out.println("Tier: A");
            } else if (score >= 70) {
                System.out.println("Tier: B");
            } else if (score >= 60) {
                System.out.println("Tier: C");
            } else {
                System.out.println("Tier: D");
            }
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
        
        }

        scanner.close();
    }
        
}
