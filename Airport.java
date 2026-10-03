import java.util.*;
//Question 28: Airport
public class Airport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Has passport? (true/false): ");
        boolean passport = sc.nextBoolean();
        System.out.print("Has visa? (true/false): ");
        boolean visa = sc.nextBoolean();
        System.out.print("Has ticket? (true/false): ");
        boolean ticket = sc.nextBoolean();

        if (passport) {
            if (visa) {
                if (ticket) {
                    System.out.println("Boarding Pass");
                }
            }
        }
        sc.close();
    }
}