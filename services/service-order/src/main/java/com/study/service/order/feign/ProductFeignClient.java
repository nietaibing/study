package com.study.service.order.feign;


import com.study.common.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-product")
public interface ProductFeignClient {

    @GetMapping("/product/{productId}")
    Product getProductById(@PathVariable("productId") String productId);
}
