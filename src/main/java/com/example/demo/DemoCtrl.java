package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoCtrl {

    private final ProfileService profiles;

    @GetMapping
    UserProfile getProfile() {
        return profiles.getUserProfile();
    }
}
