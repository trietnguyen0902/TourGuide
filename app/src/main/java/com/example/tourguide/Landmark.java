package com.example.tourguide;

import java.util.List;

public class Landmark {
    private String name;
    private String description;
    private List<String> photos; // List of photo URLs or resource IDs

    // Constructor
    public Landmark(String name, String description, List<String> photos) {
        this.name = name;
        this.description = description;
        this.photos = photos;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for photos
    public List<String> getPhotos() {
        return photos;
    }

    // Setter for photos
    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    // You can add other methods as needed
}

