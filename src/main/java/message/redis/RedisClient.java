package message.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisClient {

    private RedisTemplate redisTemplate;

    @Autowired
    public RedisClient(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        this.redisTemplate = redisTemplate;
    }

    /**
     * 添加ZSET缓存
     */
    public void zAdd(String key, Object obj, double score) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(key, obj, score);
    }

    /**
     * 获取ZSET缓存
     */
    public Set<Object> zRange(String key, long start, long end) {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        Set<Object> range = zSetOperations.range(key, start, end);
        return range;
    }


    public void sendEvent(String event, String json) {
        redisTemplate.convertAndSend(event, json);
    }

}
