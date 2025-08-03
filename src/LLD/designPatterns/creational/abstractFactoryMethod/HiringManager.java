package LLD.designPatterns.creational.abstractFactoryMethod;

public class HiringManager {
    private final Developer junior;
    private final Developer senior;

    public HiringManager(EmployeeFactory factory){
        this.junior = factory.createJuniorDeveloper();
        this.senior = factory.createSeniorDeveloper();
    }

    public void getHiringDetails(){
        System.out.println(junior.getRole() + " => ₹" + junior.getSalary());
        System.out.println(senior.getRole() + " => ₹" + senior.getSalary());
    }
}
