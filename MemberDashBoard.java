package com.example.sdaproj;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberDashBoard implements Initializable
{

    @FXML
    private ListView<String> ProjectList_iD;

    @FXML
    private ListView<String> announcement_ID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        //System.out.println(HelloApplication.currentID);
        AMS systemObj = new AMS();
        ArrayList<Project> proj_list = systemObj.showProject();
        //Project proj = systemObj.showProject();
        // Projects Display

       // systemObj.todoCreate();
        int count = proj_list.size();
        System.out.println(count);
        for(int counter = 0 ; counter < proj_list.size(); counter++) {
            String str = proj_list.get(counter).getProjName();
            //System.out.println(str);
            //announcement_ID.getItems().add(str);

            String projStr = "";
            projStr += proj_list.get(counter).getProjName();
            projStr += "~";
            projStr += proj_list.get(counter).getProjDeadline();
            ProjectList_iD.getItems().add(projStr);
            String str1 = proj_list.get(counter).getProjName();
            String str2 = proj_list.get(counter).getProjDeadline();

        }

        //announcements display
        ArrayList<String> announcement_arr = systemObj.showAnnouncements();
        int x = announcement_arr.size();
        //System.out.println(x);
        for(int counter = 0 ; counter < announcement_arr.size(); counter++) {
            String str = announcement_arr.get(counter);
            //System.out.println(str);
            announcement_ID.getItems().add(str);
        }
    }

    @FXML
    void showProjDetails(ActionEvent event)
    {
        Helper memory_obj = Helper.getInstance();
        int selection = ProjectList_iD.getSelectionModel().getSelectedIndex();
        System.out.println(ProjectList_iD.getSelectionModel().getSelectedIndex());
        ObservableList<String> list = ProjectList_iD.getItems();
        System.out.println();
        String str = list.get(selection);
        String str1 ="";
        boolean flag = false;
        for(int i=0;i<str.length() - 1 && flag == false; i++)
        {
            if( str.charAt(i) == '~')
            {
                flag = true;
                continue;
            }
            else {
                str1 += str.charAt(i);
                System.out.println(str.charAt(i));
            }
        }
        memory_obj.getProj().setProjName(str1);
        HelloApplication main = new HelloApplication();

        try {
            main.sceneChanging("ProjectPage.fxml", event);

        } catch (Exception e) {
            System.out.println("Login page not loaded");
        }
    }

    @FXML
    void announcementCreationPg(ActionEvent event)
    {
        HelloApplication main = new HelloApplication();

        try {
            main.sceneChanging("CreateAnnouncement.fxml", event);

        } catch (Exception e) {
            System.out.println("Announcement Page not loaded. ");
        }
    }


}
