package com.study.common.order.bean;

import com.study.common.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {
    /**
     * id
     */
    private String orderId;
    /**
     * 订单总额
     */
    private BigDecimal totalAmount;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 派送地址
     */
    private String address;
    /**
     * 商品列表
     */
    private List<Product> products;
}
