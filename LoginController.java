package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField password;

    @FXML
    private Button signInButton;

    @FXML
    private TextField username;

    @FXML
    void signInButtonClicked(ActionEvent event) {
        AMS obj = new AMS();
        String un =username.getText();
        String pw = password.getText();

        if(obj.validateUser(username.getText(), password.getText())== true) {
            HelloApplication helloApplication = new HelloApplication();
            try {
                helloApplication.sceneChanging("MemberDashboard.fxml",event);

            } catch (Exception e) {
                System.out.println("Login page not loaded");
            }
        }
        else {
            System.out.println("No user exists");
        }
    }
}



