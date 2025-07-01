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

    @PostMapping
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.signup(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
