package com.zybooks.wguc196jmancil.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;
import com.zybooks.wguc196jmancil.Entity.Course;
import java.util.List;

@Dao
public interface CourseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(Course course);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("SELECT * FROM course ORDER BY CourseID ASC")
    @RewriteQueriesToDropUnusedColumns
    List<Course> getAllCourses();
}
