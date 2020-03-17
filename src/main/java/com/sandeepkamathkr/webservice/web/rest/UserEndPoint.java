package com.sandeepkamathkr.webservice.web.rest;

import com.sandeepkamathkr.webservice.dto.UserDTO;
import com.sandeepkamathkr.webservice.service.UserService;
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

@Api(value = "/users")
@RequestMapping("/users")
@RestController()
@RequiredArgsConstructor
public class UserEndPoint {

    private final UserService userService;
    @ApiOperation(value = "Get All Users", response = UserDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request Successfully completed"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Error")})
    @GetMapping()
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(
            @PathVariable(required = true) Long userId
    ) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping(consumes = {"application/xml","application/json"})
    public ResponseEntity<UserDTO> saveUser(
            @RequestBody(required = true) UserDTO user
    ) throws URISyntaxException {
        UserDTO userDto = userService.saveUser(user);
        return ResponseEntity
                .created(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().toString() + userDto.getId()))
                .body(userDto);
    }
}
