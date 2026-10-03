import java.util.*;
//Question 16: ATM Menu 
public class ATMMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
        } while (choice != 3);

        System.out.println("Thank you!");
        sc.close();
    }
}