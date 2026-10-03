import java.util.*;
//Question 29: Amazon Discount
public class AmazonDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter purchase amount: ");
        double amount = sc.nextDouble();
        int dis;

        if (amount > 10000) {
            dis = 20;
        } else if (amount > 5000) {
            dis = 10;
        } else {
            dis = 5;
        }

        System.out.println("Discount: " + dis + "%");
        sc.close();
    }
}