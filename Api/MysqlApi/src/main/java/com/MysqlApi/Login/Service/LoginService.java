package com.MysqlApi.Login.Service;
import com.MysqlApi.Login.Service.UserData;

public interface LoginService {
    boolean login(UserData userData);
    UserData getUserData(String username);
}
