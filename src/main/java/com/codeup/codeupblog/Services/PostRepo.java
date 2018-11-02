package com.codeup.codeupblog.Services;

import com.codeup.codeupblog.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    @Query("From Post where id=?1")
    Post findOne(Long id);

    List<Post> findAllByTitleContainsOrDescriptionContains(String str1, String str2);

    @Query("from Post where title like %?1% or description like %?2%")
    List<Post> searchByTitleOrDesc(String term);
}
