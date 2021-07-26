package com.qf.takeaway.controller;

import com.qf.takeaway.entity.Shops;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.ShopsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shops)表控制层
 *
 * @author makejava
 * @since 2021-07-06 10:39:23
 */
@RestController
@RequestMapping("shops")
@CrossOrigin
public class ShopsController {
    /**
     * 服务对象
     */
    @Resource
    private ShopsService shopsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "selectById",notes = "根据商家id查询商家信息")
    @ApiParam(name = "sid",value = "商家id")
    @GetMapping("selectById/{id}")
    public Shops selectById(@PathVariable String id) {
        return this.shopsService.queryById(id);
    }

    @ApiOperation(value = "queryByTitle",notes = "根据餐馆类型进行查询")
    @ApiParam(name = "type",value = "餐馆类型")
    @PostMapping("/queryByTitle/{title}")
    public ResponseData queryByTitle(@PathVariable String title) {
        List<Shops> shops=this.shopsService.queryByTitle(title);
        return new ResponseData(ResponseCode.SUCCESS,shops);
    }
    @ApiOperation(value = "queryById",notes = "根据图片id查询对应的餐馆")
    @ApiImplicitParam(name = "id",value = "轮播图片id")
    @GetMapping("queryById/{id}")
    public ResponseData queryById(@PathVariable String id) {
        Shops shop =this.shopsService.queryShopById(id);
        return new ResponseData(ResponseCode.SUCCESS,shop);
    }

    @ApiOperation(value = "queryAllByLimit",notes = "分页查询获取所有商家信息")
    @GetMapping("queryAllByLimit")
    public ResponseData queryAllByLimit(Integer page,Integer limit) {
        ResponseData responseData= shopsService.queryAllByLimit(page,limit);
        return responseData;
    }
    @ApiOperation(value = "queryLb",notes = "查询轮播图餐馆")
    @GetMapping("queryLb")
    public ResponseData queryLb() {
        List<Shops> shops =this.shopsService.queryLb();
        return new ResponseData(ResponseCode.SUCCESS,shops);
    }
}
