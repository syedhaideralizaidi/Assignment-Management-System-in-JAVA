package com.example.sdaproj;

import java.util.ArrayList;

public class Project {
    private String Proj_Name;
    private String Proj_Deadline;
    private String Proj_Desc;

    private ArrayList<members> Proj_Team = new ArrayList<>();

    public Project()
    {
        Proj_Name = "dummy";
        Proj_Deadline = "1";
        Proj_Desc = "no description";
    }
    public Project(String nameInput,String deadlineInput, String descInput,ArrayList<members> teamInput)
    {
        Proj_Name = nameInput;
        Proj_Deadline = deadlineInput;
        Proj_Desc = descInput;
        Proj_Team = teamInput;
    }
    public String getProjName()
    {
        return Proj_Name;
    }
    public String getProjDeadline()
    {
        return Proj_Deadline;
    }
    public String getProjDesc()
    {
        return Proj_Desc;
    }
    public ArrayList<members> getProj_Team(){return Proj_Team;}
    public void setProjName(String nameInput)
    {
        Proj_Name = nameInput;
    }
    public void setProjDeadline(String deadlineInput)
    {
        Proj_Deadline = deadlineInput;
    }
    public void setProjDesc(String descInput)
    {
        Proj_Desc = descInput;
    }
    public void setProjTeam(ArrayList<members> teamInput){Proj_Team = teamInput;}
    public void display()
    {
        System.out.println("-> Name: "+getProjName());
        System.out.println("->Deadline: "+getProjDeadline());
        System.out.println("->Desc: "+getProjDesc());
    }
}
