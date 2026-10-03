import java.util.*;
//Question 4: Login
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.next();

        if (password.equals("java123")) {
            System.out.println("Login Success");
        } else {
            System.out.println("Invalid Password");
        }
        sc.close();
    }
}
