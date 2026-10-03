import java.util.*;
//Question 30: Smart Lift 
public class SmartLift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter floor number: ");
        int floor = sc.nextInt();

        switch (floor) {
            case 0:
                System.out.println("Ground");
                break;
            case 1:
                System.out.println("First");
                break;
            default:
                System.out.println("Invalid");
        }
        sc.close();
    }
}