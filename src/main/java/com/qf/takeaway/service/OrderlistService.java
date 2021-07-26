package com.qf.takeaway.service;

import com.qf.takeaway.entity.Orderlist;

import java.util.List;

/**
 * (Orderlist)表服务接口
 *
 * @author makejava
 * @since 2021-07-10 16:01:05
 */
public interface OrderlistService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orderlist queryById(String oId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Orderlist> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderlist 实例对象
     * @return 实例对象
     */
    Orderlist insert(Orderlist orderlist);

    /**
     * 修改数据
     *
     * @param orderlist 实例对象
     * @return 实例对象
     */
    Orderlist update(Orderlist orderlist);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    boolean deleteById(String oId);

    List<Orderlist> queryAll();

}
