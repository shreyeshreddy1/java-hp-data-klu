import java.util.*;
//Question 5: Placement
public class Placement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        if (age >= 18) {
            if (cgpa >= 8) {
                System.out.println("Eligible");
            }
        }
        sc.close();
    }
}