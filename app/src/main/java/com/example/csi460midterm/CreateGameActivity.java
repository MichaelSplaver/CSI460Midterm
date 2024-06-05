package com.example.csi460midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateGameActivity extends AppCompatActivity {

    private EditText inputGameName, inputGameGenre, inputGameRating, inputGameDesc;
    private DBHandler dbHandler;
    private Button createNewGameBtn, backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);


        inputGameName = findViewById(R.id.inputgamename);
        inputGameGenre = findViewById(R.id.inputgamegenre);
        inputGameRating = findViewById(R.id.inputgamerating);
        inputGameDesc = findViewById(R.id.inputgamedesc);

        createNewGameBtn = findViewById(R.id.addnewgamebtn);
        backBtn = findViewById(R.id.backbtn2);
        
        dbHandler = new DBHandler(this);
        
        createNewGameBtn.setOnClickListener(view -> {

            //getting the inputted values and validating them to be acceptable before continuing
            String gameName = inputGameName.getText().toString();
            String gameGenre = inputGameGenre.getText().toString();
            String gameRatingText = (inputGameRating.getText().toString());
            if (gameRatingText.isEmpty()) {
                Toast.makeText(this, "Please enter a rating between 1-10", Toast.LENGTH_SHORT).show();
                return;
            }
            int gameRating = Integer.parseInt(gameRatingText);
            String gameDesc = inputGameDesc.getText().toString();

            if (gameRating > 10 || gameRating < 0) {
                Toast.makeText(this, "Please enter a rating between 0-10", Toast.LENGTH_SHORT).show();
                return;
            }
            if (gameName.isEmpty() || gameGenre.isEmpty() || gameDesc.isEmpty()) {
                Toast.makeText(this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }

            //making call to the database to create a new game
            dbHandler.addNewGame(gameName, gameGenre, gameRating, gameDesc);
            //display a message to the user
            Toast.makeText(this, "The game has been added!", Toast.LENGTH_SHORT).show();
            //show the database activity with the new game to the user
            Intent intent = new Intent(this, ViewDatabase.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(view -> {
            //back button simply returns user to the main activity
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });
    }
}