package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void signInButtonClicked(ActionEvent event) {

        //if(event) {
            HelloApplication helloApplication = new HelloApplication();
            try {
                helloApplication.sceneChanging("log-in.fxml",event);

            } catch (Exception e) {
                System.out.println("Login page not loaded");
            }
        }

    @FXML
    public void goBack(ActionEvent event)
    {
        HelloApplication main = new HelloApplication();

        try {
            main.sceneChanging("main.fxml", event);
        } catch (Exception e) {
            System.out.println("Page Not loaded");
        }
    }

    @FXML
    void signUpButtonClicked(ActionEvent event) {
        System.out.println("inside hom controller and sign up button");
        HelloApplication helloApplication = new HelloApplication();
        try {
            helloApplication.sceneChanging("Sign-up.fxml",event);
            System.out.println("leaving home controller");

        } catch (Exception e) {
            System.out.println("Login page not loaded");
        }

    }

}
