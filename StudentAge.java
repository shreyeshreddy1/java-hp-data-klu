import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
    String name;
    double age;

    StudentRecord(String name, double age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "| age: " + age + "years";
    }
}

public class StudentAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentRecord> records = new ArrayList<>();

        while (true) {
            System.out.println("\n===== student age =====");
            System.out.println("1. student1");
            System.out.println("2. student2");
            System.out.println("3. student3");
            System.out.println("4. student4");
            System.out.println("5. student5");
            System.out.println("6. student6");
            System.out.println("7. student7");
            System.out.println("8. student8");
            System.out.println("9. student9");
            System.out.println("10. student10");
            System.out.println("11. Show all records");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            if (choice >= 1 && choice <= 10) {
                String[] names = {"student1", "student2", "student3", "student4", "student5", "student6", "student7", "student8", "student9", "student10"};
                System.out.print("Enter name: ");
                String name = sc.nextLine().trim();
                System.out.print("Enter age: ");
                double age = Double.parseDouble(sc.nextLine().trim());

                records.add(new StudentRecord(name, age));
                System.out.println("Age stored successfully!");
                System.out.println("Total records: " + records.size());
            }
            else if (choice == 11) {
                if (records.isEmpty()) {
                    System.out.println("No records yet.");
                } else {
                    for (StudentRecord r : records) {
                        System.out.println(r);
                    }
                }
            }
            else if (choice == 12) {
                System.out.println("Thank you for using the student age system!");
                break;
            }
            else {
                System.out.println("Invalid choice! Please select 1-12.");
            }
        }
        sc.close();
    }
}