package com.study.service.product.controller;

import com.study.common.product.bean.Product;
import com.study.service.product.service.IProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private IProductService productService;

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    /**
     * 查询商品
     *
     * @param productId 商品id
     */
    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable("productId") String productId,
                              HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        System.out.println("token:" + token);
        return productService.getProductById(productId);
    }
}
