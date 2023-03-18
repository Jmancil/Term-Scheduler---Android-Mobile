package com.zybooks.wguc196jmancil.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "assessments")
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String Start;
    private String End;
    private String Title;
    private int CourseID;
//    private String Type;

    public Assessment(int ID, String start, String end, String title, int courseID) {
        this.ID = ID;
        Start = start;
        End = end;
        Title = title;
        CourseID = courseID;
    }

    public Assessment() {

    }

    public Assessment(String start, String end, String title, int courseID){
        CourseID = courseID;
        Start = start;
        End = end;
        Title = title;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

//    public String getType(){
//        return Type;
//    }
//
//    public void setType(String type){
//        String Type = type;
//    }



    @Override
    public String toString() {
        return "Assessment{" +
                "ID=" + ID +
                ", Start='" + Start + '\'' +
                ", End='" + End + '\'' +
                ", Title='" + Title + '\'' +
                ", CourseID=" + CourseID +
                '}';
    }

}
