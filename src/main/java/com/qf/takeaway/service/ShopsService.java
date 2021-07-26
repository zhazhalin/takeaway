package com.qf.takeaway.service;

import com.qf.takeaway.entity.Shops;
import com.qf.takeaway.result.ResponseData;

import java.util.List;

/**
 * (Shops)表服务接口
 *
 * @author makejava
 * @since 2021-07-06 10:39:22
 */
public interface ShopsService {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Shops queryById(String sId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param shops 实例对象
     * @return 实例对象
     */
    Shops insert(Shops shops);

    /**
     * 修改数据
     *
     * @param shops 实例对象
     * @return 实例对象
     */
    Shops update(Shops shops);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer sId);

    List<Shops> queryByTitle(String title);

    Shops queryShopById(String id);

    List<Shops> queryAll();

    List<Shops> queryLb();
}
