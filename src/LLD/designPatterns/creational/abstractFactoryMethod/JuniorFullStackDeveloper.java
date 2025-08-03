package LLD.designPatterns.creational.abstractFactoryMethod;

public class JuniorFullStackDeveloper implements Developer{
    @Override
    public String getRole() {
        return "Junior Full Stack Developer";
    }

    @Override
    public int getSalary() {
        return 70000;
    }
}
