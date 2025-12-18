package limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class SlidingWindowLog implements Limiter {

	private Map<String, User> userData = new ConcurrentHashMap<>();
	
	public SlidingWindowLog() {
		
	}

	
	@Override
	public boolean isAllowed(String userId) {
		System.out.println(userData);
		boolean isAllowed = false;
		return isAllowed;
	}
}