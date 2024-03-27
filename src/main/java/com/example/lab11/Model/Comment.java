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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentID;
    @NotNull(message = "user id should be not ")
    @Column(columnDefinition = "int not null")
    private Integer userID;
    @NotNull(message = "post id should be not ")
    @Column(columnDefinition = "int not null")
    private Integer postID;
    @NotEmpty(message = "Content should be not Empty ")
    @Column(columnDefinition = "varchar(15) not null")
    private String content;
    private Date commentdate;
}