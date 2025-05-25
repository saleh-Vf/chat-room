package models;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MessageCardSelf {

    public static AnchorPane createMessageCard(String nameText, String contentText, LocalTime timeOfSend) {
        // لایه داخلی که کارت اصلیه
        AnchorPane messageContainer = new AnchorPane();
        messageContainer.setId("messageCardSelf");
        messageContainer.setPadding(new Insets(10));
        messageContainer.setMaxWidth(600);

        // متن پیام
        Label content = new Label(contentText);
        content.setWrapText(true);
        content.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        content.setMaxWidth(600);
        content.setPrefHeight(Region.USE_COMPUTED_SIZE);
        content.setId("content");

        AnchorPane.setTopAnchor(content, 26.0);
        AnchorPane.setLeftAnchor(content, 30.0);
        AnchorPane.setRightAnchor(content, 30.0);
        AnchorPane.setBottomAnchor(content, 30.0);

        // نام فرستنده
        Label name = new Label(nameText);
        AnchorPane.setTopAnchor(name, 2.0);
        AnchorPane.setRightAnchor(name, 2.0);
        name.setId("name");

        // زمان ارسال
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Label time = new Label(timeOfSend.format(formatter));
        AnchorPane.setBottomAnchor(time, 2.0);
        AnchorPane.setLeftAnchor(time, 2.0);
        time.setId("time");

        messageContainer.getChildren().addAll(content, name, time);

        // کانتینر بیرونی برای مدیریت موقعیت
        AnchorPane wrapper = new AnchorPane();
//        AnchorPane.setLeftAnchor(messageContainer, );  // بچسبه به چپ
        AnchorPane.setTopAnchor(messageContainer, 0.0);
        AnchorPane.setRightAnchor(messageContainer,0D ); // کل عرض

        wrapper.getChildren().add(messageContainer);
        wrapper.setPrefWidth(Region.USE_COMPUTED_SIZE); // عرض با والد
        wrapper.setPrefHeight(Region.USE_COMPUTED_SIZE); // ارتفاع طبق محتوا

        return wrapper;
    }


}
