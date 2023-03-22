package com.zybooks.wguc196jmancil.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.zybooks.wguc196jmancil.Entity.Note;

import java.util.List;
@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNote(Note note);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM note ORDER BY courseId ASC")
    List<Note> getAllNotes();

    @Query("SELECT * FROM note WHERE courseID=:courseID")
    List<Note> getNotesForCourse(int courseID);
}
