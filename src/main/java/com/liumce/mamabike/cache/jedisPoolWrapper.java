package com.liumce.mamabike.cache;

import com.liumce.mamabike.common.constants.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Create by liumce on 18/08/10
 */
@Component
@Slf4j
public class jedisPoolWrapper {

    private JedisPool jedisPool = null;

    @Autowired
    private Parameters parameters;

    public void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(parameters.getRe);
    }

    public JedisPool getJedisPool(){return jedisPool;}
}
