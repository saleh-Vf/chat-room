package models;

public class User {
    private static User user ;
    private String name;
    User(String name){
        this.name = name;
    }
    public static User getuser(String name){
        if (user==null) user =new User(name);
        return user;
    }
    public static User getuser(){
        return user;
    }

    public String getName() {
        return name;
    }
}
