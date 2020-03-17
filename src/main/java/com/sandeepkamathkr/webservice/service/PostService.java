package com.sandeepkamathkr.webservice.service;

import com.sandeepkamathkr.webservice.dto.PostDTO;
import com.sandeepkamathkr.webservice.mapper.PostMapper;
import com.sandeepkamathkr.webservice.model.Post;
import com.sandeepkamathkr.webservice.repository.PostRepository;
import com.sandeepkamathkr.webservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<PostDTO> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable).map(new PostMapper());
    }

    @Transactional(readOnly = true)
    public List<PostDTO> getAllPostsForUser(long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with userId = " + userId + " Not Found"));
        return postRepository.findAllByUserId(userId).stream().map(new PostMapper()).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostDTO getPost(Long postId) {
        return new PostMapper()
                .apply(postRepository.findById(postId)
                        .orElseThrow(() -> new EntityNotFoundException("Post with postId = " + postId + " Not Found")));
    }

    @Transactional
    public PostDTO savePost(PostDTO postDto) {
        Optional<Post> dbPost = postRepository.findById(postDto.getId());
        if (dbPost.isPresent()) {
            throw new EntityExistsException("Post with postId = " + postDto.getId() + " Already Exist");
        } else {
            Post post = Post.builder()
                    .title(postDto.getTitle())
                    .userId(postDto.getUserId())
                    .body(postDto.getBody())
                    .build();
            return new PostMapper().apply(postRepository.save(post));
        }
    }


}
