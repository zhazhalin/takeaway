package com.qf.takeaway.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.takeaway.dao.PicDao;
import com.qf.takeaway.entity.Pic;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.PicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pic)表服务实现类
 *
 * @author makejava
 * @since 2021-07-06 11:21:49
 */
@Service("picService")
public class PicServiceImpl implements PicService {
    @Resource
    private PicDao picDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public Pic queryById(String pId) {
        return this.picDao.queryById(pId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Pic> queryAllByLimit(int offset, int limit) {
        return this.picDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Override
    public Pic insert(Pic pic) {
        this.picDao.insert(pic);
        return pic;
    }

    /**
     * 修改数据
     *
     * @param pic 实例对象
     * @return 实例对象
     */
    @Override
    public Pic update(Pic pic) {
        this.picDao.update(pic);
        return this.queryById(pic.getPId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String pId) {
        return this.picDao.deleteById(pId) > 0;
    }

    @Override
    public List<Pic> queryByType(String type) {
        return picDao.queryByType(type);
    }

    @Override
    public ResponseData queryAll(Integer offset,Integer limit) {
        if(offset==null&&limit==null){
            offset=0;
            limit=10;
        }else {
            offset=(offset-1)*limit;
        }
        List<Pic> pics=this.picDao.queryAllByLimit(offset, limit);
        Integer i=picDao.getCount();
        return new ResponseData("0","success",pics,i);
    }

    @Override
    public ResponseData delete(JSONArray arr) {
        try {
            for (int i = 0; i < arr.size(); i++) {
                picDao.deleteById((String) arr.get(i));
            }
            return  new ResponseData(ResponseCode.SUCCESS);
        }catch(Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }

    @Override
    public List<Pic> likeSelect(String value) {
        List<Pic> pics=picDao.likeSelect(value);
        return pics;
    }

    @Override
    @Transactional
    public ResponseData publish(String id, String status) {
        try {
            Integer i=picDao.publish(id,status);
            if(i>0){
                return new ResponseData(ResponseCode.SUCCESS);
            }else{
                return new ResponseData(ResponseCode.FAILED);
            }

        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResponseData(ResponseCode.FAILED);
        }
    }





}
