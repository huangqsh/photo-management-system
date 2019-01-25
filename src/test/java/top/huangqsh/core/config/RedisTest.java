package top.huangqsh.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import top.huangqsh.business.system.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate redisCacheTemplate;

    @Test
    public void get() {
        // TODO 测试线程安全
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i ->
//                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
//        );
//        stringRedisTemplate.opsForValue().set("k1", "v1");
//        final String k1 = stringRedisTemplate.opsForValue().get("k1");
//        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        //String key = "user";
        String key1 = "user1";
        User user = new User();
        user.setUsername("zzk123");
        user.setUserId(123);
        List<User> list = new ArrayList<>();
        list.add(user);
        //redisCacheTemplate.opsForValue().set(key, user, Duration.ofMinutes(1));
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();

        redisCacheTemplate.opsForValue().set(key1, list, Duration.ofMinutes(1));
        //log.error("将对象转成json字符串失败:{}", e.getMessage());

        // TODO 对应 String（字符串）
        final List<User> list1 = (List) redisCacheTemplate.opsForValue().get(key1 + "123");
        log.info("[对象缓存结果] - [{}]", list1);
    }
}
