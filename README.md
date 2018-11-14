# jedis-spring-boot-starter
1、新建一个项目
Maven项目或者Spring Initializr项目，添加下面依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
2、创建一个Properties类，获取配置
@Data是使用lombok框架，去掉getset方法
@ConfigurationProperties(prefix = "jedis")
@Data
public class JedisProperties {
    private String ip;
    private Integer port = 6379; // 默认值
}

applicatoin.properties写配置项：
#自己封装的jedis starter
jedis.ip=47.107.129.42
jedis.port=6379

3、需要一个配置类，配置类里面需要装配好需要提供出去的类
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
如果此时我们直接引入此依赖，是获取不到Jedis这个类的
注意：我的直接引入依赖不知道为啥会出错，自己处理一下

4、为了能正确的获取jedis，我们有下面两种方法：
1、使用注解，利用@Import导入需要装配的类
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JedisAutoConfiguration.class)
public @interface EnableJedisAutoConfiguratioin {
}
在springboot运行时记得添加上这个注解即可：

2、或者/META-INF/spring.factories
org.springframework.boot.autoconfigure.EnableAutoConfiguratioin配置需要装配的类
# Auto Configure 使用此方法可以自动将JedisAutoConfiguration注入到Spring容器中
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.hyf.redis.JedisAutoConfiguration
