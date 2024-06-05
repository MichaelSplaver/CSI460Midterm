package com.example.csi460midterm;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class VideogameEditAdapter extends VideogameAdapter{


    private DBHandler dbHandler;
    public VideogameEditAdapter(ArrayList<VideoGameModal> videoGameModalArrayList, Context context) {
        super(videoGameModalArrayList, context);
        dbHandler = new DBHandler(context);
    }

    @Override
    public void onBindViewHolder(@NonNull VideogameAdapter.ViewHolder holder, int position) {
        //overwriting the base VideogameAdapter to make the edit/delete buttons visible
        VideoGameModal modal = videoGameModalArrayList.get(position);
        holder.videogamenametext.setText(modal.getGameName());
        holder.videogamegenretext.setText(modal.getGameGenre());
        holder.videogameratingtext.setText("Rating: " + modal.getGameRating() + "/10");
        holder.videogamedesctext.setText(modal.getGameDescription());
        holder.deletebtn.setVisibility(View.VISIBLE);
        holder.editbtn.setVisibility(View.VISIBLE);

        //adding delete functionality to the delete button
        holder.deletebtn.setOnClickListener(view -> {
            dbHandler.deleteGame(modal.getGameName());
            Toast.makeText(context, "Deleted the game!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, EditDeleteGameActivity.class);
            context.startActivity(i);
        });

        //passing the relevant info in extras to the ModifyGame Activity
        holder.editbtn.setOnClickListener(view -> {
            Intent i = new Intent(context, ModifyGameActivity.class);

            i.putExtra("name", modal.getGameName());
            i.putExtra("genre", modal.getGameGenre());
            i.putExtra("rating", modal.getGameRating());
            i.putExtra("description", modal.getGameDescription());

            context.startActivity(i);
        });
    }
}
