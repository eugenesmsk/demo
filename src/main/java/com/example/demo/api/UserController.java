package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.model.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("all") //endpoint
    public List<ApiUser> all() {
        List<User> users = service.getUsers();
        return users.stream()
                .map(u -> new ApiUser(u.getName()))
                .collect(Collectors.toList());
    }


    @AllArgsConstructor
    public static class ApiUser {
        public final String name;
    }


    @PutMapping("add")
    public void addUser(@RequestBody AddNewUserRequest request) {
        service.create(request.name);
    }

    @Getter
    @Setter
    public static class AddNewUserRequest {
        private String name;
    }

}
