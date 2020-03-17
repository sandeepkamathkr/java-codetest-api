package com.sandeepkamathkr.webservice.service;

import com.sandeepkamathkr.webservice.dto.CommentDTO;
import com.sandeepkamathkr.webservice.mapper.CommentMapper;
import com.sandeepkamathkr.webservice.model.Comment;
import com.sandeepkamathkr.webservice.repository.CommentRepository;
import com.sandeepkamathkr.webservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<CommentDTO> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable).map(new CommentMapper());
    }

    @Transactional(readOnly = true)
    public Page<CommentDTO> getAllCommentsForPost(Pageable pageable, long postId) {
        postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post with postId = " + postId + " Not Found"));
        return commentRepository.findAllByPostId(pageable, postId).map(new CommentMapper());
    }

    @Transactional(readOnly = true)
    public CommentDTO getComment(Long commentId) {
        return new CommentMapper()
                .apply(commentRepository.findById(commentId)
                        .orElseThrow(() -> new EntityNotFoundException("Comment with commentId = " + commentId + " Not Found")));
    }

    @Transactional
    public CommentDTO saveComment(CommentDTO commentDto) {
        Optional<Comment> dbComment = commentRepository.findById(commentDto.getId());
        if (dbComment.isPresent()) {
            throw new EntityExistsException("Comment with commentId = " + commentDto.getId() + " Already Exist");
        } else {
            Comment comment = Comment.builder()
                    .body(commentDto.getBody())
                    .email(commentDto.getEmail())
                    .name(commentDto.getName())
                    .postId(commentDto.getPostId())
                    .build();
            return new CommentMapper().apply(commentRepository.save(comment));
        }
    }


}
