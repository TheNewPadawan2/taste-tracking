package it.uniecampus.lfulgione.tastetracking.ttbe.login.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SignupRequestDTO {
    private String firstname;
    private String lastname;
    private Date birthday;
    private String taxId;
    private String email;
    private String password;
    private String phoneNumber;
}
