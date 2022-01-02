package com.example.sdaproj;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;


public class taskController implements Initializable {


    @FXML
    private TextField member_name;

    @FXML
    private TextField TaskDeadline;

    @FXML
    private TextField TaskName;

    @FXML
    private Button create;


    @FXML
    private TextArea taskDesc;

    @FXML
    private Button backbtn;

    @FXML
    private TextField projName;

   // ObservableList<String> memberslist = FXCollections.observableArrayList("Eysha Fatima","Haider Ali","Saif Ali");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //MembersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //MembersList.setItems(memberslist);

    }


    @FXML
    void taskCreation(ActionEvent event) {
        if(event.getSource()==create){
            AMS systemObj = new AMS();
            systemObj.TaskCreate(TaskName.getText(),TaskDeadline.getText(),taskDesc.getText(),member_name.getText(),projName.getText());
        }

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


