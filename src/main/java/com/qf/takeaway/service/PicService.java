package com.qf.takeaway.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.takeaway.entity.Pic;
import com.qf.takeaway.result.ResponseData;

import java.util.List;

/**
 * (Pic)表服务接口
 *
 * @author makejava
 * @since 2021-07-06 11:21:49
 */
public interface PicService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Pic queryById(String pId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Pic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    Pic insert(Pic pic);

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    Pic update(Pic pic);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(String pId);

    List<Pic> queryByType(String type);


    ResponseData queryAll(Integer page, Integer limit);

    ResponseData delete(JSONArray arr);

    List<Pic> likeSelect(String value);

    ResponseData publish(String id,String status);
}
