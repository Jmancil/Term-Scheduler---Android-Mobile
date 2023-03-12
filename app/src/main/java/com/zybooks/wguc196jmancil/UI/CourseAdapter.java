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

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    class CourseViewHolder extends RecyclerView.ViewHolder{
        private final TextView courseItemView;
        private CourseViewHolder(View courseView){
            super(courseView);
            courseItemView = courseView.findViewById(R.id.courseListItem);

            courseView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final Course current = mCourse.get(position);
                    Intent intent = new Intent(context, activitySelectedCourse.class);
                    intent.putExtra("courseId", current.getCourseID());
                    intent.putExtra("start", current.getStart());
                    intent.putExtra("end", current.getEnd());
                    intent.putExtra("status", current.getStatus());
                    intent.putExtra("ci", current.getCI());
                    intent.putExtra("ciPhone", current.getCIPhone());
                    intent.putExtra("ciEmail", current.getCIEmail());
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("termId", current.getTermID());
                    context.startActivity(intent);

                }
            });
        }
    }
    private List<Course> mCourse;
    private final Context context;
    private final LayoutInflater mInflater;

    public CourseAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

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

    @Override
    public int getItemCount() {
        if(mCourse != null){
            return mCourse.size();
        }
        else return 0;
    }
}
