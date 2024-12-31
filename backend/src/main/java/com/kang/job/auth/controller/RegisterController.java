package com.kang.job.auth.controller;

import com.kang.job.auth.entity.User;
import com.kang.job.auth.model.PasswordSettingRequest;
import com.kang.job.auth.service.RegisterService;
import jakarta.mail.MessagingException;
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
 * <p>
 * 1.ユーズにもらったメールアドレスにメールを送って、メールの中にパスワードを設定できるリンクを含めている
 * 2.ユーズがそのリンクをクリックして、パスワードを設定して、新しいユーズを作って登録完了だ
 * </p>
 *
 * @author kanghouchao
 */
@Validated
@RestController
@RequestMapping("register")
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    /**
     * Send Email for new user
     *
     * @param email user's email
     * @return response
     */
    @PostMapping("send-email")
    public ResponseEntity<?> sendEmail(@RequestParam @Email final String email) throws MessagingException {
        this.registerService.sendEmail(email);
        return ResponseEntity.ok().build();
    }

    /**
     * create user by token and password
     *
     * @param request token and password
     * @return userId
     */
    @PostMapping("create-user")
    public ResponseEntity<Long> createUser(@Valid @RequestBody PasswordSettingRequest request) {
        final User user = this.registerService.createUser(request.token(), request.password());
        return ResponseEntity.ok(user.getId());
    }

}
