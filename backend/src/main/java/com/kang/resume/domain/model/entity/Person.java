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
    /**
     * Unique identifier for the person.
     */
    private Long id;

    /**
     * The associated user account.
     */
    @OneToOne
    private User user;

    /**
     * The first name of the person.
     */
    private String firstName;
    /**
     * The phonetic reading of the first name (kana).
     */
    private String firstNameKana;

    /**
     * The last name of the person.
     */
    private String lastName;
    /**
     * The phonetic reading of the last name (kana).
     */
    private String lastNameKana;

    /**
     * The birthday of the person.
     */
    private LocalDate birthday;

    /**
     * The gender of the person, converted to/from a TINYINT in the database.
     */
    @Column(columnDefinition = "TINYINT")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    /**
     * The email address of the person.
     */
    private String email;

    /**
     * The phone number of the person.
     */
    private String phone;

}

