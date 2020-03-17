package com.sandeepkamathkr.webservice.mapper;

import com.sandeepkamathkr.webservice.dto.PostDTO;
import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.model.Post;
import com.sandeepkamathkr.webservice.model.User;

import java.util.function.Function;

public class PostMapper implements Function<Post, PostDTO> {
    @Override
    public PostDTO apply(Post post) {

        return PostDTO.builder()
                .Id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }
}