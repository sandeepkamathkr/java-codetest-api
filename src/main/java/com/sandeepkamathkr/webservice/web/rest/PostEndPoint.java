package com.sandeepkamathkr.webservice.web.rest;

import com.sandeepkamathkr.webservice.dto.PostDTO;
import com.sandeepkamathkr.webservice.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@Api(value = "/posts")
@RequestMapping("/posts")
@RestController()
@RequiredArgsConstructor
public class PostEndPoint {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(
            @PathVariable(required = true) Long postId
    ) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping(consumes = {"application/xml", "application/json"})
    public ResponseEntity<PostDTO> savePost(
            @RequestBody(required = true) PostDTO post
    ) throws URISyntaxException {
        PostDTO postDto = postService.savePost(post);
        return ResponseEntity
                .created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().toString() + postDto.getId()))
                .body(postDto);
    }

    @ApiOperation(value = "Get All Posts for User", response = PostDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})
    @GetMapping()
    public ResponseEntity<Page<PostDTO>> getAllPostsForUser(Pageable pageable,
                                                            @RequestParam(name = "userId") long userId) {
        return ResponseEntity.ok(postService.getAllPostsForUser(pageable, userId));
    }
}
