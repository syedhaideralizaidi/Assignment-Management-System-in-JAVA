package com.example.sdaproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class ProjectPage implements Initializable {

    @FXML
    private Text nameID;

    @FXML
    private Text deadlineID;

    @FXML
    private Text descID;

    @FXML
    private ListView<String> listID;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AMS systemObj = new AMS();
        Project proj = systemObj.projectDetails();

        nameID.setText(proj.getProjName());
        deadlineID.setText(proj.getProjDeadline());
        descID.setText(proj.getProjDesc());

        int x = proj.getProj_Team().size();
        //System.out.println(x);
        for(int counter = 0 ; counter < proj.getProj_Team().size(); counter++) {
            String str = proj.getProj_Team().get(counter).getMember_name();
            //System.out.println(str);
            listID.getItems().add(proj.getProj_Team().get(counter).getMember_name());
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

    @FXML
    void TaskCreate(ActionEvent event) {
        HelloApplication main = new HelloApplication();

        try {
            main.sceneChanging("tasks.fxml", event);
        } catch (Exception e) {
            System.out.println("Page Not loaded");
        }



    }


}


