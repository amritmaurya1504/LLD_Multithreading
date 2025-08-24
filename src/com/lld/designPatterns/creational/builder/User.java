package com.lld.designPatterns.creational.builder;
/*
✅ Purpose of Builder Pattern
    - To construct complex objects step by step.
    - Useful when a class has multiple optional or required fields.
    - Promotes immutability and readable object creation.
 */
public class User {
    private final String userId;
    private final String fullName;
    private final String userName;
    private final String email;

    private User(Builder builder){
        this.userId = builder.userId;
        this.fullName = builder.fullName;
        this.userName = builder.userName;
        this.email = builder.email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{
        private String userId;
        private String fullName;
        private String userName;
        private String email;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
