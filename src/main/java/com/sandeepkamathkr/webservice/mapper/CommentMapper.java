package com.sandeepkamathkr.webservice.mapper;

import com.sandeepkamathkr.webservice.dto.CommentDTO;
import com.sandeepkamathkr.webservice.model.Comment;

import java.util.function.Function;

public class CommentMapper implements Function<Comment, CommentDTO> {
    @Override
    public CommentDTO apply(Comment comment) {

        return CommentDTO.builder()
                .Id(comment.getId())
                .postId(comment.getPostId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }
}