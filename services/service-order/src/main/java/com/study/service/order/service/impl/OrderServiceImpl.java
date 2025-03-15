package com.study.service.order.service.impl;

import com.study.common.order.bean.Order;
import com.study.common.product.bean.Product;
import com.study.service.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Order createOrder(String productId, String userId) {
        Product product = getProductFromRemote(productId);
        Order order = new Order();
        order.setOrderId("1");
        order.setTotalAmount(product.getProductPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId("userId");
        order.setNickName("秦人京客");
        order.setAddress("杭州市萧山区");
        order.setProducts(List.of(product));
        return order;
    }

    private Product getProductFromRemote(String productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.getFirst();
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + productId;
        log.info("远程请求：{}", url);
        return restTemplate.getForObject(url, Product.class);
    }
}
