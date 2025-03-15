package com.study.service.order.controller;

import com.study.common.order.bean.Order;
import com.study.service.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private IOrderService orderService;

    @Autowired
    public void setProductService(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 创建订单
     *
     * @param userId    用户id
     * @param productId 商品id
     */
    @GetMapping("/create")
    public Order getProduct(@RequestParam("userId") String userId,
                            @RequestParam("productId") String productId) {
        return orderService.createOrder(productId, userId);
    }
}
