package com.codeup.codeupblog.model;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_cats",
            joinColumns={@JoinColumn(name = "post_id")},
            inverseJoinColumns={@JoinColumn(name = "cat_id")}
    )
    private List<Category> categories;

    public Post() {}

    public Post(long id, String title, String description, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    public Post(String title, String description, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.categories = categories;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
