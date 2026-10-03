import java.util.Scanner;

public class pjtpro{
    public static void main(String args[]){
        System.out.print("Enter Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
    
        System.out.print("Enter phone no.: ");
        String phoneNo = sc.nextLine();
        System.out.print("age: ");
        String age = sc.nextLine();
        System.out.println("Age : "+age);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Email : "+email);
        sc.close();
    }
}