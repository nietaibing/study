package com.study.service.order.service;

import com.study.common.order.bean.Order;

public interface IOrderService {

    Order createOrder(String productId, String userId);
}
