package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Date;

public class SignUpController {

    @FXML
    private DatePicker dob;

    @FXML
    private TextField member_name;

    @FXML
    private TextField password;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField username;

    @FXML
    void signUpButtonClicked(ActionEvent event) {


      //  System.out.println("inside Controller");

        String un =username.getText();
        String pw = password.getText();
        String mn = member_name.getText();

        LocalDate date_dob = dob.getValue();

        String d =  String.valueOf(date_dob);


       System.out.println(d);

        AMS systemObj = new AMS();
        boolean condition = systemObj.NewUser(un,pw, mn, d);

        if(condition) {
            HelloApplication helloApplication = new HelloApplication();
            try {
                helloApplication.sceneChanging("MemberDashBoard.fxml",event);

            } catch (Exception e) {
                System.out.println("sign up page not loaded");
            }
        }

    }

}
