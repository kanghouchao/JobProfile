package com.kang.resume.domain.model.entity;

import com.kang.resume.infrastructure.external.GenderConverter;
import com.kang.resume.user.auth.domain.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author kanghouchao
 */
@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String firstName;
    private String firstNameKana;

    private String lastName;
    private String lastNameKana;

    private LocalDate birthday;

    @Column(columnDefinition = "TINYINT")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    private String email;

    private String phone;

}
