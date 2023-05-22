package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<NoteModel> noteModels = new ArrayList<>();
    Note_RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpNoteModels();//設定假資料

        adapter = new Note_RecyclerViewAdapter(this, noteModels,  this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setUpNoteModels() {
        String[] title = getResources().getStringArray(R.array.note_title_text);
        String[] detail = getResources().getStringArray(R.array.note_detail_text);
        for (int i = 0; i < title.length; i++ ) {
            noteModels.add(new NoteModel(title[i], detail[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        if(position == 0){
            Intent intent = new Intent(MainActivity.this, CarActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this, ItemActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("TITLE", noteModels.get(position).getTitle());
            bundle.putString("DETAIL", noteModels.get(position).getDetail());
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    @Override
    public void onItemLongClick(int position) {
        noteModels.remove(position);
        adapter.notifyItemRemoved(position);
    }
}