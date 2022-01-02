package com.example.sdaproj;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {

    Stage stg;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //dbConnection();

        /*
        Helper memory_obj = Helper.getInstance();
        memory_obj.setCurrentID(3);
        System.out.println("yh dekho ->  "+memory_obj.getCurrentID());

         */
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene1 = new Scene(root);
        stg.setScene(scene1);
        stg.show();
    }


    public void sceneChanging(String sceneInput , ActionEvent event) throws IOException {
        try {
            //System.out.println("inside scene changing");
            Parent root1 = FXMLLoader.load(getClass().getResource(sceneInput));
            Scene scene1 = new Scene(root1);
            stg = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg.setScene(scene1);

           // System.out.println("outside scene changing");
        } catch (Exception e) {
            System.out.println("Scene can not be loaded");
        }
    }

    public void dbConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ams", "root", "1234");
            System.out.println("Connection Established");

            /*
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from member");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));//)+" "+ rs.getString(3));
            }

             */
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }






}