package com.projects.cadastro_usuario.controller;

import com.projects.cadastro_usuario.business.UserServices;
import com.projects.cadastro_usuario.infrastructure.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userServices.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findUserByEmail(@RequestParam String email){
        return ResponseEntity.ok(userServices.findUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email){
        userServices.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateEmail(@RequestParam Integer id, @RequestBody User user){
        userServices.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
