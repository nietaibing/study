package com.study.common.product.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    /**
     * id
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品介绍
     */
    private String productDesc;
    /**
     * 购买数量
     */
    private Integer num;
}
