package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.username}")
    private String redisUsername;

    @Value("${redis.database}")
    private int redisDatabase;

    @Value("${redis.isAuth}")
    private boolean redisAuth;

    //Config for jedis
    @Bean
    public Jedis jedis() {
        try (JedisPool jedisPool = redisAuth ? new JedisPool(redisHost, redisPort, redisUsername, redisPassword) : new JedisPool(redisHost, redisPort)) {
            Jedis jedis = jedisPool.getResource();
            jedis.select(redisDatabase);
            return jedis;
        }
    }

}