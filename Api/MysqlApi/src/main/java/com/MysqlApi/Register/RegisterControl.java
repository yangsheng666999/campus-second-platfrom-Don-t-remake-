package com.MysqlApi.Register;

import com.MysqlApi.Login.Entity.UserData;
import com.MysqlApi.Register.Service.RegisterService;
import com.MysqlApi.Result;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class RegisterControl {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public Result register(@RequestBody UserData userData) {
        userData.setMoney(0);
        userData.setPass(0);
        String password = userData.getPassword();
        String Hashpassword = BCrypt.hashpw(password, BCrypt.gensalt());
        userData.setPassword(Hashpassword);

        // 创建一个Map,将userData的属性存储进去
        Map<String, String> userMap = new HashMap<>();
        userMap.put("username", userData.getUsername());
        userMap.put("password", userData.getPassword());
        userMap.put("money", String.valueOf(userData.getMoney()));
        userMap.put("pass", String.valueOf(userData.getPass()));

        if (registerService.register(userData)) {
            return Result.success("注册成功", userMap);// 将userMap传入返回值
        } else {
            return Result.error("注册失败", null);
        }
    }
}
