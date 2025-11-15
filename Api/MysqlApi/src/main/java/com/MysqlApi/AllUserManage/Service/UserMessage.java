package com.MysqlApi.AllUserManage.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
    private String username;
    private String pass;
    private Integer isBanned;
}
