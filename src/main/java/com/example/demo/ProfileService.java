package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class ProfileService {

    public UserProfile getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return null; //defaultProfile((FirebaseUserDetails) authentication.getPrincipal());
    }

//    private UserProfile defaultProfile(FirebaseUserDetails details) {
//        Instant now = Instant.now();
//        return mongo.save(UserProfile.builder()
//                .id(details.getUsername())
//                .username(details.getEmail())
//                .email(details.getEmail())
//                .updatedOn(now)
//                .createdOn(details.getCreatedAt())
//                .expiredOn(details.getValidUntil())
//                .roles(details.getStringAuthorities())
//                .build());
//    }
}
