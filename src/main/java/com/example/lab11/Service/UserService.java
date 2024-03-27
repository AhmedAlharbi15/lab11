package com.example.lab11.Service;

import com.example.lab11.Api.ApiException;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUser()

    {
        return userRepository.findAll();
    }
    public void addUser(User user)

    {
        userRepository.save(user);
    }
    public void updateUser(String email, User user){
        User user1 = userRepository.findAllByEmail(email);

        if (user1 == null){
            throw new ApiException("wrong id");
        }
        user1.setUserID(user.getUserID());

        userRepository.save(user1);
    }
    public void deleteUser(String email){
        User user = userRepository.findAllByEmail(email);
        if (user == null){
            throw new ApiException(" wrong id ");
        }
        userRepository.delete(user);
    }

}
