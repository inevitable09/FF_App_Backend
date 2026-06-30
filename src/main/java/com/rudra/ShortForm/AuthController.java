package com.rudra.ShortForm;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
public class AuthController {
    @GetMapping("/check")
    public String check(Authentication auth) {
        String username = auth.getName();
        String role = auth.getAuthorities().iterator().next().getAuthority();
        return username + "," + role;
    }

    @GetMapping("/about")
    public String about() {
        return "App by Kamal Sir";
    }
}
