import java.util.*;
//Question 2: Voting
public class Voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Eligible to Vote");
        }
        sc.close();
    }
}
