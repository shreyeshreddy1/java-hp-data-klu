import java.util.*;
//Question 11: Month
public class Month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month number: ");
        int month = sc.nextInt();

        switch (month) {
            case 1:
                System.out.println("January");
                break;
            default:
                System.out.println("Invalid");
        }
        sc.close();
    }
}
