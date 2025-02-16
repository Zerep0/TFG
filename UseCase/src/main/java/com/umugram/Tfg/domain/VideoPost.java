package com.umugram.Tfg.domain;

import jakarta.persistence.Entity;

@Entity
public class VideoPost extends Post {

    private String videoUrl;
    private int duration;

    // Getters y Setters

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
