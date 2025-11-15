package com.MysqlApi.Login.Service;
import com.MysqlApi.Login.Entity.UserData;;

public interface LoginService {
    boolean login(UserData userData);
    UserData getUserData(String username);
}
