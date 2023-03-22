package com.zybooks.wguc196jmancil.Database;

import android.app.Application;

import com.zybooks.wguc196jmancil.DAO.AssessmentDAO;
import com.zybooks.wguc196jmancil.DAO.CourseDAO;
import com.zybooks.wguc196jmancil.DAO.NoteDAO;
import com.zybooks.wguc196jmancil.DAO.TermDAO;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private AssessmentDAO mAssessmentDAO;
    private CourseDAO mCourseDAO;
    private TermDAO mTermDAO;
    private NoteDAO mNoteDAO;
    private CourseDAO cCourseDao;
    private List<Assessment> mAllAssessments;
    private List<Course> mAllCourses;
    private List<Term> mAllTerms;
    private List<Note> mAllNotes;
    private List<Course> courseId;
    private List<Course> courses;

    private static int NUMBER_OFTHREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OFTHREADS);

    public Repository(Application application){
        DataBaseBuilder db = DataBaseBuilder.getDatabase(application);
        mTermDAO = db.termDAO();
        mCourseDAO = db.courseDAO();
        mAssessmentDAO = db.assessmentDAO();
        mNoteDAO = db.noteDAO();
    }

    //Creates list of all Terms
    public List<Term> getmAllTerms() {
        databaseExecutor.execute(()->{
            mAllTerms=mTermDAO.getAllTerms();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllTerms;
    }

    //Inserts Term
    public void insertTerm(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.insertTerm(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Updates Term
    public void updateTerm(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.updateTerm(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Deletes Term
    public void termDelete(Term term){
        databaseExecutor.execute(()->{
            mTermDAO.deleteTerm(term);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //Deletes Course
    public void deleteCourse(Course course){
        databaseExecutor.execute(()->{
            mCourseDAO.deleteCourse(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Inserts Course
    public void insertCourse(Course course){
        databaseExecutor.execute(()->{
            mCourseDAO.insertCourse(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Updates Course
    public void updateCourse(Course course){
        databaseExecutor.execute(()->{
            mCourseDAO.updateCourse(course);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Creates list of all courses
    public List<Course> getmAllCourses(){
        databaseExecutor.execute(()->{
            mAllCourses=mCourseDAO.getAllCourses();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }

    //Inserts Assessment
    public void insertAssessment(Assessment assessment){
        databaseExecutor.execute(()->{
            mAssessmentDAO.insertAssessment(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Updates Assessment
    public void updateAssessment(Assessment assessment){
        databaseExecutor.execute(()->{
            mAssessmentDAO.updateAssessment(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Deletes Assessment
    public void deleteAssessment(Assessment assessment){
        databaseExecutor.execute(()->{
            mAssessmentDAO.deleteAssessment(assessment);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    //Creates List of all assessments
    public List<Assessment> getmAllAssessments(){
        databaseExecutor.execute(()->{
            mAllAssessments=mAssessmentDAO.getAllAssessments();
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    public List<Course> getAllCoursesInTerm(int termID){
        databaseExecutor.execute(()->{
            mAllCourses = mCourseDAO.getCoursesForTerm(termID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }

    public List<Assessment> getAssessmentsInTerm(int courseID){
        databaseExecutor.execute(()->{
            mAllAssessments = mAssessmentDAO.getAssessmentForCourse(courseID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllAssessments;
    }

    //Creates list of all notes
    public List<Note> getAllNotes(){
        databaseExecutor.execute(()->{
            mAllNotes = mNoteDAO.getAllNotes();
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllNotes;
    }

    //Inserts note
    public void insertNote(Note note){
        databaseExecutor.execute(()->{
            mNoteDAO.insertNote(note);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Updates note
    public void updateNote(Note note){
        databaseExecutor.execute(()->{
            mNoteDAO.updateNote(note);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //Deletes note
    public void deleteNote(Note note){
        databaseExecutor.execute(()->{
            mNoteDAO.deleteNote(note);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public List<Note> getNotesForCourse(int courseID){
        databaseExecutor.execute(()->{
            mAllNotes = mNoteDAO.getNotesForCourse(courseID);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllNotes;
    }
}
