package com.sandeepkamathkr.webservice.dto;

import com.sandeepkamathkr.webservice.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long Id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private LocalDate date;

    private List<Post> posts;
}
