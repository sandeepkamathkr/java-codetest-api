package com.sandeepkamathkr.webservice.repository;

import com.sandeepkamathkr.webservice.model.Post;
import com.sandeepkamathkr.webservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByUserId(Pageable pageable,long userId);

    List<Post> findAllByUserId(long userId);
}