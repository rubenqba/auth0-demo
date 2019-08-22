package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class ProfileService {

    public UserProfile getUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return defaultProfile(((JwtAuthenticationToken) authentication));
    }

    private UserProfile defaultProfile(JwtAuthenticationToken details) {
        Instant now = Instant.now();
        return UserProfile.builder()
                .id(details.getToken().getClaimAsString("sub"))
                .username(details.getToken().getClaimAsString("nickname"))
                .firstName(details.getToken().getClaimAsString("given_name"))
                .lastName(details.getToken().getClaimAsString("family_name"))
                .email(details.getToken().getClaimAsString("email"))
                .avatar(details.getToken().getClaimAsString("picture"))
                .createdOn(details.getToken().getIssuedAt())
                .expiredOn(details.getToken().getExpiresAt())
//                .roles(details.getAuthorities())
                .build();
    }
}
