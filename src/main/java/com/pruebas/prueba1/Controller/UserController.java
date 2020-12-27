package com.pruebas.prueba1.Controller;

import com.pruebas.prueba1.Entity.User;
import com.pruebas.prueba1.Repository.UserRepository;
import com.pruebas.prueba1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) { this.userService = userService; }


    @PostMapping
    public ResponseEntity<?> CreateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> GetUsers(){
        return new ResponseEntity<>(userService.findUser(), HttpStatus.OK);
    }

    @GetMapping("/ciudad")
    public ResponseEntity<?> GetUsersByCity(){
        return new ResponseEntity<>(userService.FindUsersByCity(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(userService.findCreationDateAfter(date), HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser (@PathVariable Integer userId, @RequestBody User user){
        User updateUsers = userService.getOne(userId);

        updateUsers.setNombre(user.getNombre());
        updateUsers.setApellido(user.getApellido());
        updateUsers.setEmail(user.getEmail());
        updateUsers.setPassword(user.getPassword());
        updateUsers.setPais(user.getPais());
        updateUsers.setProvincia(user.getProvincia());
        updateUsers.setCiudad(user.getCiudad());

        return new ResponseEntity<>(userService.updateUser(updateUsers), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@PathVariable Integer userId) {

        User user = userService.getOne(userId);
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
