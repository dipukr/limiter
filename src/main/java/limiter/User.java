package limiter;

import java.time.Instant;

public class User {
	public Instant lastRefillTime;
	public int tokenCount;
	public static User of(Instant lastRefillTime, int tokenCount) {
		User user = new User();
		user.lastRefillTime = lastRefillTime;
		user.tokenCount = tokenCount;
		return user;
	}
}
