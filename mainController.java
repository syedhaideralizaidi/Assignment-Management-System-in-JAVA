package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class mainController {

    @FXML
    private Button ldr;

    @FXML
    private Button m_id;

    @FXML
    void leaderBtnClicked(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        try {
            helloApplication.sceneChanging("homePage.fxml",event);

        } catch (Exception e) {
            System.out.println("Login page not loaded");
        }
    }

    @FXML
    void memberbtnClicked(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        try {
            helloApplication.sceneChanging("homePage.fxml",event);

        } catch (Exception e) {
            System.out.println("Login page not loaded");
        }

    }

}


