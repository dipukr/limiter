package limiter;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class LeakyBucket implements Limiter {

	private Map<String, User> userData = new ConcurrentHashMap<>();
	private int bucketCapacity;
	private int leakRate;
	
	public LeakyBucket(int bucketCapacity, int leakRate) {
		this.bucketCapacity = bucketCapacity;
		this.leakRate = leakRate;
	}

	@Override
	public boolean isAllowed(String userId) {
		userData.putIfAbsent(userId, User.of(Instant.now(), bucketCapacity));
		bucketCapacity = 10;
		System.out.println(leakRate);
		boolean isAllowed = false;
		return isAllowed;
	}
}
















