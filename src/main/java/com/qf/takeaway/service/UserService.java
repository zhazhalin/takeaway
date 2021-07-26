package com.qf.takeaway.service;

import com.qf.takeaway.entity.User;
import com.qf.takeaway.result.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-07-06 11:00:28
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    User queryById(Integer uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @param request
     * @return
     */
    ResponseData login(String userName, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 查询所有
     * @return
     */
    List<User> queryAll();
}
