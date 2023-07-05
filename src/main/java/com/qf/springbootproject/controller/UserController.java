package com.qf.springbootproject.controller;

import com.qf.springbootproject.pojo.User;
import com.qf.springbootproject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Author Ashe
 * @Date 2023/6/28 19:06
 * @Description
 */

@CrossOrigin // 跨域问题解决
@RestController // Controller ResponseBody
@Api(value = "用户操作")
public class UserController {

    @Resource
    private UserService userService;



    // 登录
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码")
    })
    public int login(String username, String password) {

        User login = userService.login(username, password);

        System.out.println(login);
        System.out.println(login);
        System.out.println(login);
        System.out.println("master-test");
        System.out.println("hot-fix");
        if(login != null) {
            return 1;
        } else {
            return 0;
        }
    }

    // 注册
    @PostMapping("/regist")
    @ApiOperation(value = "注册")
    public int regist(String username, String password) {

        int regist = userService.regist(username, password);

        return regist;
    }

    @PutMapping("/updatePwd")
    @ApiOperation(value = "修改密码")
    public String updatePassword(String username, String oldPwd, String newPwd) {
        String s = userService.updatePassword(username, oldPwd, newPwd);

        return s;
    }

    @DeleteMapping("/deleteUser")
    @ApiOperation(value = "删除用户")
    public String deleteUser(int id) {
        int i = userService.deleteUser(id);

        if(i != 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }


    @GetMapping("/selectAll")
    @ApiOperation(value = "查询全部")
    public List<User> selectAll() {
        List<User> users = userService.selectAll();

        return users;
    }

}
