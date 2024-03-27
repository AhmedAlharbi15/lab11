package com.example.lab11.Service;

import com.example.lab11.Api.ApiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Model.Post;
import com.example.lab11.Repository.CategoryRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public List<Post> getAllPost()

    {
        return postRepository.findAll();
    }
    public void addPost(Post post)

    {
        postRepository.save(post);
    }
    public void updatePost(Integer id, Post post){
        Post post1 = postRepository.findAllByUser_ID(id);

        if (post1 == null){
            throw new ApiException("wrong id");
        }
        post1.setUserID(post.getUserID());

        postRepository.save(post1);
    }

    public void deletePost(Integer id){
        Post post = postRepository.findAllByUser_ID(id);
        if (post == null){
            throw new ApiException(" wrong id ");
        }
        postRepository.delete(post);
    }
}
