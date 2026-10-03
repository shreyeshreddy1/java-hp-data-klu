import java.util.*;

// Question 14: Password Retry
public class PasswordRetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pwd = "";

        // Keep asking until the correct password is entered
        while (!pwd.equals("java")) {
            System.out.print("enter password: ");
            pwd = sc.next();
        }

        System.out.println("password stored successfully");
        sc.close();
    }
}