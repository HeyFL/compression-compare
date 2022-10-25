package com.redis.cache.test.config;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class Config {

    //@Bean
    //public Jedis jedisConfig(){
    //    //连接redis服务器(在这里是连接本地的)
    //    Jedis jedis = new Jedis("10.206.46.240", 6379);
    //    //权限认证
    //    jedis.auth("Admin.123123");
    //
    //    System.out.println("连接服务成功");
    //    return jedis;
    //}

    @Bean
    public JedisPool getJedisPool(){
        RedisProperties properties = new RedisProperties();
        properties.setHost("10.206.46.240");
        properties.setPort(6379);
        properties.setPassword("Admin.123123");


        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(12);
        config.setMaxTotal(128);
        config.setMaxWaitMillis(5000);
        JedisPool pool = new JedisPool(config,properties.getHost(),properties.getPort(),3000,properties.getPassword());
        return pool;
    }
}
