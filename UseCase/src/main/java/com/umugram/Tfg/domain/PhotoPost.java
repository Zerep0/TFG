package com.umugram.Tfg.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class PhotoPost extends Post {

    @ElementCollection
    @CollectionTable(name = "photo_images")
    private List<String> images;

    public PhotoPost() {
    }

    public PhotoPost(String caption)
    {
        super(caption);
    }

    // Getters y Setters
    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}