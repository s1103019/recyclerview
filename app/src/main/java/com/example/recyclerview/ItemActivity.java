package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        String detail = bundle.getString("DETAIL");
        Button btn1 = findViewById(R.id.butto);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TITLE", noteModels.get(position).getTitle());
                bundle.putString("DETAIL", noteModels.get(position).getDetail());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}