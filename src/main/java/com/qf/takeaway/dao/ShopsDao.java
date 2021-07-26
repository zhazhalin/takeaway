package com.qf.takeaway.dao;

import com.qf.takeaway.entity.Shops;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Shops)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-06 10:39:22
 */
public interface ShopsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    Shops queryById(String sId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Shops> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shops 实例对象
     * @return 对象列表
     */
    List<Shops> queryAll(Shops shops);

    /**
     * 新增数据
     *
     * @param shops 实例对象
     * @return 影响行数
     */
    int insert(Shops shops);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shops> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Shops> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Shops> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Shops> entities);

    /**
     * 修改数据
     *
     * @param shops 实例对象
     * @return 影响行数
     */
    int update(Shops shops);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(Integer sId);

    List<Shops> queryByTitle(String title);

    Shops queryShopById(String id);
    /**
     * 查询所有
     * 无条件查询
     * @return 影响行数
     */
    List<Shops> queryAll1();

    List<Shops> queryLb();

    Integer getCount();
}

