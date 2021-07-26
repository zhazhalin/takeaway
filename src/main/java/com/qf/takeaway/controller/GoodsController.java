package com.qf.takeaway.controller;

import com.qf.takeaway.entity.Goods;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.GoodsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2021-07-06 16:31:52
 */
@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 查询所有食物
     *
     * @return 单条数据
     */
    @ApiOperation(value = "queryGoodsByName",notes = "查询所有食物")
    @ApiImplicitParam(name = "name",value = "商品名称")
    @GetMapping("queryGoodsByName/{name}")
    public ResponseData queryGoodsByName(@PathVariable String name) {
        List<Goods> goods = this.goodsService.queryGoodsByName(name);
        return new ResponseData(ResponseCode.SUCCESS,goods);
    }
    /**
     * 根据商家id查找对应的商品信息
     *
     * @return 单条数据
     */
    @ApiOperation(value = "queryGoodsBySid",notes = "根据商家id查找对应的商品信息")
    @ApiImplicitParam(name = "id",value = "商家id")
    @GetMapping("queryGoodsBySid/{id}")
    public ResponseData queryGoodsBySid(@PathVariable String id) {
        List<Goods> goods = this.goodsService.queryGoodsBySid(id);
        return new ResponseData(ResponseCode.SUCCESS,goods);
    }

    @ApiOperation(value = "queryByClassify",notes = "根据商家分类查找对应的商品信息")
    @ApiImplicitParam(name = "item",value = "商家id")
    @GetMapping("queryByClassify/{item}")
    public ResponseData queryByClassify(@PathVariable String item) {
        List<HashMap<String, Object>> maps = this.goodsService.queryByClassify(item);
        return new ResponseData(ResponseCode.SUCCESS,maps);
    }
    @ApiOperation(value = "queryAllByLimit",notes = "查询所有食物")
    @GetMapping("queryAllByLimit")
    public ResponseData queryAllByLimit(Integer page,Integer limit) {
        ResponseData responseData = this.goodsService.queryAllByLimit(page,limit);
        return responseData;
    }
    @ApiOperation(value = "selectById",notes = "根据id查询食物")
    @GetMapping("selectById/{gid}")
    public ResponseData selectById(@PathVariable String gid) {
        Goods good = this.goodsService.queryById(gid);
        return new ResponseData("0","操作成功",good);
    }
}
