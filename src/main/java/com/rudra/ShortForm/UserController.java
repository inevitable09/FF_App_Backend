package com.rudra.ShortForm;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/save")
    public String save(@RequestBody UserModel user) {
        return service.save(user);
    }
}
