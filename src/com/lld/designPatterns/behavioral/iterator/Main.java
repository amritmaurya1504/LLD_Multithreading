package com.lld.designPatterns.behavioral.iterator;

/*
✅ Purpose of Iterator Pattern
    - To provide a standard way to access elements of a collection sequentially without exposing its underlying structure.
    - Supports different types of traversals (forward, backward, filtered) in a uniform way.
    - Promotes the Single Responsibility Principle by separating iteration logic from the collection itself.
    - Makes it easy to swap or modify traversal algorithms without changing the collection’s code.

Traversal logic is separate from storage logic
- UserManagement is only responsible for managing users — adding them, holding them, etc.
- MyIteratorImpl is responsible for traversal logic — moving the pointer, knowing when the end is reached.

--- This separation means you could change the storage from ArrayList to LinkedList or even a database query, and the external traversal code in Main wouldn’t change.

 */


public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        User u1 = new User("Amrit Raj", "am@gmail.com");
        User u2 = new User("Raj Ankit", "ankit@gmaill.com");
        userManagement.addUser(u1);
        userManagement.addUser(u2);

        MyIterator myIterator = userManagement.getIterator();
        while (myIterator.hasNext()){
            User user = (User) myIterator.next();
            System.out.println(user.getName() + " " + user.getEmail());
        }
    }
}
