package com.springback.sksbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userid;

    @Column(name="user_name",nullable = false)
    @Size(max = 15)
    private String userName;

    @Column(name="email", length = 255,nullable = false,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    @Size(max = 12)
    private String password;
}
