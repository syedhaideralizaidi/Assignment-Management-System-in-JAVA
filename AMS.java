package com.example.sdaproj;

import java.time.LocalDate;
import java.util.ArrayList;

public class AMS {

    public boolean NewUser(String username_input,  String pass, String nameInput, String date_input)
    {
        System.out.println("inside AMS");
        user user_obj = new user(username_input,pass, nameInput,date_input);
        System.out.println("back to  AMS & going to db! wish me luck :)");
        DBHandler db = new DBHandler();
        return db.NewUser(user_obj);
        //return db.validateUser(user_obj);
    }

    public boolean validateUser(String username, String password) {
        user user_obj = new user(username,password);
        DBHandler db = new DBHandler();
        return db.validateUser(user_obj);
        //return false;
    }

    public void projCreate(String nameInput, String deadlineInput, String descInput, ArrayList<members> team)
    {
        Project projObj = new Project(nameInput,deadlineInput,descInput,team);
        DBHandler dbHand = new DBHandler();
        dbHand.projectCreation(projObj);
    }

    public boolean checkMember(String nameInput)
    {
        DBHandler dbHand = new DBHandler();
        return dbHand.checkMember(nameInput);
    }

    public members getMember(String NameInput)
    {
        DBHandler dbHand = new DBHandler();
        members obj = dbHand.getMember(NameInput);
        return obj;
    }

    public Project projectDetails()
    {
        DBHandler dbHand = new DBHandler();
        Project proj = dbHand.projectDetails();
        return proj;
    }




    public ArrayList<Project> showProject()
    {
        DBHandler dbHand = new DBHandler();
        ArrayList<Project> proj_list = dbHand.showProject();
        return proj_list;
    }

    public ArrayList<String> showAnnouncements()
    {
        DBHandler dbHand = new DBHandler();
        ArrayList<String> announcement_arr = dbHand.showAnnouncement();
        return announcement_arr;
    }

    public void createAnnouncement(String InputStr)
    {
        Announcement obj = new Announcement(InputStr);
        DBHandler dbHand = new DBHandler();
        //System.out.println(InputStr);
        obj.setAnnouncement_str(InputStr);
        Helper memory_obj = Helper.getInstance();
        members mem_obj = dbHand.getMember(memory_obj.getCurrentID());
        obj.setAnnouncerName(mem_obj.getMember_name());
        //System.out.println(mem_obj.getName());
        dbHand.createAnnouncement(obj);
    }

    public void TaskCreate(String TaskName,String TaskDeadline,String taskDesc,String member_name,String projName)
    {
        tasks taskObj = new tasks(TaskName,TaskDeadline,taskDesc,member_name,projName);
        DBHandler dbHand = new DBHandler();
        dbHand.taskCreation(taskObj);
    }
/*
    public void todoCreate(){
        DBHandler dbHand = new DBHandler();
        dbHand.todo();

    }

 */




}
