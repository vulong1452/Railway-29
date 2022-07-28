package com.example.demo4.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class StudentDTO {
    @NonNull
    private int id;
    @NonNull
    private String email;
    @NonNull
    private String fullname;
    @NonNull
    private String username;
}
