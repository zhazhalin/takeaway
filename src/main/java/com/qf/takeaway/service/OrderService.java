package com.qf.takeaway.service;

import com.qf.takeaway.entity.Order;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2021-07-06 15:38:44
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Order queryById(String oId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    boolean deleteById(String oId);

    Integer updateStatusById(String oid);

    List<Order> queryByNick(String nickname);

    List<Order> queryAll();
}
