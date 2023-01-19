package com.alvan.springauth.posts;


import com.alvan.springauth.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "posts_entity")

public class Posts {
    @Id
    @GeneratedValue
    private Long postId;

    private String title;

    private String content;

    private String status;

    private String tags;

    @ManyToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER
    )
    @JoinColumn(
        name = "id",
        referencedColumnName = "id"
    )
    private User user;



}
