package ds303.review.generic;

public class Car {
    private static String model;

    public Car(String model) {
        this.model = model;
    }

    public void printModel() {
        System.out.println("Car Model = " + model);
    }

    // Demo
    public static void main(String[] args) {
        Car honda = new Car("Civic");
        Car toyta = new Car("Pilot");
        honda.printModel();
        toyta.printModel();
    }
}
