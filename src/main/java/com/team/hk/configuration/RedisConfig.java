package com.team.hk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by lidongliang on 2017/7/24.
 * Redis 配置文件
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 3)
public class RedisConfig {

}
