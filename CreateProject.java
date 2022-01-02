package com.example.sdaproj;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateProject implements Initializable {



    @FXML
    private TextField projName;

    @FXML
    private TextField projDeadline;

    @FXML
    private TextArea projDesc;

    @FXML
    private ListView<String> List_ID;

    private ArrayList<members> memberList = new ArrayList<>();

    @FXML
    private TextField memberName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

    @FXML
    public void projCreation(ActionEvent event)
    {

        AMS systemObj = new AMS();
        systemObj.projCreate(projName.getText(),projDeadline.getText(),projDesc.getText(),memberList);
        //System.out.println(memberList.size());
    }

    @FXML
    public void selectFromMenu(MouseEvent event)
    {
    }

    @FXML
    public void addMember(ActionEvent event) {
        String nameEntry = memberName.getText();
        AMS systemObj = new AMS();
        boolean checkMember = systemObj.checkMember(nameEntry);
        if(checkMember == true)
        {
            members obj = systemObj.getMember(nameEntry);
            System.out.println(obj.getMember_name());
            List_ID.getItems().add(memberName.getText());
            memberList.add(obj);
        }
        else
        {
            System.out.println("No such member.");
        }

    }

    @FXML
    public void removeMember(MouseEvent event) {
        int selection1 = List_ID.getSelectionModel().getSelectedIndex();
        List_ID.getItems().remove(selection1);
        //memberList.remove(selection1)
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


