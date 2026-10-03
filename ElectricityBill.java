import java.util.*;
//Question 8: Electricity Bill
public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();
        int rate;

        if (units <= 100) {
            rate = 2;
        } else if (units <= 200) {
            rate = 4;
        } else {
            rate = 6;
        }

        System.out.println("Rate per unit: " + rate);
        sc.close();
    }
}