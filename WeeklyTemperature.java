import java.util.Scanner;

public class WeeklyTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] weeklyTemperatures = new int[7];
        for(int i = 0; i < 7; i++) {
            System.out.print("Enter the temperature for day " + i + ": ");
            weeklyTemperatures[i] = scanner.nextInt();
            System.out.println("weeklyTemperatures[" + i + "] = " + weeklyTemperatures[i]);
        }
        System.out.println("weeklyTemperature[0] = " + weeklyTemperatures[0]);
        System.out.println("weeklyTemperature[6] = " + weeklyTemperatures[6]);
        System.out.println("weeklyTemperature sum of all days = " + (weeklyTemperatures[0] + weeklyTemperatures[1] + weeklyTemperatures[2] + weeklyTemperatures[3] + weeklyTemperatures[4] + weeklyTemperatures[5] + weeklyTemperatures[6]));
        System.out.println("weeklyTemperature average of all days = " + ((weeklyTemperatures[0] + weeklyTemperatures[1] + weeklyTemperatures[2] + weeklyTemperatures[3] + weeklyTemperatures[4] + weeklyTemperatures[5] + weeklyTemperatures[6]) / 7));
        System.out.println("weeklyTemperature sum of day0 and day6 = " + (weeklyTemperatures[0] + weeklyTemperatures[6]));


    }
}
