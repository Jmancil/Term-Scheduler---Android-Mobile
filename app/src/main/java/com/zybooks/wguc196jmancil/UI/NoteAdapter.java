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
import com.zybooks.wguc196jmancil.Entity.Note;
import com.zybooks.wguc196jmancil.R;
import java.util.List;

//Constructor and variable for Recyclerview to display data
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{
    class NoteViewHolder extends RecyclerView.ViewHolder{
        //TextVView creation
        private final TextView noteItemView;
        //housing the view for notes
        private NoteViewHolder(View noteView){
            super(noteView);
        //Initializing as GUI for note list item
            noteItemView = noteView.findViewById(R.id.noteListItem);
        /*
        Click listener for item that is clicked
        once item is clicked new intent is created and data from clicked item is attached
         */
            noteView.setOnClickListener(new View.OnClickListener(){
                @Override
                        public void onClick(View v){
                    int position = getAdapterPosition();
                    final Note current = mNote.get(position);

                    Intent intent = new Intent(context, activitySelectedNote.class);
                    intent.putExtra("id", current.getId());
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("note", current.getNote());
                    intent.putExtra("date", current.getDate());
                    intent.putExtra("courseId", current.getCourseId());
                    context.startActivity(intent);
                }
            });
        }
    }
    //Variables for course array and inflater for view
private List<Note> mNote;
private final Context context;
private final LayoutInflater mInflater;

        public NoteAdapter(Context context){
            mInflater = LayoutInflater.from(context);
            this.context = context;
            }
    //Creating view holder and using previous mInFlater
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View noteView = mInflater.inflate(R.layout.notes_list_item,parent,false);
        return new NoteViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if(mNote != null){
            Note current = mNote.get(position);
            String name = current.getTitle();
            holder.noteItemView.setText(name);
        }
    }

    public void setNote(List<Note> noteList){
            mNote = noteList;
            notifyDataSetChanged();
    }

    //Returns number of notes if its not 0
    @Override
    public int getItemCount() {
        if(mNote != null){
            return mNote.size();
        }
        else return 0;
    }
}
