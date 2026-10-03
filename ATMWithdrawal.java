import java.util.Scanner;

public class ATMWithdrawal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to withdraw: ");
        int amountToWithdraw = scanner.nextInt();

        
        if (amountToWithdraw <= 0 || amountToWithdraw % 100 != 0) {
            System.out.println("Invalid amount.  enter a positive multiple of 100.");
        } else {
            System.out.println("Here your cash will be dispensed:");

            int remainingAmount = amountToWithdraw;

            int notesOf2000 = remainingAmount / 2000;
            remainingAmount %= 2000;

            int notesOf500 = remainingAmount / 500;
            remainingAmount %= 500;

            int notesOf200 = remainingAmount / 200;
            remainingAmount %= 200;

            int notesOf100 = remainingAmount / 100;

            printNoteCount(notesOf2000, 2000);
            printNoteCount(notesOf500, 500);
            printNoteCount(notesOf200, 200);
            printNoteCount(notesOf100, 100);
        }

        scanner.close();
    }

    
    private static void printNoteCount(int count, int denomination) {
        if (count > 0) {
            String noteWord = (count == 1) ? "note" : "notes";
            System.out.println(count + " " + noteWord + " of ₹" + denomination);
        }
    }
}