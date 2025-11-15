package com.MysqlApi.Recharge.Service.Impl;

import com.MysqlApi.Recharge.Dao.RechargeDao;
import com.MysqlApi.Recharge.Entity.RechargeMessage;
import com.MysqlApi.Recharge.Service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechargeServiceimpl implements RechargeService {
    @Autowired
    private RechargeDao rechargeDao;
    @Override
    public void recharge(RechargeMessage rechargeMessage) {
        Integer NowMoney=rechargeDao.getNowMoney(rechargeMessage.getUsername());
        rechargeMessage.setMoney(NowMoney+rechargeMessage.getMoney());
        rechargeDao.updateMoney(rechargeMessage);
    }
}
