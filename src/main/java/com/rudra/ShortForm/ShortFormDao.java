package com.rudra.ShortForm;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

@Repository
public class ShortFormDao {
    @Autowired
    JdbcTemplate jt;

    public String getFullForm(String sf) {
        try {
            String sql = "select ff from short_form where sf=?";
            return jt.queryForObject(sql, String.class, sf);
        } catch (Exception e) {
            return "no info available";
        }
    }

    public void add(ShortFormModel s) {
        String sql = "insert into short_form(sf, ff) values(?,?)";
        jt.update(sql, s.getSf().toLowerCase(), s.getFf().toLowerCase());
    }

    public List<ShortFormModel> all() {
        String sql = "select * from short_form";
        return jt.query(sql, new BeanPropertyRowMapper<>(ShortFormModel.class));
    }

    public int delete(String sf) {
        String sql = "delete from short_form where sf=?";
        return jt.update(sql, sf.toLowerCase());
    }
}