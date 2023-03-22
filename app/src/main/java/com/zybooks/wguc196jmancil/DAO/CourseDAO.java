package com.zybooks.wguc196jmancil.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Term;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(Course course);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateCourse(Course course);

    @Delete
    Void deleteCourse(Course course);

    @Query("SELECT * FROM course ORDER BY CourseID ASC")
    @RewriteQueriesToDropUnusedColumns
    List<Course> getAllCourses();

//    @Query("SELECT * FROM course WHERE termID = :termId")
//    List<Course> getCoursesForTerm(int termId);

    @Query("SELECT * FROM course WHERE termID=:termID")
    @RewriteQueriesToDropUnusedColumns
    List<Course> getCoursesForTerm(int termID);
}
