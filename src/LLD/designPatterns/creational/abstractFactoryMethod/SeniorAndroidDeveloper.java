package LLD.designPatterns.creational.abstractFactoryMethod;

public class SeniorAndroidDeveloper implements Developer{
    @Override
    public String getRole() {
        return "Senior Android Developer";
    }

    @Override
    public int getSalary() {
        return 60000;
    }
}
