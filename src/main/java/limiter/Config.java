package limiter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Limiter limiter() {
		return new TokenBucket(5, 2);
	}

	@Bean
	public RateLimiter rateLimiter() {
		return new RateLimiter();
	}
}
