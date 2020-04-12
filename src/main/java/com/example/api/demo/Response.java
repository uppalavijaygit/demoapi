package com.example.api.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Response {
    private String status;
    private List<User> userList;
}
