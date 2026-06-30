package com.rudra.ShortForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao dao;

    public String save(UserModel user) {
        try {
            int i = dao.save(user);
            System.out.println("user saved with id: " + i);
            return "User Registered";
        } catch (Exception e) {
            return "error saving user " + e;
        }
    }
}
