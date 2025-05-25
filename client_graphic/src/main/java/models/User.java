package models;

public class User {
    private static String name;
    public User(String name){
        this.name = name;
    }

    public static String getName() {
        return name;
    }
}
