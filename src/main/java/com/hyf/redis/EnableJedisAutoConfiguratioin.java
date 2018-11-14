package com.hyf.redis;/**
 * @author howinfun
 * @date 2018/11/13
 * @company DM
 * @version 1.0
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @desc 使用@Import注解使能从spring容器中获取到JedisAutoConfiguration
 * @author howinfun
 * @date 2018/11/13
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JedisAutoConfiguration.class)
public @interface EnableJedisAutoConfiguratioin {
}
