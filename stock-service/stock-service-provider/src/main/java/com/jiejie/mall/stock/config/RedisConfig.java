package com.jiejie.mall.stock.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

        @Bean
        public CacheManager cacheManager() {
            RedisCacheManager rcm = RedisCacheManager.create(redisConnectionFactory);
            return rcm;
        }

        @Bean
        public RedisTemplate<String, Object> redisTemplate() {

            RedisTemplate<String, Object> template = new RedisTemplate<>();
            // 配置连接工厂
            template.setConnectionFactory(redisConnectionFactory);

            //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
            Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

            ObjectMapper om = new ObjectMapper();
            // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jacksonSeial.setObjectMapper(om);

            // 值采用json序列化
            template.setValueSerializer(new StringRedisSerializer());
            //使用StringRedisSerializer来序列化和反序列化redis的key值
            template.setKeySerializer(new StringRedisSerializer());

            // 设置hash key 和value序列化模式
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setHashValueSerializer(jacksonSeial);
            template.afterPropertiesSet();

            return template;
        }

        @Bean
        public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
            return redisTemplate.opsForHash();
        }

        /**
         * 对redis字符串类型数据操作
         *
         * @param redisTemplate
         * @return
         */

        @Bean
        public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
            return redisTemplate.opsForValue();
        }

        /*    *
         * 对链表类型的数据操作
         *
         * @param redisTemplate
         * @return*/

        @Bean
        public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
            return redisTemplate.opsForList();
        }

        /* *
         * 对无序集合类型的数据操作
         *
         * @param redisTemplate
         * @return*/

        @Bean
        public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
            return redisTemplate.opsForSet();
        }

        /*
         * 对有序集合类型的数据操作
         *
         * @param redisTemplate
         * @return
         */
        @Bean
        public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
            return redisTemplate.opsForZSet();
        }


    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPool,
                                                         RedisClusterConfiguration jedisConfig) {
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisConfig, jedisPool);
        factory.afterPropertiesSet();
        return factory;
    }

    @Configuration
    public static class JedisConf {
        @Value("${spring.redis.cluster.nodes:127.0.0.1:7000,127.0.0.1:7001,127.0.0.1:7002}")
        private String nodes;
        @Value("${spring.redis.cluster.max-redirects:3}")
        private Integer maxRedirects;
        @Value("${spring.redis.password:}")
        private String password;
        @Value("${spring.redis.database:0}")
        private Integer database;

        @Value("${spring.redis.jedis.pool.max-active:8}")
        private Integer maxActive;
        @Value("${spring.redis.jedis.pool.max-idle:8}")
        private Integer maxIdle;
        @Value("${spring.redis.jedis.pool.max-wait:-1}")
        private Long maxWait;
        @Value("${spring.redis.jedis.pool.min-idle:0}")
        private Integer minIdle;

        @Bean
        public JedisPoolConfig jedisPool() {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWait);
            jedisPoolConfig.setMaxTotal(maxActive);
            jedisPoolConfig.setMinIdle(minIdle);
            return jedisPoolConfig;
        }

        @Bean
        public RedisClusterConfiguration jedisConfig() {
            RedisClusterConfiguration config = new RedisClusterConfiguration();

            String[] sub = nodes.split(",");
            List<RedisNode> nodeList = new ArrayList<>(sub.length);
            String[] tmp;
            for (String s : sub) {
                tmp = s.split(":");
                // fixme 先不考虑异常配置的case
                nodeList.add(new RedisNode(tmp[0], Integer.valueOf(tmp[1])));
            }

            config.setClusterNodes(nodeList);
            config.setMaxRedirects(maxRedirects);
            config.setPassword(RedisPassword.of(password));
            return config;
        }
    }

}
