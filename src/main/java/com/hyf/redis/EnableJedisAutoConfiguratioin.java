package com.hyf.redis;/**
 * @author howinfun
 * @date 2018/11/13
 * @company DM
 * @version 1.0
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *
 *@author howinfun
 *@date 2018/11/13
 *@version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JedisAutoConfiguration.class)
public @interface EnableJedisAutoConfiguratioin {
}
