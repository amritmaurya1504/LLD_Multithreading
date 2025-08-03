package LLD.designPatterns.creational.abstractFactoryMethod;

public class FullStackFactory implements EmployeeFactory{
    @Override
    public Developer createJuniorDeveloper() {
        return new JuniorFullStackDeveloper();
    }

    @Override
    public Developer createSeniorDeveloper() {
        return new SeniorFullStackDeveloper();
    }
}
