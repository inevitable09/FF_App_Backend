package com.rudra.ShortForm;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jt;

    @Autowired
    PasswordEncoder passwordEncoder;

    public int save(UserModel user) {
        System.out.println(user.getUsername()+" "+user.getPassword());
        String enc = passwordEncoder.encode(user.getPassword());
        String sql = "insert into users values(?,?,?)";
        return jt.update(sql, user.getUsername(), enc, "ROLE_USER");
    }

    public UserModel findByUsername(String username) {
        String sql = "select * from users where username=?";
        List<UserModel> list = jt.query(sql, new BeanPropertyRowMapper<>(UserModel.class), username);
        return list.isEmpty() ? null : list.get(0);
    }
}