package com.qf.takeaway.service.impl;

import com.qf.takeaway.entity.Shops;
import com.qf.takeaway.dao.ShopsDao;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.ShopsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shops)表服务实现类
 *
 * @author makejava
 * @since 2021-07-06 10:39:23
 */
@Service("shopsService")
public class ShopsServiceImpl implements ShopsService {
    @Resource
    private ShopsDao shopsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sId 主键
     * @return 实例对象
     */
    @Override
    public Shops queryById(String sId) {
        return this.shopsDao.queryById(sId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(Integer offset, Integer limit) {
        if(offset==null&&limit==null){
            offset=0;
            limit=10;
        }else {
            offset=(offset-1)*limit;
        }
        List<Shops> shopsList=this.shopsDao.queryAllByLimit(offset, limit);
        Integer i=shopsDao.getCount();
        return new ResponseData("0","success",shopsList,i);
    }

    /**
     * 新增数据
     *
     * @param shops 实例对象
     * @return 实例对象
     */
    @Override
    public Shops insert(Shops shops) {
        this.shopsDao.insert(shops);
        return shops;
    }

    /**
     * 修改数据
     *
     * @param shops 实例对象
     * @return 实例对象
     */
    @Override
    public Shops update(Shops shops) {
        this.shopsDao.update(shops);
        return this.queryById(shops.getsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer sId) {
        return this.shopsDao.deleteById(sId) > 0;
    }

    @Override
    public List<Shops> queryByTitle(String title) {
        List<Shops> shops=shopsDao.queryByTitle(title);
        return shops;
    }

    @Override
    public Shops queryShopById(String id) {
        Shops shop=shopsDao.queryShopById(id);
        return shop;
    }

    @Override
    public List<Shops> queryAll() {
        List<Shops> shops = shopsDao.queryAll1();
        return shops;
    }

    @Override
    public List<Shops> queryLb() {
        List<Shops> shops=shopsDao.queryLb();
        return shops;
    }
}
