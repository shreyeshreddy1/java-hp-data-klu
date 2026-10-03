import java.util.*;
//Question 7: Income Tax
public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter income: ");
        double income = sc.nextDouble();
        int tax;

        if (income <= 300000) {
            tax = 0;
        } else if (income <= 700000) {
            tax = 10;
        } else {
            tax = 20;
        }

        System.out.println("Tax Rate: " + tax + "%");
        sc.close();
    }
}