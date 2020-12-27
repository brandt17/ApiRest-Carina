package com.pruebas.prueba1.Services;


import com.pruebas.prueba1.DTO.UserDTO;
import com.pruebas.prueba1.Entity.User;
import com.pruebas.prueba1.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(User newUser) {
        return new UserDTO(userRepository.save(newUser));
    }

    public List<UserDTO> findUser() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public User getOne(Integer userId) {
        return userRepository.getOne(userId);
    }

    public UserDTO updateUser(User updateU) {

        return new UserDTO(userRepository.save(updateU));
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> userByCity() {
        return userRepository.findUsersByCity();
    }

    public List<User> findCreationDateAfter(LocalDate date) {
        return userRepository.findCreationDateAfter(date);
    }


   public List<User> FindUsersByCity() {
        return userRepository.findUsersByCity();
    }
}
