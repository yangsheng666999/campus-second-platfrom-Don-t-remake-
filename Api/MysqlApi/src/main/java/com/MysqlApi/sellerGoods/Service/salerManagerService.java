package com.MysqlApi.sellerGoods.Service;

import com.MysqlApi.sellerGoods.Entity.SalerMessage;
import com.github.pagehelper.PageInfo;

public interface salerManagerService {
    PageInfo<SalerMessage> getAllrecord(String username, Integer PageNum);
    void updatePrice(String gid,Integer NewMoney);
    void deleterGood(String gid);
}
