import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        String s = Integer.toString(n);
        System.out.print("Digits: ");
        for (int i = 0; i < s.length(); i++) {
        System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
        sc.close();
    }
}


