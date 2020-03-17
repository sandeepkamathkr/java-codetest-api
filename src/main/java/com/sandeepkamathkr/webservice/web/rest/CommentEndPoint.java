package com.sandeepkamathkr.webservice.web.rest;

import com.sandeepkamathkr.webservice.dto.CommentDTO;
import com.sandeepkamathkr.webservice.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Api(value = "/comments")
@RequestMapping("/comments")
@RestController()
@RequiredArgsConstructor
public class CommentEndPoint {

    private final CommentService commentService;

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> getComment(
            @PathVariable(required = true) Long commentId
    ) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    @PostMapping(consumes = {"application/xml", "application/json"})
    public ResponseEntity<CommentDTO> saveComment(
            @RequestBody(required = true) CommentDTO comment
    ) throws URISyntaxException {
        CommentDTO commentDto = commentService.saveComment(comment);
        return ResponseEntity
                .created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().toString() + commentDto.getId()))
                .body(commentDto);
    }

    @ApiOperation(value = "Get All Comments for Post", response = CommentDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})
    @GetMapping()
    public ResponseEntity<List<CommentDTO>> getAllCommentsForPost(@RequestParam(name = "postId") long postId) {
        return ResponseEntity.ok(commentService.getAllCommentsForPost(postId));
    }
}
