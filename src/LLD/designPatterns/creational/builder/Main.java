package LLD.designPatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        User u1 = new User.Builder()
                .setUserId("123")
                .setFullName("Amrit Raj")
                .setEmail("amrit@gmail.com")
                .setUserName("rajamrit")
                .build();

        System.out.println(u1);
    }
}
