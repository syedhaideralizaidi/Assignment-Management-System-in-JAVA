package com.example.sdaproj;

import java.time.LocalDate;
import java.util.Date;

public class user {
    private String username;
    private  String password;
    private members m_obj;
    private String member_name;
    private String  dd;

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public user(String username, String password,String mn, String dob) {

       // System.out.println("inside USER");
        this.username = username;
        this.password = password;
        //System.out.println("2 inside USER");
        //m_obj.setMember_name(mn);
        //m_obj.setDob(dob);
        this.member_name = mn;
        this.dd = dob;
       // System.out.println("outside user");
    }



    public String getMemberName(){ return member_name; }

    public String getdob(){ return  dd;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
