package com.codeup.codeupblog.Services;

import com.codeup.codeupblog.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

}
