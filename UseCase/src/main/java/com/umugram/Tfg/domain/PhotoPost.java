package com.umugram.Tfg.domain;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class PhotoPost extends Post {

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    public PhotoPost() {
        images = new LinkedList<>();
    }

    public PhotoPost(String caption, List<Image> images) {
        super(caption);
        if(images.size() == 0) {
            throw new IllegalArgumentException("A photo post must have at least one image");
        }
        this.images = images;
    }

    // Getters y Setters
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}