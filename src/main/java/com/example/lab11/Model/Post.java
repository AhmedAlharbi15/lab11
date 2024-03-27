package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer categoryID;
    @NotEmpty(message = "Title should be not Empty")
    @Column(columnDefinition = "varchar(5) not null")
    private String title;
    @NotEmpty(message = "Content should be not Empty ")
    @Column(columnDefinition = "varchar(15) not null")
    private String content;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer userID;
    private Date publishdate;
}