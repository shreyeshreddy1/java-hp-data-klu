import java.util.Scanner;

public class ain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1, sum = 0; 
        while (i <= n && i <= 100) { 
            sum += i; 
            i++; 
            sc.close();
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);

    }
}