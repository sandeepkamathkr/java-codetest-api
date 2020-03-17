package com.sandeepkamathkr.webservice.repository;

import com.sandeepkamathkr.webservice.model.Comment;
import com.sandeepkamathkr.webservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findAllByPostId(Pageable pageable, long postId);
}