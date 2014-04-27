package eu.sample.java.spring.redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void save(String key, String value) {
		this.stringRedisTemplate.opsForValue().set(key, value);
	}

	public String get(String key) {
		return this.stringRedisTemplate.opsForValue().get(key);
	}

	public void remove(String key) {
		this.stringRedisTemplate.delete(key);
	}
}
