package com.kang.jobprofile.user.auth.domain;

/**
 * @author kanghouchao
 */
public class UserFactory {

    public static User createUser(String email, String password) {
        return new User(email,password,"USER");
    }
}
