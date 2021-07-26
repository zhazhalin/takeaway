package com.qf.takeaway.controller;

import com.qf.takeaway.entity.User;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-07-06 11:00:28
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @ApiOperation(value = "insertUser",notes = "添加用户信息")
    @ApiParam(name = "user",value = "用户对象")
    @PostMapping("/insertUser")
    public ResponseData insertUser(@RequestBody User user) {
        User user1 = this.userService.insert(user);
        return new ResponseData(ResponseCode.SUCCESS);
    }
    @ApiOperation(value = "queryAll",notes = "查询所有用户信息")
    @GetMapping("/")
    public ResponseData queryAll() {
        List<User> users = this.userService.queryAll();
        return new ResponseData("0","请求成功",users);
    }
}
