package com.rudra.ShortForm;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ShortFormController {
    @Autowired
    ShortFormService service;

    @GetMapping("/gff")
    public String getFullForm(@RequestParam String sf) {
        return service.getFullForm(sf);
    }

    @PostMapping("/add")
    public String add(@RequestBody ShortFormModel s) {
        return service.add(s);
    }

    @GetMapping("/all")
    public List<ShortFormModel> all() {
        return service.all();
    }

    @DeleteMapping("/del")
    public String del(@RequestParam String sf) {
        return service.delete(sf);
    }
}
