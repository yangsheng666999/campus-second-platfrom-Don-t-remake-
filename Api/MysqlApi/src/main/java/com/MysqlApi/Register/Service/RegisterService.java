package com.MysqlApi.Register.Service;


import com.MysqlApi.Login.Entity.UserData;

public interface RegisterService {
    boolean register(UserData userData);
}
