package com.pg.filetracking.login;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
