package com.rong.controller;

import com.rong.entity.Order;
import com.rong.service.IOrderService;
import com.rong.service.WxPayService;
import com.rong.utils.JsonResult;
import com.rong.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@CrossOrigin //跨域
@RestController
@RequestMapping("orders")
@Api(tags =  "网站微信支付API")
@Slf4j
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @Resource
    private WxPayService wxPayService;

    @ApiOperation("订单发起")
    @PostMapping("native/{oid}")
    public JsonResult<Map<String , Object>> nativePay(@PathVariable Integer oid){
        log.info("发起支付请求");
        Map<String , Object> map = null;
        try {
            map = wxPayService.nativePay(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult<Map<String , Object>>(200,map);
    }

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.create(aid, cids, uid, username);
        // 返回成功与数据
        return new JsonResult<Order>(OK, data);
    }
    @RequestMapping("deleteByUidAndPid")
    public JsonResult<Order> deleteByUidAndCid( Integer pid, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.deleteByUidAndCid(uid,pid);
        // 返回成功与数据
        return new JsonResult<Order>(OK, data);
    }
    @RequestMapping("findOrder")
    public JsonResult<List<OrderVO>> findOrder( HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        List<OrderVO> data = orderService.findOrder(uid);
        // 返回成功与数据
        return new JsonResult<List<OrderVO>>(OK, data);
    }
}
