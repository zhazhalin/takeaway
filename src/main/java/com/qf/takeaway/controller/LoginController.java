package com.qf.takeaway.controller;

import com.qf.takeaway.entity.User;
import com.qf.takeaway.entity.UserLogin;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Api(tags = "LoginController")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public ResponseData login(@RequestBody UserLogin userLogin, HttpServletRequest request){
        return userService.login(userLogin.getUserName(),userLogin.getPassword(),request);
    }

    @CrossOrigin
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/login/info")
    public User getUserInfo(Principal principal){
        if(principal==null){
            return null;
        }
        String username  = principal.getName();
        return userService.getUserByName(username);


    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public ResponseData logout(){
        return new ResponseData("200","注销成功");
    }
}
