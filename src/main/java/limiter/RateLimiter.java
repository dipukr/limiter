package limiter;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component
public class RateLimiter {

	@Autowired
	private Limiter limiter;

	public boolean isAllowed(String id) {
		return limiter.isAllowed(id);
	}
}
