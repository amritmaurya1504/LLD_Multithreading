package LLD.designPatterns.creational.abstractFactoryMethod;

public class AndroidFactory implements EmployeeFactory{
    @Override
    public Developer createJuniorDeveloper() {
        return new JuniorAndroidDeveloper();
    }

    @Override
    public Developer createSeniorDeveloper() {
        return new SeniorAndroidDeveloper();
    }
}
