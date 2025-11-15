package com.MysqlApi.Recharge.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeMessage {
    private String username;
    private int money;
}
