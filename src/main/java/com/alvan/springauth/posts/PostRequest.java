package com.alvan.springauth.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String title;

    private String content;

    private String status;

    private String tags;
}
