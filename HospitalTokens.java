import java.util.*;
//Question 15: Hospital Tokens
public class HospitalTokens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();
        int t = 1;

        while (t <= n) {
            System.out.println(t++);
        }
        sc.close();
    }
}