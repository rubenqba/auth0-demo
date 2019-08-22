package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    private String id;

    @Builder.Default
    private boolean enabled = true;

    private String username;
    private String email;
    private String avatar;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant createdOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant expiredOn;

    @Builder.Default
    private Set<String> roles = Set.of();

    @Builder.Default
    private Boolean newUser = true;
}