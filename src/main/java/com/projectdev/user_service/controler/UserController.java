package com.projectdev.user_service.controler;



import com.projectdev.user_service.entity.User;
import com.projectdev.user_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    private String id;
    private User user;
    private User[] users;

    @GetMapping()
    public ResponseEntity<List<User>> getUserAll() {

        List<User> users = userService.getAllUser();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userNew = userService.saveUser(user);
        if (userNew == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userNew);

        }

//    @PutMapping(path="/{id}",
//        consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
//        produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//
//    public ResponseEntity<User> updateUser(@PathVariable String id,
//                                           @RequestBody User user) {
//        this.id = id;
//        this.user = user;
//        User usuario=null;
//        int pos=0;
//        int aux=0;
//
//        for (User user1: users ){
//            if (user.getId().equals(id)) {
//                usuario = user;
//                aux = pos;
//            }
//            pos++;
//        }
//        usuario.setName(copyUser.getName());
//        usuario.setEmail(copyUser.getEmail());
//
//        user.remove(aux);
//        user.add(aux,usuario);
//
//        Arrays.stream(users).map(user -> "Nueva Lista:" + user).forEach(System.out::println);
//        return new ResponseEntity<>(usuario, HttpStatus.OK);''




    }








