package models;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // یا یه عدد مشخص مثلاً 123456789L

    private String owner;
    private String content;
    private LocalTime time;

    Message(String owner, String content){
        this.content = content;
        this.owner = owner;
        this.time = LocalTime.now();
    }

    public String getOwner() {
        return owner;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
