package com.zybooks.wguc196jmancil.UI;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zybooks.wguc196jmancil.Entity.Course;
import com.zybooks.wguc196jmancil.R;
import java.util.List;

//Constructor and variable for recyclerview class to display data
public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    class CourseViewHolder extends RecyclerView.ViewHolder{
        //Textview courseItemView creation
        private final TextView courseItemView;
        //Housing the view for courses
        private CourseViewHolder(View courseView){
            super(courseView);
            /* Initializing created Textview using
            courseListItem as GUI for course_list_item
             */
            courseItemView = courseView.findViewById(R.id.courseListItem);
            /*
            ClickListner for item that is clicked
            once item is clicked a new intent is created and data from
            clicked item is attached
             */
            courseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    //parses mCourse for position of item to send to adapter
                    final Course current = mCourse.get(position);
                    //Creating intent for screen navigation
                    Intent intent = new Intent(context, activitySelectedCourse.class);
                    intent.putExtra("courseId", current.getCourseID());
                    intent.putExtra("start", current.getStart());
                    intent.putExtra("end", current.getEnd());
                    intent.putExtra("status", current.getStatus());
                    intent.putExtra("name", current.getCI());
                    intent.putExtra("phone", current.getCIPhone());
                    intent.putExtra("email", current.getCIEmail());
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("termId", current.getTermID());
                    context.startActivity(intent);
                }
            });
        }
    }
    //Variables for Course array and inflater for view
    private List<Course> mCourse;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    //Creating view holder and using previous mInflater
    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseView = mInflater.inflate(R.layout.course_list_item,parent,false);
        return new CourseViewHolder(courseView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourse != null){
            Course current = mCourse.get(position);
            String name = current.getTitle();
            holder.courseItemView.setText(name);
        }
    }

    public void setCourse(List<Course> courseList){
        mCourse = courseList;
        notifyDataSetChanged();
    }

    //Returns # of terms if its not 0
    @Override
    public int getItemCount() {
        if(mCourse != null){
            return mCourse.size();
        }
        else return 0;
    }
}
