package limiter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Main {
	public void main(String[] args) throws Exception {
		try (var context = new AnnotationConfigApplicationContext(Config.class)) {
			RateLimiter limiter = context.getBean(RateLimiter.class);
			for (int i = 0; i < 10; i++) {
				if (limiter.isAllowed("dkumar"))
					System.out.printf("Request %d: Allowed%n", i);
				else System.out.printf("Request %d: Not Allowed%n", i);
				Thread.sleep(500);
			}
		}
	}
}
