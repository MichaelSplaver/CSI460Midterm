package com.example.csi460midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class EditDeleteGameActivity extends AppCompatActivity {

    private ArrayList<VideoGameModal> videoGameModalArrayList;
    private DBHandler dbHandler;
    private VideogameEditAdapter videogameEditAdapter;
    private RecyclerView videogameEditDeleteRV;

    private Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_game);

        dbHandler = new DBHandler(this);
        backBtn = findViewById(R.id.backbtn3);
        videoGameModalArrayList = dbHandler.readGames();

        videogameEditAdapter = new VideogameEditAdapter(videoGameModalArrayList, this);
        videogameEditDeleteRV = findViewById(R.id.dbeditdeleterv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        videogameEditDeleteRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to modified recycler view with the edit/delete icons.
        videogameEditDeleteRV.setAdapter(videogameEditAdapter);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}