package com.example.aoptest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @PROJECT_NAME: AopTest
 * @DESCRIPTION:
 * @USER: ejchen
 * @DATE: 2022/9/10 15:41
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void redis1() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.opsForValue().set("user", "zhangsang1");
        Object user = redisTemplate.opsForValue().get("user");
        System.out.println(user.toString());
    }
}
