package com.test.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
*@Author：Pandong
*@Description
*@Date:Created in 1:04 2019/4/6
*@Modified By:
*/
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=3600)
public class RedisSession {
}
