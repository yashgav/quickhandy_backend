package com.project.quickhandy.CustomerPost;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_post_id;

    private int cp_id;
    private String title;
    private String description;
    private int hands;
    private long expected_amount;
    private String username;


    public CustomerPost() {
    }

    public CustomerPost(int cust_post_id, int cp_id, String title, String description, int hands, long expected_amount, String username) {
        this.cust_post_id = cust_post_id;
        this.cp_id = cp_id;
        this.title = title;
        this.description = description;
        this.hands = hands;
        this.expected_amount = expected_amount;
        this.username = username;
    }

    public int getCust_post_id() {
        return cust_post_id;
    }

    public void setCust_post_id(int cust_post_id) {
        this.cust_post_id = cust_post_id;
    }

    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
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

    public int getHands() {
        return hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
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
