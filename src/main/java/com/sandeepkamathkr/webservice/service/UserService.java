package com.sandeepkamathkr.webservice.service;

import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.mapper.UserMapper;
import com.sandeepkamathkr.webservice.model.User;
import com.sandeepkamathkr.webservice.repository.PostRepository;
import com.sandeepkamathkr.webservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(new UserMapper(postRepository)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO getUser(Long userId) {
        return new UserMapper(postRepository)
                .apply(userRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException("User with userId = " + userId + " Not Found")));
    }

    @Transactional
    public UserDTO saveUser(UserDTO userDto) {
        Optional<User> dbUser = userRepository.findById(userDto.getId());
        if (dbUser.isPresent()) {
            throw new EntityExistsException("User with userId = " + userDto.getId() + " Already Exist");
        } else {
            User user = User.builder()
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .date(LocalDate.now())
                    .build();
            return new UserMapper(postRepository).apply(userRepository.save(user));
        }
    }


}
