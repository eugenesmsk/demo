package com.example.demo.model;

import com.example.demo.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        Iterable<User> users = repository.findAll();
        return StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
    }


    public void create(String name) {
        User user = new User(
                new Random().nextInt(100000), //tod
                name
        );
        repository.save(user);
    }
}
