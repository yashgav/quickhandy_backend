package com.project.quickhandy.WorkerPost;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkerPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int work_post_id;

    private int wp_id;
    private String title;
    private String description;
    private float rating;
    private int likes;
    private long expected_amount;
    private String username;

    public WorkerPost() {
    }

    public WorkerPost(int work_post_id, int wp_id, String title, String description, float rating, int likes, long expected_amount, String username) {
        this.work_post_id = work_post_id;
        this.wp_id = wp_id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.likes = likes;
        this.expected_amount = expected_amount;
        this.username = username;
    }

    public int getWork_post_id() {
        return work_post_id;
    }

    public void setWork_post_id(int work_post_id) {
        this.work_post_id = work_post_id;
    }

    public int getWp_id() {
        return wp_id;
    }

    public void setWp_id(int wp_id) {
        this.wp_id = wp_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getExpected_amount() {
        return expected_amount;
    }

    public void setExpected_amount(long expected_amount) {
        this.expected_amount = expected_amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
