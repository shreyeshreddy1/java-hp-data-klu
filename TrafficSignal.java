import java.util.*;
//Question 10: Traffic Signal
public class TrafficSignal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal (R/Y/G): ");
        char signal = sc.next().charAt(0);

        switch (signal) {
            case 'R':
                System.out.println("STOP");
                break;
            case 'Y':
                System.out.println("READY");
                break;
            case 'G':
                System.out.println("GO");
                break;
        }
        sc.close();
    }
}