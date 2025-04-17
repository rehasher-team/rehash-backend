package kr.co.rehash.api.controller;

import jakarta.validation.Valid;
import kr.co.rehash.api.domain.User;
import kr.co.rehash.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        log.info(String.valueOf(user));
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

}
