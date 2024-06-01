package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String firstname;
    private String lastname;
    private String birthday;
    private String taxId;
    private String email;
    private String password;
}
