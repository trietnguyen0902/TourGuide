package com.example.tourguide;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnViewFavorites;

    private List<Landmark> landmarks = new ArrayList<>();
    private List<Landmark> favoritesList = new ArrayList<>();
    private LandmarkAdapter adapter;
    private AdapterView.OnItemLongClickListener longClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView and button
        recyclerView = findViewById(R.id.recycler_view_landmarks);
        btnViewFavorites = findViewById(R.id.btnViewFavorites);

        // Initialize RecyclerView adapter
        adapter = new LandmarkAdapter(landmarks, new LandmarkAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                // Handle long-click on a landmark item
                Landmark selectedLandmark = landmarks.get(position);
                addToFavorites(selectedLandmark);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate the list of landmarks (you need to implement this)
        // landmarks = populateLandmarks();

        // Set an onClickListener for the "View Favorites" button
        btnViewFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the button click to navigate to the favorites list activity/fragment
                // You can start a new activity or fragment here
                // Example: startActivity(new Intent(MainActivity.this, FavoritesActivity.class));
            }
        });
    }


    // Method to add a landmark to the favorites list
    private void addToFavorites(Landmark landmark) {
        favoritesList.add(landmark);
        adapter.notifyDataSetChanged(); // Update the RecyclerView
        Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
    }

    // Implement the method to populate landmarks (e.g., fetch data from a source)
    // private List<Landmark> populateLandmarks() {
    //     // Implement logic to fetch or create landmarks
    // }

    // You can add other methods and logic as needed for your app

}