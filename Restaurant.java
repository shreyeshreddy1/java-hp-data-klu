import java.util.*;
//Question 9: Restaurant
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter choice (1-Pizza, 2-Burger): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Pizza");
                break;
            case 2:
                System.out.println("Burger");
                break;
            default:
                System.out.println("Invalid");
        }
        sc.close();
    }
}