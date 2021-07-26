package com.qf.takeaway.service.impl;

import com.qf.takeaway.entity.Goods;
import com.qf.takeaway.dao.GoodsDao;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.GoodsService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2021-07-06 16:31:52
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(String gId) {
        return this.goodsDao.queryById(gId);
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
        List<Goods> goodsList=this.goodsDao.queryAllByLimit(offset, limit);
        Integer i=goodsDao.getCount();
        return new ResponseData("0","success",goodsList,i);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        this.goodsDao.update(goods);
        return this.queryById(goods.getgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer gId) {
        return this.goodsDao.deleteById(gId) > 0;
    }

    @Override
    public List<Goods> queryGoodsByName(String name) {
        List<Goods> goods= goodsDao.queryGoodsByName(name);
        return goods;
    }

    @Override
    public List<Goods> queryGoodsBySid(String sid) {
        List<Goods> goods=goodsDao.queryGoodsBySid(sid);
        return goods;
    }
    public List<HashMap<String,Object>> queryByClassify(String sid){
        List<String> classifys=goodsDao.classify(sid);
        List<Goods> goods=goodsDao.queryGoodsBySid(sid);
        List<HashMap<String,Object>> maps=new ArrayList<>();
        for(String classify:classifys){
            HashMap<String,Object> map=new HashMap<>();
            List<Goods> goods1=new ArrayList<>();
            for(int i=0;i<goods.size();i++){
                if(goods.get(i).getClassifyname().equalsIgnoreCase(classify)){
                    goods.get(i).setgId(String.valueOf(i));
                    goods1.add(goods.get(i));
                }
            }
            map.put("classifyName",classify);
            map.put("goods",goods1);
            maps.add(map);
        }
        return maps;
    }

    @Override
    public List<Goods> queryAll() {
        List<Goods> goods=goodsDao.queryAll1();
        return goods;
    }
}
