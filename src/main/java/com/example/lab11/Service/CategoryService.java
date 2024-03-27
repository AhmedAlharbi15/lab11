package com.example.lab11.Service;

import com.example.lab11.Api.ApiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> getAllCategory()
    {

        return categoryRepository.findAll();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void updateCategory(Integer id, Category category){
        Category category1 = categoryRepository.findCategoryById(id);

        if (category1 == null){
            throw new ApiException("wrong id");
        }
        category1.setName(category.getName());

        categoryRepository.save(category1);
    }

    public void deleteCategory(Integer id){
        Category category = categoryRepository.findCategoryById(id);
        if (category == null){
            throw new ApiException(" wrong id ");
        }
        categoryRepository.delete(category);
    }
}