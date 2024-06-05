
package com.example.csi460midterm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideogameAdapter extends RecyclerView.Adapter<VideogameAdapter.ViewHolder> {

    private ArrayList<VideoGameModal> videoGameModalArrayList;
    private Context context;

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
        VideoGameModal modal = videoGameModalArrayList.get(position);
        holder.videogamenametext.setText(modal.getGameName());
        holder.videogamegenretext.setText(modal.getGameGenre());
        holder.videogameratingtext.setText(modal.getGameRating());
        holder.videogamedesctext.setText(modal.getGameDescription());

//        holder.itemView.setOnClickListener(v -> {
//
//            Intent i = new Intent(context, UpdateCourseActivity.class);
//
//            i.putExtra("name", modal.getCourseName());
//            i.putExtra("description", modal.getCourseDescription());
//            i.putExtra("duration", modal.getCourseDuration());
//            i.putExtra("tracks", modal.getCourseTracks());
//
//            // starting our activity.
//            context.startActivity(i);
//        });
    }

    @Override
    public int getItemCount() {
        return videoGameModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView videogamenametext, videogamegenretext, videogameratingtext, videogamedesctext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            videogamenametext = itemView.findViewById(R.id.gamenamecard);
            videogamegenretext = itemView.findViewById(R.id.gamegenrecard);
            videogameratingtext = itemView.findViewById(R.id.gameratingcard);
            videogamedesctext = itemView.findViewById(R.id.gamedesccard);
        }
    }
}
