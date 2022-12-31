package tr.edu.ku.cmhg.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tr.edu.ku.cmhg.dto.UserDto;
import tr.edu.ku.cmhg.entity.Role;
import tr.edu.ku.cmhg.entity.User;
import tr.edu.ku.cmhg.response.RoleResponse;
import tr.edu.ku.cmhg.response.UserResponse;
import tr.edu.ku.cmhg.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserDto userDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v2/user/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userDto));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}
