public class asciiValue {
    public static void main(String[] args) {
        int asciiValue;
        for (int i = 0; i <= 255; i++){
            char letter = (char) (i);
            asciiValue = (int) letter;
            System.out.println("The ASCII value of " + letter + " is: " + asciiValue);
        }
    }
}
