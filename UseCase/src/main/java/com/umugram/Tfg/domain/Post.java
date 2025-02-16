package com.umugram.Tfg.domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Post.findAllShortsComments", query = "SELECT p FROM Post p WHERE LENGTH(p.caption) <= 20")
@NamedQuery(name = "Post.findAllLessUsers", query = "SELECT p FROM Post p WHERE p.id < 50")
public abstract class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caption;

    @ManyToOne
    private User user;

    @Lob
    private String description;

    public Post() {
    }

    public Post(String caption)
    {
        this.caption = caption;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }
}
