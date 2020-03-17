package com.sandeepkamathkr.webservice.service;

import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.repository.PostRepository;
import com.sandeepkamathkr.webservice.repository.UserRepository;
import com.sandeepkamathkr.webservice.mapper.UserMapper;
import com.sandeepkamathkr.webservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(new UserMapper(postRepository));
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
