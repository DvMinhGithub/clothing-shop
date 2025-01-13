package com.example.demo.cronjob.task;

import com.example.demo.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
@Slf4j
public class ProductTask {
    private final ProductMapper productMapper;

    private final Jedis jedis;

    public ProductTask(ProductMapper productMapper, Jedis jedis) {
        this.productMapper = productMapper;
        this.jedis = jedis;
    }

    public void updateProductView() {
        log.info("Start scheduled task: updateProductView");
//        productMapper.updateProductView();
        log.info("End scheduled task: updateProductView");
    }
}
