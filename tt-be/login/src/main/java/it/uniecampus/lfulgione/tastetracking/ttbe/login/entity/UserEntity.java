package it.uniecampus.lfulgione.tastetracking.ttbe.login.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 64)
    private String firstname;

    @Size(max = 64)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 64)
    private String lastname;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Size(max = 16)
    @NotNull
    @Column(name = "tax", nullable = false, length = 16)
    private String tax;

    @Size(max = 320)
    @NotNull
    @Column(name = "email", nullable = false, length = 320)
    private String email;

    @Size(max = 60)
    @NotNull
    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Size(max = 25)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 25)
    private String phoneNumber;

    @Column(name = "verfied")
    private Boolean verfied = false;

    @Column(name = "creation_date")
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @Column(name = "delete_date")
    private Timestamp deleteDate = null;
}
