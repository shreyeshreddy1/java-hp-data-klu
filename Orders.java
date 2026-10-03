import java.util.*;
//Question 21: Orders
public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of orders: ");
        int total = sc.nextInt();
        System.out.print("Enter cancelled order number: ");
        int cancelled = sc.nextInt();

        for (int o = 1; o <= total; o++) {
            if (o == cancelled) {
                continue;
            }
            System.out.println("Processing Order: " + o);
        }
        sc.close();
    }
}