package com.example.sqlitetry2;

public class Internship {
    private int itn_id;
    private String itn_title;
    private Boolean itn_fullTime;
    private int int_wage;

    public Internship(int itn_id, String itn_title, Boolean itn_fullTime, int int_wage)
    {
        this.itn_id = itn_id;
        this.itn_title = itn_title;
        this.itn_fullTime = itn_fullTime;
        this.int_wage = int_wage;
    }
    //set get ID
    public void setID(int itn_id)
    {
        this.itn_id = itn_id;
    }
    public int getID()
    {
        return this.itn_id;
    }
    //set get title
    public void setItn_title(String Itn_title)
    {
        this.itn_title = itn_title;
    }
    public String getItn_title()
    {
        return this.itn_title;
    }
    //set get full time
    public void setItn_fullTime(Boolean Itn_fullTime)
    {
        this.itn_fullTime = itn_fullTime;
    }
    public Boolean getItn_fullTime(){
        return this.itn_fullTime;
    }
    //set get wage

    public void setInt_wage(int Int_wage)
    {
        this.int_wage = int_wage;
    }
    public int getInt_wage(){
        return this.int_wage;
    }

}
