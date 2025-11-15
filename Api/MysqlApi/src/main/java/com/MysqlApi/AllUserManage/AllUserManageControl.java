package com.MysqlApi.AllUserManage;

import com.MysqlApi.Result;
import com.MysqlApi.AllUserManage.Service.AllUserManageService;
import com.MysqlApi.AllUserManage.Service.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllUserManageControl {
    @Autowired
    AllUserManageService userMangeService;

    @RequestMapping("/getAllUser")
    public Result getAllUser(@RequestParam("pageNum") int pageNum) {
        try{
            return Result.success("获取成功",userMangeService.getAllUser(pageNum,15));
        }
        catch (Exception e) {
            return Result.error("获取失败",null);
        }
    }
    @RequestMapping("/updatePass")
    public Result updatePass(@RequestBody UserMessage userMessage) {
        try{
            userMangeService.updatePass(userMessage);
            return Result.success("修改成功","pass:" + userMessage.getPass());
        }
        catch (Exception e) {
            return Result.error("修改失败","pass:" + userMessage.getPass());
        }
    }
    @RequestMapping("/deleteUser")
    public Result deleteUser(@RequestParam("username") String username) {
        try{
            userMangeService.deleteUser(username);
            return Result.success("删除成功",null);
        }
        catch (Exception e) {
            return Result.error("删除失败",null);
        }
    }

    @RequestMapping("/banUser")
    public Result banUser(@RequestBody UserMessage userMessage) {
        try{
            userMangeService.updateIsBanned(userMessage);
            return Result.success("封禁成功",userMessage.getIsBanned());
        }
        catch (Exception e) {
            return Result.error("封禁失败",null);
        }
    }
}
