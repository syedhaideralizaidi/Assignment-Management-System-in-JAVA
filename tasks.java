package com.example.sdaproj;

import javafx.concurrent.Task;

import java.util.ArrayList;

public class tasks {
    private String Proj_Name;
    private String Task_Name;
   // Project projObj = new Project();


    //private
    //ArrayList<String> members;

    private String Task_Deadline;
    private String Task_Desc;
    private String member_name;

    public void display()
    {
        System.out.println("-> Task Name: "+getTask_Name());
        System.out.println("-> proj Name: "+getProj_Name());
        System.out.println("->Deadline: "+getTask_Deadline());
        System.out.println("->Desc: "+getTask_Desc());
        System.out.println("-> member Name: "+getMember_name());
    }


    public tasks(String TaskName,String TaskDeadline,String taskDesc,String member_name,String projName) {
        Task_Name = TaskName;
        Task_Deadline = TaskDeadline;
        Task_Desc = taskDesc;
        this.member_name = member_name;
        Proj_Name = projName;
    }


    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }


    public void setProj_Name(String proj_Name) {
        Proj_Name = proj_Name;
    }

    public String getProj_Name() {
        return Proj_Name;
    }

    public String getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String task_Name) {
        Task_Name = task_Name;
    }

    public String getTask_Deadline() {
        return Task_Deadline;
    }

    public void setTask_Deadline(String task_Deadline) {
        Task_Deadline = task_Deadline;
    }

    public String getTask_Desc() {
        return Task_Desc;
    }

    public void setTask_Desc(String task_Desc) {
        Task_Desc = task_Desc;
    }
}
