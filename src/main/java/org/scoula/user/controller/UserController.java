package org.scoula.user.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.user.dto.*;
import org.scoula.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("GET 요청은 아직 구현되지 않았습니다.");
    }


    @PostMapping
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.signup(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}
