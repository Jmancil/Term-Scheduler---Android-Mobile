package com.zybooks.wguc196jmancil.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.RoomWarnings;
import androidx.room.Update;

import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Term;
import java.util.List;

@Dao
public interface TermDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTerm(Term term);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    Void updateTerm(Term term);

    @Delete
    Void deleteTerm(Term term);

    @Query("SELECT * FROM term ORDER BY termId ASC")
    @RewriteQueriesToDropUnusedColumns
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    List<Term> getAllTerms();

}
