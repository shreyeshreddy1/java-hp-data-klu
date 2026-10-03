import java.util.*;
//Question 24: Parking
public class Parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();
        System.out.print("Enter number of slots per floor: ");
        int slots = sc.nextInt();

        for (int f = 1; f <= floors; f++) {
            System.out.print("Floor " + f + ": ");
            for (int s = 1; s <= slots; s++) {
                System.out.print("P" + s + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}