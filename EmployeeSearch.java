import java.util.*;
//Question 12: Employee Search
public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID to find: ");
        int empId = sc.nextInt();

        for (int i = 1; i <= 100; i++) {
            if (i == empId) {
                System.out.println("Employee found at position: " + i);
                break;
            }
        }
        sc.close();
    }
}
