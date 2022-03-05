package com.dannielf.crud_phone_book.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id")
    private Long id;

    @Column(name = "cnt_full_name")
    private String fullName;

    @Column(name = "cnt_phone")
    private String phone;

    @Column(name = "cnt_email")
    private String email;

    @Column(name = "cnt_dob")
    private Date dateOfBirth;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "delete_at")
    private Date deleteAt;
}

