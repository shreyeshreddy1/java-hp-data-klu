import java.util.*;
//Question 6: Hospital
public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Is patient registered? (true/false): ");
        boolean registered = sc.nextBoolean();
        System.out.print("Is patient insured? (true/false): ");
        boolean insured = sc.nextBoolean();

        if (registered) {
            if (insured) {
                System.out.println("Admit Patient");
            }
        }
        sc.close();
    }
}