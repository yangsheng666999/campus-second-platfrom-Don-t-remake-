package com.MysqlApi.sellerGoods.Dao;

import com.MysqlApi.sellerGoods.Entity.SalerMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface SalerManagerDao {

    @Select("SELECT gid, gname, price, status, time  FROM salemanager WHERE uid = #{username} ORDER BY time DESC")
    List<SalerMessage> getAllrecord(@RequestParam("username") String username);

    @Select("SELECT status FROM salemanager WHERE gid = #{gid}")
    String getStatus(@RequestParam("gid") String gid);

    @Update("UPDATE goods SET price = #{NewMoney} WHERE gid = #{gid}")
    void updateMoney(@RequestParam("gid") String gid, @RequestParam("NewMoney") Integer NewMoney);

    @Delete("DELETE FROM goods WHERE gid = #{gid}")
    void deletergood(@RequestParam("gid") String gid);
}
