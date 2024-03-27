package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    @NotEmpty(message = "UserName should be not Empty")
    @Column(columnDefinition = "varchar(15) not null ")
    private String username;
    @NotNull(message = "PassWord should be not null")
    private Integer password;
    @Email
    @NotEmpty(message = "Email should be not Empty")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String email;
    private Date registration_date;
}
