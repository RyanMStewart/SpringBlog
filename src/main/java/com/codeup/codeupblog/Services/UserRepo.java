package com.codeup.codeupblog.Services;

import com.codeup.codeupblog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
