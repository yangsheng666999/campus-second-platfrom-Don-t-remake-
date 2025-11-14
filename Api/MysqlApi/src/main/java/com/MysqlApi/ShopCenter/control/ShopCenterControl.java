package com.MysqlApi.ShopCenter.control;

import com.MysqlApi.AllUserManage.Dao.AllUserManageDao;
import com.MysqlApi.JWT.Jwtservice;
import com.MysqlApi.Result;
import com.MysqlApi.ShopCenter.Entity.GoodMessage;
import com.MysqlApi.ShopCenter.Service.ShopCenterService;
import com.MysqlApi.UserManage.Service.UserManageService;
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
    public Result addgood(@RequestBody GoodMessage goodMessage){
        try{
            // 从 token 拿 username
//            String token = request.getHeader("Authorization").replace("Bearer ", "");
//            String username = jwtService.extractUsername(token);

            // 查询用户信息
//            UserMessage user = userManageService.getUser(username);

            // 判断是否封禁
//            if (user.getIsBanned() == 1) {
//                return Result.error( "用户已被封禁，无法发布商品", null);
//            }

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
