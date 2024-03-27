package com.example.lab11.Service;

import com.example.lab11.Api.ApiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Repository.CommentRepository;
import com.example.lab11.Repository.PostRepository;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    public List<Comment> getAllComment()
    {
        return commentRepository.findAll();
    }
    public void addComment(Comment comment)

    {

        commentRepository.save(comment);
    }
    public void updateComment(Integer id, Comment comment){
        Comment comment1 = commentRepository.findCommentByById(id);

        if (comment1 == null){
            throw new ApiException("wrong id");
        }
        comment1.setUserID(comment.getUserID());

        commentRepository.save(comment1);
    }

    public void deleteComment(Integer id){
        Comment comment = commentRepository.findCommentByById(id);
        if (comment == null){
            throw new ApiException(" wrong id ");
        }
        commentRepository.delete(comment);
    }
}