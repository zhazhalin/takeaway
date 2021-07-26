package com.qf.takeaway.dao;

import com.qf.takeaway.entity.Orderlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Orderlist)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-10 16:01:05
 */
public interface OrderlistDao {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orderlist queryById(String oId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Orderlist> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderlist 实例对象
     * @return 对象列表
     */
    List<Orderlist> queryAll(Orderlist orderlist);

    /**
     * 新增数据
     *
     * @param orderlist 实例对象
     * @return 影响行数
     */
    int insert(Orderlist orderlist);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderlist> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Orderlist> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orderlist> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Orderlist> entities);

    /**
     * 修改数据
     *
     * @param orderlist 实例对象
     * @return 影响行数
     */
    int update(Orderlist orderlist);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 影响行数
     */
    int deleteById(String oId);

    List<Orderlist> queryAllOrder();

}

