import java.util.Scanner;

public class GrossSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        double hra , da;

        if (basic <= 10000) {
            hra = 0.20 * basic;
            da  = 0.80 * basic;
        } else if (basic <= 20000) {
            hra = 0.25 * basic;
            da  = 0.90 * basic;
        } else {
            hra = 0.30 * basic;
            da  = 0.95 * basic;
        }

        double gross = basic + hra + da;
        System.out.println("Gross Salary = " + gross);
        sc.close();
    }
}
