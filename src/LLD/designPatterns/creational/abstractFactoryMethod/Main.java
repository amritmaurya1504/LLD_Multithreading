package LLD.designPatterns.creational.abstractFactoryMethod;

/*
✅ Purpose of Abstract Factory Pattern

    - To provide an interface for creating families of related or dependent objects
      without specifying their concrete classes.
    - Useful when the system needs to be independent of how its products are created, composed, and represented.
    - Promotes consistency among products in a family (e.g., UI components for different themes or OSes).
    - Encourages scalability and follows the Open/Closed Principle by allowing easy extension of product families.
*/


public class Main {
    public static void main(String[] args) {
        EmployeeFactory factory = new FullStackFactory();
        HiringManager manager = new HiringManager(factory);
        manager.getHiringDetails();
    }
}
