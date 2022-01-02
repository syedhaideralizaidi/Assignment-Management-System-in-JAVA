package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class CreateAnnouncement {

    @FXML
    private TextArea announcement_ID;

    @FXML
    private TextArea member_name;

    @FXML
    void createAnnouncement(ActionEvent event)
    {
        AMS systemObj = new AMS();
        systemObj.createAnnouncement(announcement_ID.getText());
    }

    @FXML
    public void goBack(ActionEvent event)
    {
        HelloApplication main = new HelloApplication();

        try {
            main.sceneChanging("LeaderDashBoard.fxml", event);
        } catch (Exception e) {
            System.out.println("Page Not loaded");
        }
    }
}
