package LLD.designPatterns.creational.abstractFactoryMethod;

public class JuniorAndroidDeveloper implements Developer{
    @Override
    public String getRole() {
        return "Junior Android Developer";
    }

    @Override
    public int getSalary() {
        return 30000;
    }
}
