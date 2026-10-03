import java.util.*;
//Question 3: Food Delivery
public class FoodDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order amount: ");
        double amount = sc.nextDouble();

        if (amount >= 500) {
            System.out.println("Free Delivery");
        } else {
            System.out.println("Delivery Charge = 50");
        }
        sc.close();
    }
}