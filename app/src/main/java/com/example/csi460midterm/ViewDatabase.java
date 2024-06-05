package com.example.csi460midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewDatabase extends AppCompatActivity {

    private ArrayList<VideoGameModal> videoGameModalArrayList;
    private DBHandler dbHandler;
    private VideogameAdapter videogameAdapter;
    private RecyclerView videogameRV;

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);

        dbHandler = new DBHandler(ViewDatabase.this);
        backBtn = findViewById(R.id.backbtn1);
        videoGameModalArrayList = dbHandler.readGames();

        videogameAdapter = new VideogameAdapter(videoGameModalArrayList, ViewDatabase.this);
        videogameRV = findViewById(R.id.dbrv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewDatabase.this, RecyclerView.VERTICAL, false);
        videogameRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        videogameRV.setAdapter(videogameAdapter);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}