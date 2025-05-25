package models;

import java.io.Serializable;

public class Message implements Serializable {
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
