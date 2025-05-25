package models;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MessageCard {

    public static AnchorPane createMessageCard(String owner, String contentText) {
        AnchorPane messageContainer = new AnchorPane();
        messageContainer.setPrefSize(176.0, 118.0);
        messageContainer.setPadding(new Insets(10, 10, 10, 10));
        messageContainer.setId("messageCard"); // برای اتصال به CSS

        // Label اصلی محتوای پیام
        Label content = new Label();
        content.setPrefSize(116.0, 62.0);
        content.setWrapText(true);
        AnchorPane.setTopAnchor(content, 26.0);
        AnchorPane.setBottomAnchor(content, 30.0);
        AnchorPane.setLeftAnchor(content, 30.0);
        AnchorPane.setRightAnchor(content, 30.0);
        content.setId("content");
        content.setText(contentText);

        // Label اسم فرستنده بالا سمت راست
        Label name = new Label(owner);
        AnchorPane.setTopAnchor(name, 2.0);
        AnchorPane.setRightAnchor(name, 2.0);
        name.setId("name");

        // Label پایین سمت چپ (مثلاً زمان یا هر چی)
        Label time = new Label("10:02");
        AnchorPane.setBottomAnchor(time, 2.0);
        AnchorPane.setLeftAnchor(time, 2.0);

        messageContainer.getChildren().addAll(content, name, time);

        return messageContainer;
    }
}
