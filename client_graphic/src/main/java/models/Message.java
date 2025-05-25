package models;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // یا یه عدد مشخص مثلاً 123456789L

    private String owner;
    private String content;

    Message(String owner, String content){
        this.content = content;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public String getContent() {
        return content;
    }
}
