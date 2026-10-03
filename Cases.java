import java.util.Scanner;
public class Cases {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("give alphabet :");
        char Case = sc.next().charAt(0);

        if (Case>='a' && Case<='z'){
            System.out.println("Lower case words");
        }
        else if (Case>='A' && Case<='Z'){
            System.out.println("Upper case words");
        }
        else {
            System.out.println("not a case sensitive.");
        }
        sc.close();
    }
}