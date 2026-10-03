import java.util.*;
//Question 23: Cinema
public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of seats per row: ");
        int seats = sc.nextInt();

        for (int r = 1; r <= rows; r++) {
            for (int s = 1; s <= seats; s++) {
                System.out.print("S ");
            }
            System.out.println();
        }
        sc.close();
    }
}
