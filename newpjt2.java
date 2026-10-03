import java.util.Random;
import java.util.Scanner;
public class newpjt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone no.: ");
        String phoneNo = sc.nextLine();
        System.out.print("Enter parcel size s/m/l/xl: ");
        String parcelSize1 = sc.nextLine();
        int otp = 1000000 + random.nextInt(900000);
        System.out.println("Name: "+name);
        System.out.println("Phone No: "+phoneNo);
        System.out.println("parcel size: "+parcelSize1);
        System.out.println("Your OTP is: " + otp);
        System.out.println("PLEASE COLLECT PARCEL");
        System.out.print("Enter your phone number: ");
        String enteredPhone = sc.nextLine();
        System.out.print("Enter your OTP: ");
        int enteredOtp = sc.nextInt();
        if (enteredPhone.equals(phoneNo) && enteredOtp == otp) {
            System.out.println("\nOTP verified successfully!");
            System.out.println("Parcel can be collected.");
            System.out.println("Name: " + name);
            System.out.println("Phone No: " + phoneNo);
            System.out.println("Parcel Size: " + parcelSize1);
        } else {
            System.out.println("\nInvalid phone number or OTP.");
            System.out.println("Parcel cannot be collected.");
        }

        sc.close();
    }
}
    

