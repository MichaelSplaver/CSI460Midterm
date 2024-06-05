package com.example.csi460midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyGameActivity extends AppCompatActivity {
    private EditText gameNameEdt, gameGenreEdt, gameRatingEdt, gameDescriptionEdt;
    private Button updateGameBtn, backBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_game);

        gameNameEdt = findViewById(R.id.editgamename);
        gameGenreEdt = findViewById(R.id.editgamegenre);
        gameRatingEdt = findViewById(R.id.editgamerating);
        gameDescriptionEdt = findViewById(R.id.editgamedesc);
        updateGameBtn = findViewById(R.id.modifynewgamebtn);
        backBtn = findViewById(R.id.backbtn4);

        dbHandler = new DBHandler(this);

        gameNameEdt.setText(getIntent().getStringExtra("name"));
        gameGenreEdt.setText(getIntent().getStringExtra("genre"));
        gameRatingEdt.setText(String.valueOf(getIntent().getIntExtra("rating",-1)));
        gameDescriptionEdt.setText(getIntent().getStringExtra("description"));

        updateGameBtn.setOnClickListener(view -> {
            //validating the inputted values
            if (gameRatingEdt.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter a rating between 1-10", Toast.LENGTH_SHORT).show();
                return;
            }
            int gameRating = Integer.parseInt(gameRatingEdt.getText().toString());

            if (gameRating > 10 || gameRating < 0) {
                Toast.makeText(this, "Please enter a rating between 0-10", Toast.LENGTH_SHORT).show();
                return;
            }
            if (gameNameEdt.getText().toString().isEmpty() || gameGenreEdt.getText().toString().isEmpty() || gameDescriptionEdt.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }
            //updating the database with the new values for the game
            dbHandler.updateGame(gameNameEdt.getText().toString(), gameGenreEdt.getText().toString(), gameRating, gameDescriptionEdt.getText().toString());
            //notifying the user of success
            Toast.makeText(this, "Game Updated..", Toast.LENGTH_SHORT).show();
            //change to the modifying/deleting games activity
            Intent i = new Intent(this, EditDeleteGameActivity.class);
            startActivity(i);
        });

        backBtn.setOnClickListener(view -> {
            //back button moves us to the previous activity
            Intent i = new Intent(this, EditDeleteGameActivity.class);
            startActivity(i);
        });
    }
}