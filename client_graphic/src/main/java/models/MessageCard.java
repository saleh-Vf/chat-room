package models;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class MessageCard {

    public static AnchorPane createMessageCard(String nameText, String contentText) {
        AnchorPane messageContainer = new AnchorPane();
        messageContainer.setId("messageCard");
        messageContainer.setPadding(new Insets(10, 10, 10, 10));

        // محتوای پیام
        Label content = new Label(contentText);
        content.setWrapText(true);
        AnchorPane.setTopAnchor(content, 26.0);
        AnchorPane.setLeftAnchor(content, 30.0);
        AnchorPane.setRightAnchor(content, 30.0);
        AnchorPane.setBottomAnchor(content, 30.0);
        content.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        content.setWrapText(true);           // فعال کردن شکستن متن به خط بعدی
        content.setMaxWidth(600);
        content.setPrefHeight(Region.USE_COMPUTED_SIZE);
        // نام فرستنده
        Label name = new Label(nameText);
        AnchorPane.setTopAnchor(name, 2.0);
        AnchorPane.setRightAnchor(name, 2.0);

        // زمان
        Label time = new Label("10:02");
        AnchorPane.setBottomAnchor(time, 2.0);
        AnchorPane.setLeftAnchor(time, 2.0);

        messageContainer.getChildren().addAll(content, name, time);

        return messageContainer;
    }
}
