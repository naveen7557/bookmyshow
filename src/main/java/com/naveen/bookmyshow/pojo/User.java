package com.naveen.bookmyshow.pojo;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import java.io.Serializable;

@NamedQuery(name = "User.findByEmailId",query = "select u from User u where u.email=email")
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User  implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_contactnumber")
    private String contactNumber;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "role")
    private String role;



}
