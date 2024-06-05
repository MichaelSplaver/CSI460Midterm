
package com.example.csi460midterm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideogameAdapter extends RecyclerView.Adapter<VideogameAdapter.ViewHolder> {

    public ArrayList<VideoGameModal> videoGameModalArrayList;
    public Context context;

    public VideogameAdapter(ArrayList<VideoGameModal> videoGameModalArrayList, Context context) {
        this.videoGameModalArrayList = videoGameModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videogame_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //setting edit and delete buttons to be invisible on this adapter
        VideoGameModal modal = videoGameModalArrayList.get(position);
        holder.videogamenametext.setText(modal.getGameName());
        holder.videogamegenretext.setText(modal.getGameGenre());
        holder.videogameratingtext.setText("Rating: " + modal.getGameRating() + "/10");
        holder.videogamedesctext.setText(modal.getGameDescription());
        holder.deletebtn.setVisibility(View.INVISIBLE);
        holder.editbtn.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return videoGameModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView videogamenametext, videogamegenretext, videogameratingtext, videogamedesctext;
        public ImageView editbtn, deletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            videogamenametext = itemView.findViewById(R.id.gamenamecard);
            videogamegenretext = itemView.findViewById(R.id.gamegenrecard);
            videogameratingtext = itemView.findViewById(R.id.gameratingcard);
            videogamedesctext = itemView.findViewById(R.id.gamedesccard);
            editbtn = itemView.findViewById(R.id.editimg);
            deletebtn = itemView.findViewById(R.id.closeimg);
        }
    }
}
