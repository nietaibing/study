package com.study.service.product.service.impl;

import com.study.common.product.bean.Product;
import com.study.service.product.service.IProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public Product getProductById(String productId) {
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("苹果-" + productId);
        product.setProductPrice(new BigDecimal(99));
        product.setProductDesc("");
        product.setNum(2);
        return product;
    }
}
