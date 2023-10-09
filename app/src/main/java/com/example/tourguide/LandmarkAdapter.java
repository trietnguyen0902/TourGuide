package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.ViewHolder> {

    private List<Landmark> landmarks;
    private OnItemLongClickListener longClickListener;

    public interface OnItemLongClickListener {
        void onItemLongClick(int position);
    }

    public LandmarkAdapter(List<Landmark> landmarks, OnItemLongClickListener longClickListener) {
        this.landmarks = landmarks;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout for each item
        View landmarkView = inflater.inflate(R.layout.item_landmark, parent, false);

        // Return a new ViewHolder instance
        return new ViewHolder(landmarkView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Landmark landmark = landmarks.get(position);

        // Set the name of the landmark
        holder.nameTextView.setText(landmark.getName());

        // Handle long-click on the item
        holder.itemView.setOnLongClickListener(view -> {
            longClickListener.onItemLongClick(position);
            return true;
        });
    }


    @Override
    public int getItemCount() {
        return landmarks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            // Find views within the custom layout
            nameTextView = itemView.findViewById(R.id.textViewName); // Assuming you have a TextView with the ID "textViewName"
        }
    }
}
