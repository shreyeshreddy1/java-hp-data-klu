import java.util.*;
//Question 27: Bank Login
public class BankLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Is password correct? (true/false): ");
        boolean passwordOK = sc.nextBoolean();
        System.out.print("Is OTP correct? (true/false): ");
        boolean otpOK = sc.nextBoolean();

        if (passwordOK) {
            if (otpOK) {
                System.out.println("Login");
            }
        }
        sc.close();
    }
}