package com.sandeepkamathkr.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private long Id;

    @NotNull
    private long postId;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String body;
};
