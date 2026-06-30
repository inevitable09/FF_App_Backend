package com.rudra.ShortForm;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortFormService {
    @Autowired
    ShortFormDao dao;

    public String getFullForm(String sf) {
        return dao.getFullForm(sf);
    }

    public String add(ShortFormModel s) {
        try {
            dao.add(s);
            return "short form added";
        } catch (Exception e) {
            return "error adding short form" + e;
        }
    }

    public List<ShortFormModel> all() {
        return dao.all();
    }

    public String delete(String sf) {
        try {
            dao.delete(sf);
            return "deleted";
        } catch (Exception e) {
            return "error deleting short form" + e;
        }
    }
}