package com.sandeepkamathkr.webservice.mapper;

import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.model.User;
import com.sandeepkamathkr.webservice.repository.PostRepository;
import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class UserMapper implements Function<User, UserDTO> {

    private final PostRepository postRepository;
    @Override
    public UserDTO apply(User user) {

        return UserDTO.builder()
                .Id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(user.getDate())
                .posts(postRepository.findAllByUserId(user.getId()))
                .build();
    }
}