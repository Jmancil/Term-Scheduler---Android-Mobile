package com.zybooks.wguc196jmancil.Database;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.zybooks.wguc196jmancil.DAO.AssessmentDAO;
import com.zybooks.wguc196jmancil.DAO.CourseDAO;
import com.zybooks.wguc196jmancil.DAO.NoteDAO;
import com.zybooks.wguc196jmancil.DAO.TermDAO;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.Entity.Term;

@Database(entities={Assessment.class, Course.class, Term.class, Note.class}, version = 3, exportSchema = false)
public abstract class DataBaseBuilder extends RoomDatabase {
    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract NoteDAO noteDAO();

    private static volatile DataBaseBuilder INSTANCE;

    static DataBaseBuilder getDatabase(final Context context){
        if (INSTANCE == null) {
        synchronized (DataBaseBuilder.class) {
        if(INSTANCE==null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBaseBuilder.class, "mobileAppDatabase.db")
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
