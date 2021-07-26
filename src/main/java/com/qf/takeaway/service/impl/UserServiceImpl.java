package com.qf.takeaway.service.impl;

import com.qf.takeaway.config.JwtTokenConfig;
import com.qf.takeaway.entity.User;
import com.qf.takeaway.dao.UserDao;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-07-06 11:00:28
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired(required = false)
    //security 提供的密码加密
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenConfig jwtTokenConfig;

    //jwt 头部信息
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer uId) {
        return this.userDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.userDao.deleteById(uId) > 0;
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param request
     * @return
     */
    @Override
    public ResponseData login(String userName, String password, HttpServletRequest request) {
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);


        //如果 UserDetails为空 或者passwordEncode生成的密码和前端传的不匹配
        if(null==userDetails||!passwordEncoder.matches(password,new BCryptPasswordEncoder().encode(userDetails.getPassword()))){

            return new ResponseData(ResponseCode.FAILED);
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken=new
                UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        //全局更新对象
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //根据userDetails 获取token
        String token = jwtTokenConfig.generateToken(userDetails);

        Map<String,String> tokenMap=new HashMap<>();

        //将token和头部信息 放入map
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);

        return new ResponseData("200","登录成功",tokenMap);
    }

    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public List<User> queryAll() {
        List<User> users=userDao.queryAll1();
        return users;
    }
}
