package eu.sample.java.spring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService2 {
	@Autowired
	private RedisTemplate<String, Pojo> redisTemplate;

	public void save(String key, Pojo value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public Pojo get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public void remove(String key) {
		redisTemplate.delete(key);
	}
}
