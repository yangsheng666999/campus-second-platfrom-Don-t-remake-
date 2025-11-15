package com.MysqlApi.sellerGoods.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalerMessage {
    private String gid;
    private String gname;
    private Integer price;
    private String status;          // 0=在售，1=已售出
    private LocalDateTime time;  // 对应数据库的time字段
}
