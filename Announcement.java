package com.example.sdaproj;

public class Announcement {
    private int aID;
    //private int announcerID;
    private String announcement_str;
    private String announcer_name;
    public  String member_name;

    Announcement()
    {
        aID = 1;
        //announcerID = 90;
        announcement_str = "dummy announcement.";
        announcer_name = "dummy announcer.";
    }
      public Announcement(String inputStr)
    {
      //  aID = inputID;
        //announcerID = inputAnnouncer;
        announcement_str = inputStr;
       // member_name = mn;
    }

    public int getaID()
    {
        return aID;
    }

    public String getAnnouncerName(){
        return announcer_name;
    }
    public String getAnnouncement_str(){
        return announcement_str;
    }

    public void setA_Id(int inputID){aID = inputID;}

    public void setAnnouncement_str(String inputStr){ announcement_str = inputStr;}
    public void setAnnouncerName(String inputStr){ announcer_name = inputStr;}

    public void display()
    {
        System.out.println("->A-ID: "+getaID());
        System.out.println("->Announcer: "+ getAnnouncerName());
        System.out.println("->Announcement Str: "+getAnnouncement_str());
    }

}

