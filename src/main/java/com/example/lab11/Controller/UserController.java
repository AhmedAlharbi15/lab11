package com.example.lab11.Controller;

import com.example.lab11.Api.Api;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser() {
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new Api("User added"));
    }
    @PutMapping("/update/{email}")
    public ResponseEntity updateUser(@PathVariable String email, @RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(email, user);
        return ResponseEntity.status(200).body(new Api("Post updated"));
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteUser(@PathVariable String  email){
        userService.deleteUser(email);
        return ResponseEntity.status(200).body("Post deleted");
    }
}
