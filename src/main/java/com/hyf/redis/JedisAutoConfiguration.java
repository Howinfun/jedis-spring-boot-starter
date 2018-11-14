package com.hyf.redis;/**
 * @author howinfun
 * @date 2018/11/13
 * @company DM
 * @version 1.0
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @Desc 装配Jedis
 * @author howinfun
 * @date 2018/11/13
 * @version 1.0
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(JedisProperties.class)
public class JedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(JedisProperties jedisProperties){
        return new Jedis(jedisProperties.getIp(),jedisProperties.getPort());
    }
}
