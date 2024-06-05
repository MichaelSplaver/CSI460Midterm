package com.example.csi460midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button modifyDeleteGameBtn, addNewGameBtn, viewDatabaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modifyDeleteGameBtn = findViewById(R.id.modifydeletegamebtn);
        addNewGameBtn = findViewById(R.id.addgamebtn);
        viewDatabaseBtn = findViewById(R.id.viewdbbtn);

        viewDatabaseBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ViewDatabase.class);
            startActivity(intent);
        });

        addNewGameBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, CreateGameActivity.class);
            startActivity(intent);
        });

        modifyDeleteGameBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditDeleteGameActivity.class);
            startActivity(intent);
        });
    }
}