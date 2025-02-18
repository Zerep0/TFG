package com.umugram.Tfg.example;

import com.umugram.Tfg.domain.PhotoPost;
import com.umugram.Tfg.domain.Post;
import com.umugram.Tfg.domain.VideoPost;
import com.umugram.Tfg.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.umugram.Tfg.domain.Image;

import java.util.List;

@Component
public class Main implements CommandLineRunner
{

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) {
        postRepository.deleteAll();

        PhotoPost photoPost = new PhotoPost();
        List<Image> images = List.of(new Image("https://www.google.com"));
        photoPost.setImages(images);
        photoPost.setCaption("This is a photo post");
        postRepository.save(photoPost);

        VideoPost videoPost = new VideoPost();
        videoPost.setVideoUrl("https://www.google.com");
        videoPost.setDuration(60);
        videoPost.setCaption("This is a video post");
        postRepository.save(videoPost);

        List<Post> posts = postRepository.findAll();

        /*postRepository.findAllLessUsers().forEach(System.out::println);
        postRepository.findAllShortsComments().forEach(System.out::println);
        postRepository.findAllLessUsers2(50L).forEach(System.out::println);
        postRepository.deleteByCaption("This is a photo post");*/


        System.out.println("Posts:");
        for (Post post : posts) {
            System.out.println(post);
        }
    }
}