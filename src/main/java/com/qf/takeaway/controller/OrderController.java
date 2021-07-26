package com.qf.takeaway.controller;

import com.qf.takeaway.entity.Order;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-07-06 15:38:44
 */
@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiOperation(value = "createOrder",notes = "新增订单信息")
    @PostMapping("createOrder")
    public ResponseData createOrder(@RequestBody Order order) {
        Order order1 = this.orderService.insert(order);
        return new ResponseData(ResponseCode.SUCCESS,order1.getoId());
    }

    @ApiOperation(value = "updateStatusById",notes = "更新订单状态")
    @GetMapping("updateStatusById/{oid}")
    public ResponseData createOrder(@PathVariable String oid) {
        Integer status = this.orderService.updateStatusById(oid);
        return new ResponseData(ResponseCode.SUCCESS,status);
    }
    @ApiOperation(value = "queryByNick",notes = "根据用户昵称获取订单信息")
    @GetMapping("queryByNick/{nickname}")
    public ResponseData queryByNick(@PathVariable String nickname) {
        List<Order> orders = this.orderService.queryByNick(nickname);
        return new ResponseData(ResponseCode.SUCCESS,orders);
    }
    @ApiOperation(value = "queryAll",notes = "根据用户昵称获取订单信息")
    @GetMapping("queryAll")
    public ResponseData queryByNick() {
        List<Order> orders = this.orderService.queryAll();
        return new ResponseData("0","请求成功",orders);
    }
    @ApiOperation(value = "selectById",notes = "根据订单号查询订单信息")
    @GetMapping("selectById/{oid}")
    public ResponseData selectById(@PathVariable String oid) {
        Order order = this.orderService.queryById(oid);
        return new ResponseData("0","请求成功",order);
    }
}
