package com.qf.takeaway.service.impl;

import com.qf.takeaway.dao.OrderDao;
import com.qf.takeaway.entity.Order;
import com.qf.takeaway.service.OrderService;
import com.qf.takeaway.util.GetTimeNowUtil;
import com.qf.takeaway.util.TokenUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-07-06 15:38:44
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(String oId) {
        return this.orderDao.queryById(oId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        String s = TokenUtil.getToken().substring(0, 10);
        order.setoId(s);
        order.setCreattime(GetTimeNowUtil.getTime());
        order.setStatus("0");
        this.orderDao.insert(order);
//        this.orderDao.insertOrderList();
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String oId) {
        return this.orderDao.deleteById(oId) > 0;
    }

    @Override
    public Integer updateStatusById(String oid) {
        String time = GetTimeNowUtil.getTime();
        Integer status=orderDao.updateStatusById(oid,time);
        return status;
    }

    @Override
    public List<Order> queryByNick(String nickname) {
        List<Order> orders=orderDao.queryByNick(nickname);
        return orders;
    }

    @Override
    public List<Order> queryAll() {
        List<Order> orders=orderDao.queryAll1();
        return orders;
    }
}
