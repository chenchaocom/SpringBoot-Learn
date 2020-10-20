package com.opglabel.springboot.lab07;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws IOException {
        String scriptContents = IOUtils.toString(getClass().getResourceAsStream("/lua/compareAndSet.lua"), "UTF-8");
        DefaultRedisScript<Long> script = new DefaultRedisScript<>(scriptContents, Long.class);

        Long result = stringRedisTemplate.execute(script, Collections.singletonList("yunai:1"), "shuai", "shuai");

        System.out.println(result);

    }

    @Test
    public void test02() throws IOException {
        String scriptContents = IOUtils.toString(getClass().getResourceAsStream("/lua/test.lua"), "UTF-8");

        DefaultRedisScript<List> script = new DefaultRedisScript<>(scriptContents, List.class);

        List result = stringRedisTemplate.execute(script, Arrays.asList("keys1", "keys2"), "first", "second");

        System.out.println(result);
    }

}
