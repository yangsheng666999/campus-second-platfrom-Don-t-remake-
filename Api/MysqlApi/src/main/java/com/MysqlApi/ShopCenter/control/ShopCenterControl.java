package com.MysqlApi.ShopCenter.control;

import com.MysqlApi.AllUserManage.Dao.AllUserManageDao;
import com.MysqlApi.JWT.Jwtservice;
import com.MysqlApi.Result;
import com.MysqlApi.ShopCenter.Entity.GoodMessage;
import com.MysqlApi.ShopCenter.Service.ShopCenterService;
import com.MysqlApi.UserManage.Service.UserManageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.MysqlApi.UserManage.Service.UserMessage;

@RestController
public class ShopCenterControl {
    @Autowired
    ShopCenterService  shopCenterService;
    @Autowired
    Jwtservice jwtService;
    @Autowired
    UserManageService userManageService;


    @RequestMapping("/getAllGoods")
    public Result getAllGoods(@RequestParam int PageNum){
        try{
            return Result.success("获取成功",shopCenterService.getsaleGoods(PageNum));
        }catch (Exception e){
            return Result.error("获取失败",null);
        }
    }

    @PostMapping("/addgood")
    public Result addgood(@RequestBody GoodMessage goodMessage, HttpServletRequest request){
        try{
            // 读取 token
            String token = request.getHeader("token");  // 直接获取 token 请求头
            if (token == null) {
                return Result.error("未登录或 token 缺失", null);
            }

            // 获取用户名
            String username = jwtService.extractUsername(token);

            // 查用户信息
            UserMessage userMessage = userManageService.getUser(username);

            // 判断用户是否被封禁
            if (userMessage.getIsBanned() == 1) {
                return Result.error("用户被封禁", null);
            }


            shopCenterService.addgood(goodMessage);
            return Result.success("添加成功",null);
        }catch (Exception e){
            return Result.error("添加失败",null);
        }
    }

    @RequestMapping("/shopping")
    public Result shopping(@RequestParam("gid") String gid,@RequestParam("username") String username){
        try{
            shopCenterService.shopping(gid,username);
            return Result.success("购买成功",null);
        }catch (Exception e){
            return Result.error("购买失败",null);
        }
    }
}
