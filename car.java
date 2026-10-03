public class car {
    String color;
    void displayColor() {
        System.out.println("The color of the car is: " + color);
    }
    public static void main(String[] args) {
        car car1 = new car();
        car1.color = "Red";

        car car2 = new car();
        car2.color = "Blue";
        System.out.println("Car 1 color: " + car1.color);
        System.out.println("Car 2 color: " + car2.color);
        System.out.println("car colors:");
        car1.displayColor();
        car2.displayColor();
    }
}
