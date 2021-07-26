package com.qf.takeaway.controller;

import com.qf.takeaway.entity.Orderlist;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.OrderlistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderlist)表控制层
 *
 * @author makejava
 * @since 2021-07-10 16:01:05
 */
@RestController
@RequestMapping("orderlist")
@CrossOrigin
public class OrderlistController {
    /**
     * 服务对象
     */
    @Resource
    private OrderlistService orderlistService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiOperation(value = "queryAll",notes = "查询所有订单信息")
    @GetMapping("queryAll")
    public ResponseData queryAll() {
        List<Orderlist> orderList = this.orderlistService.queryAll();
        return new ResponseData("0","操作成功",orderList);
    }

}
