package com.MysqlApi.AllBuyManager.Service;

import com.github.pagehelper.PageInfo;

public interface AllBuyManagerService {
    public PageInfo<AllSalerMessage> getAllBuyMessage(int pageNum);
}
