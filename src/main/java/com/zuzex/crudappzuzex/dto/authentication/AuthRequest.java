package com.zuzex.crudappzuzex.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotBlank(message = "login can't be null")
    private String login;
    @NotBlank(message = "password can't be null")
    private String password;
}
