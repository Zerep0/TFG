package com.umugram.Tfg.domain;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")  // Columna de clave foránea en la tabla Image
    private Post post;

    public Image() {
    }

    public Image(String url) {
        this.url = url;
    }

    // Getters y Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}