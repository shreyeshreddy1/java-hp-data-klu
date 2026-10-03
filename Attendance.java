import java.util.*;
//Question 20: Attendance
public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total roll numbers: ");
        int total = sc.nextInt();
        System.out.print("Enter absent roll number to skip: ");
        int absent = sc.nextInt();

        for (int i = 1; i <= total; i++) {
            if (i == absent) {
                continue;
            }
            System.out.println(i);
        }
        sc.close();
    }
}