package com.liumce.mamabike.cache;

import com.liumce.mamabike.common.constants.Parameters;
import com.liumce.mamabike.common.exception.MaMaBikeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * Create by liumce on 18/08/10
 */
@Component
@Slf4j
public class jedisPoolWrapper {

    private JedisPool jedisPool = null;

    @Autowired
    private Parameters parameters;

    @PostConstruct
    public void init() throws MaMaBikeException {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(parameters.getRedisMaxTotal());
            config.setMaxIdle(parameters.getRedisMaxIdle());
            config.setMaxWaitMillis(parameters.getRedisMaxWaitMillis());

            jedisPool = new JedisPool(config,parameters.getRedisHost(),parameters.getRedisPort(),2000,parameters.getRedisAuth());
        } catch (Exception e) {
            log.error("Fail to initialize jedis pool", e);
            throw new MaMaBikeException("Fail to initialize jedis pool");
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

}
