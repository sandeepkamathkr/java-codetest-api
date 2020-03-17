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
public class PostDTO {

    private long Id;

    @NotNull
    private long userId;

    @NotNull
    private String title;

    @NotNull
    private String body;
}
