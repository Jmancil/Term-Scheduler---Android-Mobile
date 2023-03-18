package com.zybooks.wguc196jmancil.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zybooks.wguc196jmancil.Entity.Assessment;
import com.zybooks.wguc196jmancil.R;
import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder>{
    class AssessmentViewHolder extends RecyclerView.ViewHolder{
        private final TextView assessmentViewItem;

        private AssessmentViewHolder(View assessmentView){
            super(assessmentView);

            assessmentViewItem = assessmentView.findViewById(R.id.assessmentListItem);

            assessmentView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final Assessment current = mAssessment.get(position);
                    Intent intent = new Intent(context, activitySelectedAssessment.class);
                    intent.putExtra("ID", current.getID());
                    intent.putExtra("start", current.getStart());
                    intent.putExtra("end", current.getEnd());
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("courseID", current.getCourseID());
                    context.startActivity(intent);
                }
            });
        }
    }

    private List<Assessment> mAssessment;
    private final Context context;
    private final LayoutInflater mInflater;

    public AssessmentAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View assessmentView = mInflater.inflate(R.layout.assessment_list_item,parent,false);
        return new AssessmentViewHolder(assessmentView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
        if(mAssessment != null){
            Assessment current = mAssessment.get(position);
            String name = current.getTitle();
            holder.assessmentViewItem.setText(name);
        }
    }

    public void setmAssessment(List<Assessment> assessmentList){
        mAssessment = assessmentList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mAssessment != null){
            return mAssessment.size();
        }
        else return 0;
    }
}
