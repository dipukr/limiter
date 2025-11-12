package limiter;

public interface Limiter {
	boolean isAllowed(String userId);
}
