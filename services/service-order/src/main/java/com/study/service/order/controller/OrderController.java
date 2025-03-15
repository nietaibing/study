package com.study.service.order.controller;

import com.study.common.order.bean.Order;
import com.study.common.properties.OrderProperties;
import com.study.service.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderProperties orderProperties;

    @GetMapping("/getConfig")
    public String getConfig() {
        return "order.timeout: " + orderProperties.getTimeout();
    }

    /**
     * 创建订单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    @GetMapping("/create/{userId}/{productId}")
    public Order getProduct(@PathVariable("userId") String userId,
                            @PathVariable("productId") String productId) {
        return orderService.createOrder(productId, userId);
    }
}
