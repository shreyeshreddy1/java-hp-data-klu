import java.util.Scanner;
public class ParcelIntake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the weight of the parcel (in kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the destination country: ");
        String country = scanner.next();

        double shippingCost = calculateShippingCost(weight, country);
        System.out.printf("The shipping cost for your parcel is:$%.2f%n", shippingCost);
    }

    private static double calculateShippingCost(double weight, String country) {
        double baseRate = 5.00; // Base rate for shipping
        double weightRate = 2.00; // Rate per kg

        
        if (country.equalsIgnoreCase("USA")) {
            return baseRate + (weight * weightRate);
        } else if (country.equalsIgnoreCase("Canada")) {
            return baseRate + (weight * weightRate * 1.2); 
        } else {
            return baseRate + (weight * weightRate * 1.5); 
        }
    }
}