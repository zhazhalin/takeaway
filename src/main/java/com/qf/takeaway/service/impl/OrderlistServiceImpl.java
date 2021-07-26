package com.qf.takeaway.service.impl;

import com.qf.takeaway.entity.Orderlist;
import com.qf.takeaway.dao.OrderlistDao;
import com.qf.takeaway.service.OrderlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderlist)表服务实现类
 *
 * @author makejava
 * @since 2021-07-10 16:01:05
 */
@Service("orderlistService")
public class OrderlistServiceImpl implements OrderlistService {
    @Resource
    private OrderlistDao orderlistDao;

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public Orderlist queryById(String oId) {
        return this.orderlistDao.queryById(oId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Orderlist> queryAllByLimit(int offset, int limit) {
        return this.orderlistDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderlist 实例对象
     * @return 实例对象
     */
    @Override
    public Orderlist insert(Orderlist orderlist) {
        this.orderlistDao.insert(orderlist);
        return orderlist;
    }

    /**
     * 修改数据
     *
     * @param orderlist 实例对象
     * @return 实例对象
     */
    @Override
    public Orderlist update(Orderlist orderlist) {
        this.orderlistDao.update(orderlist);
        return this.queryById(orderlist.getOId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String oId) {
        return this.orderlistDao.deleteById(oId) > 0;
    }

    @Override
    public List<Orderlist> queryAll() {
        List<Orderlist> list= orderlistDao.queryAllOrder();
        return list;
    }
}
