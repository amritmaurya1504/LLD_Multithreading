package com.lld.designPatterns.creational.prototype;

/*
✅ Purpose of Prototype Pattern:
    1. To create new objects by copying an existing object (the prototype).
    2. Avoids the cost of creating objects from scratch, especially when construction is expensive.
    3. Supports cloning of complex or resource-intensive objects.
    4. Allows dynamic creation of objects at runtime without knowing their exact class.

    ❓ Why do we use clone() instead of the original object?
        Because sometimes we want a copy of the object that starts with the same data but can be modified independently, without affecting the original.
*/

public class Main {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        NetworkConnection original = new NetworkConnection();
        original.setIp("127.0.0.1");
        original.loadImpData();

        // Clone to get New Instance with same data
        NetworkConnection copy1 = (NetworkConnection)original.clone();
        copy1.setIp("127.0.0.2");

        NetworkConnection copy2 = (NetworkConnection)original.clone();
        copy2.setIp("127.0.0.3");
        copy2.getDomains().remove(0);

        System.out.println(original);
        System.out.println(copy1);
        System.out.println(copy2);
    }
}
