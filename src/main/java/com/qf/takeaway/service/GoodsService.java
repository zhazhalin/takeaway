package com.qf.takeaway.service;

import com.qf.takeaway.entity.Goods;
import com.qf.takeaway.result.ResponseData;

import java.util.HashMap;
import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-07-06 16:31:52
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    Goods queryById(String gId);

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
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    Goods update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer gId);

    List<Goods> queryGoodsByName(String name);

    List<Goods> queryGoodsBySid(String sid);
    List<HashMap<String,Object>> queryByClassify(String sid);

    List<Goods> queryAll();
}
