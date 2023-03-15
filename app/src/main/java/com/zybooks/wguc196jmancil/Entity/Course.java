package com.zybooks.wguc196jmancil.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int CourseID;
    private String Start;
    private String End;
    private String Status;
    private String CI;
    private String CIPhone;
    private String CIEmail;
    private String Title;
    private int TermID;

    public Course(int courseID, String start, String end, String status, String CI, String CIPhone, String CIEmail, String title, int termID) {
        CourseID = courseID;
        Start = start;
        End = end;
        Status = status;
        this.CI = CI;
        this.CIPhone = CIPhone;
        this.CIEmail = CIEmail;
        Title = title;
        TermID = termID;
    }

    public Course( int termID, String title, String start, String end, String status, String CI, String CIPhone, String CIEmail){
        TermID = termID;
        Title = title;
        Start = start;
        End = end;
        Status = status;
        this.CI = CI;
        this.CIPhone = CIPhone;
        this.CIEmail = CIEmail;
    }

public Course(){

}

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getCIPhone() {
        return CIPhone;
    }

    public void setCIPhone(String CIPhone) {
        this.CIPhone = CIPhone;
    }

    public String getCIEmail() {
        return CIEmail;
    }

    public void setCIEmail(String CIEmail) {
        this.CIEmail = CIEmail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getTermID() {
        return TermID;
    }

    public void setTermID(int termID) {
        TermID = termID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseID=" + CourseID +
                ", Start='" + Start + '\'' +
                ", End='" + End + '\'' +
                ", Status='" + Status + '\'' +
                ", CI='" + CI + '\'' +
                ", CIPhone='" + CIPhone + '\'' +
                ", CIEmail='" + CIEmail + '\'' +
                ", Title='" + Title + '\'' +
                ", TermID=" + TermID +
                '}';
    }
}
