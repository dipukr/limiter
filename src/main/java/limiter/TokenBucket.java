package limiter;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class TokenBucket implements Limiter {
	
	private Map<String, User> userData = new ConcurrentHashMap<>();
	private int bucketCapacity;
	private int refillRate;
	
	public TokenBucket(int bucketCapacity, int refillRate) {
		this.bucketCapacity = bucketCapacity;
		this.refillRate = refillRate;
	}

	@Override
	public boolean isAllowed(String userId) {
		Instant now = Instant.now();
		userData.putIfAbsent(userId, User.of(now, bucketCapacity));
		User user = userData.get(userId);
		long seconds = Duration.between(user.lastRefillTime, now).toSeconds();
		int newTokens = (int) seconds * refillRate;
		user.tokenCount = Math.min(bucketCapacity, user.tokenCount + newTokens);
		boolean isAllowed = user.tokenCount > 0;
		if (isAllowed) {
			user.tokenCount -= 1;
			user.lastRefillTime = now;
		}
		return isAllowed;
	}
}
