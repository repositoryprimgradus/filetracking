package com.pg.filetracking.login;


public interface LoginService {
    void save(Login login);

    Login findByUsername(String username);
}
