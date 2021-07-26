package com.qf.takeaway.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.takeaway.entity.Pic;
import com.qf.takeaway.result.ResponseCode;
import com.qf.takeaway.result.ResponseData;
import com.qf.takeaway.service.PicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Pic)表控制层
 *
 * @author makejava
 * @since 2021-07-06 11:21:49
 */
@Api("图片模块")
@RestController
@RequestMapping("pic")
@CrossOrigin
public class PicController {
    /**
     * 服务对象
     */
    @Resource
    private PicService picService;

    @ApiOperation(value = "query/{type}",notes = "根据图片类型查询对应的图片")
    @ApiImplicitParam(name = "type",value = "图片类型")
    @GetMapping("query/{type}")
    public ResponseData query(@PathVariable String type) {
        List<Pic> pics=this.picService.queryByType(type);
        return new ResponseData(ResponseCode.SUCCESS,pics);
    }
    @ApiOperation(value = "queryAll",notes = "查找所有的图片")
    @GetMapping("queryAll")
    public ResponseData query(Integer page,Integer limit) {
        ResponseData responseData=this.picService.queryAll(page,limit);
        return responseData;
    }
    @ApiOperation(value = "deleteById",notes = "根据图片id删除图片")
    @DeleteMapping("/delete")
    public ResponseData deleteById(@RequestBody String value) {
        JSONObject jsonObject = JSONObject.parseObject(value);
        JSONArray arr = jsonObject.getJSONArray("arr");
        return picService.delete(arr);
    }
    @ApiOperation(value = "likeSelect",notes = "根据图片id查询图片")
    @GetMapping("likeSelect/{value}")
    public ResponseData selectById(@PathVariable String value) {
        List<Pic> pics=picService.likeSelect(value);
        return new ResponseData("0","请求成功",pics);
    }
    @ApiOperation(value = "publish",notes = "根据图片id查询图片")
    @PatchMapping("publish")
    public ResponseData publish(@RequestBody String value) {
        JSONObject jsonObject=JSONObject.parseObject(value);
        String id=jsonObject.getString("id");
        String status1=jsonObject.getString("status");
        ResponseData res=picService.publish(id,status1);
        return res;

    }

}
