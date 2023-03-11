package com.zybooks.wguc196jmancil.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "term")
public class Term {
    @PrimaryKey(autoGenerate = true)
    private int TermID;
    private String Start;
    private String End;
    private String Name;

    public Term(int termID, String start, String end, String name) {
        TermID = termID;
        Start = start;
        End = end;
        Name = name;
    }

    public Term(String start, String end, String name) {
        Start = start;
        End = end;
        Name = name;
    }

    public Term(){

    }

    public int getTermID() {
        return TermID;
    }

    public void setTermID(int termID) {
        TermID = termID;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Term{" +
                "TermID=" + TermID +
                ", Start='" + Start + '\'' +
                ", End='" + End + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
