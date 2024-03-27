package com.example.lab11.Repository;

import com.example.lab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findCategoryById(Integer id);
    @Query("select cate from Category cate where cate.categoryID=?1")
    Category pleasefindByID(Integer id);


    Category findAllByName(String name);
}
