package com.study.service.product.service.impl;

import com.study.common.product.bean.Product;
import com.study.service.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {
    @Override
    public Product getProductById(String productId) {
        log.info("get product by id, id is {}", productId);
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName("苹果-" + productId);
        product.setProductPrice(new BigDecimal(99));
        product.setProductDesc("");
        product.setNum(2);
        try {
            TimeUnit.SECONDS.sleep(100000);
        } catch (InterruptedException e) {
            log.error("sleep error", e);
            throw new RuntimeException(e);
        }
        return product;
    }
}
