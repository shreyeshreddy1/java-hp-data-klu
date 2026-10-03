import java.util.*;

public class n1 {
    String name;
    int rollno;
    String branch;

    n1(String name, int rollno, String branch) {
        this.name = name;
        this.rollno = rollno;
        this.branch = branch;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollno);
        System.out.println("Branch: " + branch);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollno = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter branch: ");
        String branch = sc.nextLine();

        n1 student = new n1(name, rollno, branch);
        student.display();
        sc.close();
    }
}
