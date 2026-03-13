package com.projects.cadastro_usuario.business;

import com.projects.cadastro_usuario.infrastructure.entities.User;
import com.projects.cadastro_usuario.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private final UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    public User findUserByEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void deleteByEmail(String email){
        repository.deleteByEmail(email);
    }

    public void updateUserById(Integer Id, User user){
        User userEntity = repository.findById(Id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado!")
        );
        User userUpdated = User.builder()
                .email(user.getEmail() != null ?
                        user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ?
                        user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdated);
    }

}
