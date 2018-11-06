package com.codeup.codeupblog.Services;

import com.codeup.codeupblog.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepo postRepo;
    private List<Post> posts;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
        posts = new ArrayList<>();
    }

    public Iterable<Post> all() {
        return posts;
    }

    public Post create(Post post) {
       return postRepo.save(post);
    }

    public void save(Post post) {
        posts.add(post);
    }

    public Post update(Post post) {
        return postRepo.save(post);
    }

    public Post findOne(long id) {
        return postRepo.findOne(id);
//        return posts.get(id);
    }

    public List<Post> search(String term, String term2) {
        return postRepo.findAllByTitleContainsOrDescriptionContains(term, term2);
    }

}
