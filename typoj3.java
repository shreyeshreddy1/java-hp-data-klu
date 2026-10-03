import java.util.Scanner;
public class typoj3 {
    public static void main(String args[]){
        System.out.print("Enter Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.print("first name: ");
        String firstName = sc.nextLine();
        System.out.print("last name: ");
        String lastName = sc.nextLine();
        System.out.print(firstName+" "+lastName);
        sc.close();  
    }
}
    

