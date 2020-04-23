package com.jiejie.mall.stock.config;

import com.jiejie.mall.distributed.lock.redis.RedisReentrantLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Configuration
public class LockRedisConfig {

    @Value("${distributelock.redis.host}")
    private String host;
    @Value("${distributelock.redis.port}")
    private int port;
    @Bean
    public JedisPool jedisPool(){
        return  new JedisPool(host,port);
    }
    @Bean
    public RedisReentrantLock distributedLock(){
        return new RedisReentrantLock(jedisPool(),"stockLock");
    }
}
