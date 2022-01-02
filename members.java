package com.example.sdaproj;

import java.time.LocalDate;
import java.util.Date;

public class members {
    private String member_name;
    private String dob;

    public members()
    {
        member_name = "dummy";
        dob = "1";
    }


    public members(String member_name, String  dob) {
        this.member_name = member_name;
        this.dob = dob;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_nam) {
        this.member_name = member_nam;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
