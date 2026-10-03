import java.util.*;
//Question 22: Server
public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Server is listening...");
            System.out.print("Enter 'stop' to shut down server: ");
            String command = sc.next();
            if (command.equalsIgnoreCase("stop")) {
                break;
            }
        }
        System.out.println("Server stopped.");
        sc.close();
    }
}