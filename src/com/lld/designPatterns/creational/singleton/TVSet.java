package com.lld.designPatterns.creational.singleton;

/*
✅ Purpose of Singleton Pattern
    - Ensure only one instance of a class is created during the application's lifetime.
    - Provides a global access point to that single instance.
    - Useful for shared resources like configuration, logging, cache, thread pools, etc.
    - Helps control resource usage and maintain consistent state across threads.
*/

public class TVSet {
    /*Without volatile, changes made by one thread might not be visible to others.
    * if we synchronized whole function all the thread are waiting despite instance is created
    * and that is not good so what we can do is we just make the tvSetInstance = new TVSet() line synchronised    *
    * */
    private static TVSet tvSetInstance = null;
    private TVSet(){
        System.out.println("TVSet Instantiated!");
    }
    /* Thread Safe
        public static synchronized TVSet getTvSetInstance() {
            if (instance == null) {
                instance = new TVSet();
            }
            return instance;
        }
     */

    // Double-Checked Locking
    public static TVSet getTvSetInstance(){
        if(tvSetInstance == null){
            synchronized (TVSet.class){
                if(tvSetInstance == null)
                    tvSetInstance = new TVSet();
            }
        }

        return tvSetInstance;
    }

}
