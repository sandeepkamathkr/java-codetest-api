package com.sandeepkamathkr.webservice.repository;

import com.sandeepkamathkr.webservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    List<Post> findAllByUserId(long userId);
}