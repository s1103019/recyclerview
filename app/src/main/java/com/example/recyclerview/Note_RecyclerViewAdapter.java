package com.example.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class Note_RecyclerViewAdapter extends RecyclerView.Adapter<Note_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<NoteModel> noteModels;
    public Note_RecyclerViewAdapter(Context context, ArrayList<NoteModel> noteModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.noteModels = noteModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public Note_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new Note_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }
    @Override
    public void onBindViewHolder(@NonNull Note_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //assign value to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view
        holder.tvTitle.setText(noteModels.get(position).getTitle());
        holder.tvDetail.setText(noteModels.get(position).getDetail());
    }
    @Override
    public int getItemCount() {
        //the recycler view just wants to know the number of items you want displayed
        return noteModels.size(); //return total amount of the data what we have
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the views from our recycler_view_row layout file
        // kinda like the onCreate method
        TextView tvTitle, tvDetail;
        public MyViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.mTitleText);
            tvDetail = itemView.findViewById(R.id.mDetailText);


            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(position);
                        }
                    }
                    return true;
                }
            });
        }

    }
}