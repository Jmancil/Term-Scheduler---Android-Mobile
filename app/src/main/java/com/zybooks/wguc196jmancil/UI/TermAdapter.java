package com.zybooks.wguc196jmancil.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zybooks.wguc196jmancil.Entity.Term;
import com.zybooks.wguc196jmancil.R;
import java.util.List;


//Constructor and variables for recyclerview class to display database data
public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>{
    class TermViewHolder extends RecyclerView.ViewHolder{
        //Textview termItemView created
        private final TextView termItemView;
        //Function used for housing the view of Terms
        private TermViewHolder(View termView){
            super(termView);
            /* Initializing created TextView using
               textView9 as GUI template from term_list_item.xml
             */
            termItemView = termView.findViewById(R.id.termListItem);
            /*Clicklistener for item that is clicked
              once item is clicked a new intent is created and the data from
              the clicked item is attached.
             */
            termView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  int position = getAdapterPosition();
                  //Parses mTerm for position of item we are sending to adapter
                  final Term current = mTerms.get(position);
                  //Creating intent context = this info, .class pushes that screen next
                  Intent intent = new Intent(context, activitySelectedTerm.class);
                  intent.putExtra("id", current.getTermID());
                  intent.putExtra("start", current.getStart());
                  intent.putExtra("end", current.getEnd());
                  intent.putExtra("name", current.getName());
                  context.startActivity(intent);
                }
            });
        }
    }

    //Variables for Term array and inflater
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;

//Term adapter used for infalting view
    public TermAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View termView = mInflater.inflate(R.layout.term_list_item,parent,false);
        return new TermViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms != null){
            Term current = mTerms.get(position);
            String name = current.getName();
            holder.termItemView.setText(name);
        }
        else{
            holder.termItemView.setText("No term name");
        }
    }

    public void setTerms(List<Term> terms){
        mTerms = terms;
        notifyDataSetChanged();
    }

    //Returns # of terms if its not 0
    @Override
    public int getItemCount() {
        if (mTerms != null) {
            return mTerms.size();
            }
            else return 0;
    }
}
