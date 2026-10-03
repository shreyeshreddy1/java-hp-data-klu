import java.util.*;
//Question 19: Marks
public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of roll numbers to print: ");
        int n = sc.nextInt();

        for (int r = 1; r <= n; r++) {
            System.out.println(r);
        }
        sc.close();
    }
}