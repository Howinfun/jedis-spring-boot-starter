package com.hyf.redis;/**
 * @author howinfun
 * @date 2018/11/13
 * @company DM
 * @version 1.0
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author howinfun
 * @date 2018/11/13
 * @version 1.0
 *  备注：
 *   1.@ConfigurationProperties
 *      将application.properties配置文件中的
 *      符合规则的配置参数映射到实体类中
 *   2.preffix，该属性配置了读取参数的前缀
 */
@ConfigurationProperties(prefix = "jedis")
@Data
public class JedisProperties {
    private String ip;
    private Integer port = 6379; // 默认值
}
