package com.zybooks.wguc196jmancil.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String note;
    private String date;
    private int courseId;

    public Note(int id, String title, String note, String date, int courseId) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.date = date;
        this.courseId = courseId;
    }

    public Note(String noteTitle, String note, String date, int courseId){
        this.title = noteTitle;
        this.note = note;
        this.date = date;
        this.courseId = courseId;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
