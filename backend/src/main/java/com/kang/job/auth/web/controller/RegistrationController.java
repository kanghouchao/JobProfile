package com.kang.job.auth.web.controller;

import com.kang.job.auth.web.dto.UserPasswordRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登録のためのアクション
 *
 * @author kanghouchao
 */
@Validated
@RestController
@RequestMapping("auth/register")
@AllArgsConstructor
public class RegistrationController {

    @PostMapping("request")
    public ResponseEntity<?> request(@RequestParam @Email final String email) {
        return null;
    }


    @PostMapping("complete")
    public ResponseEntity<Long> complete(@Valid @RequestBody UserPasswordRequest request) {
        return null;
    }

}
