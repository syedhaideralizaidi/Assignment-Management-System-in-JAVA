package com.example.sdaproj;

public class Helper {

    private static Helper h_Instance = null;
    private int currentID;
    private Project proj;
    private members mem_obj;
    private Helper()
    {
        currentID = 0;
        proj = new Project();
        mem_obj = new members();
    }
    public static Helper getInstance()
    {
        if (h_Instance == null)
        {
            h_Instance = new Helper();
        }

        return h_Instance;
    }
    public int getCurrentID() { return currentID;}
    public void setCurrentID(int InputID) { this.currentID = InputID;}

    public Project getProj() { return proj; }
    public void setProj(Project proj) { this.proj = proj; }

    public members getMem_obj() {
        return mem_obj;
    }

    public void setMem_obj(members mem_obj) {
        this.mem_obj = mem_obj;
    }
}



