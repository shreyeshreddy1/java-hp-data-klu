import java.util.*;
//Question 18: Salary Slips
public class SalarySlips {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of slips to generate: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Slip " + i);
        }
        sc.close();
    }
}
