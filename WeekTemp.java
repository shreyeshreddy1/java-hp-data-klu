import java.util.ArrayList;
import java.util.Scanner;

class DayTemp {
    String day;
    String time;
    double temperature;

    DayTemp(String day, String time, double temperature) {
        this.day = day;
        this.time = time;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return day + " | Time: " + time + " | Temp: " + temperature + "C";
    }
}

public class WeekTemp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DayTemp> records = new ArrayList<>();

        while (true) {
            System.out.println("\n===== This Week's Temperature =====");
            System.out.println("1. Monday");
            System.out.println("2. Tuesday");
            System.out.println("3. Wednesday");
            System.out.println("4. Thursday");
            System.out.println("5. Friday");
            System.out.println("6. Saturday");
            System.out.println("7. Sunday");
            System.out.println("8. Show all records");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice >= 1 && choice <= 7) {
                String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday","Friday", "Saturday", "Sunday"};
                System.out.print("Enter time: ");
                String time = sc.nextLine().trim();
                System.out.print("Enter temperature: ");
                double temp = Double.parseDouble(sc.nextLine().trim());

                records.add(new DayTemp(days[choice - 1], time, temp));
                System.out.println("Temperature stored successfully!");
                System.out.println("Total records: " + records.size());
            }
            else if (choice == 8) {
                if (records.isEmpty()) {
                    System.out.println("No records yet.");
                } else {
                    for (DayTemp r : records) {
                        System.out.println(r);
                    }
                }
            }
            else if (choice == 9) {
                System.out.println("Thank you for using the temperature system!");
                break;
            }
            else {
                System.out.println("Invalid choice! Please select 1-9.");
            }
        }
        sc.close();
    }
}