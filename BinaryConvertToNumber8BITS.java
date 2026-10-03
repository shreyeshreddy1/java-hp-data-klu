public class BinaryConvertToNumber8BITS {
    public static void main(String[] args) {
        String binaryString = "00101010"; // Example 8-bit binary string
        int decimalValue = Integer.parseInt(binaryString, 2); // Convert binary to decimal
        System.out.println("The decimal value of binary " + binaryString + " is: " + decimalValue);
    }
}
