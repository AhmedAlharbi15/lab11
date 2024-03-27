package com.example.lab11.Repository;

import com.example.lab11.Model.Category;
import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findAllByName(String name);

    User findAllByEmail(String email);
    User findAllByPassword(Integer password);
}
