package com.practice.test.registration.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator{

	@Override
	public Health health() {
		int errorCode = checkHealth(); // Application specific health check
        if (errorCode != 0) {
        	Builder builder = Health.down();
        	builder.withDetail("Error Code", errorCode);
        	builder.withDetail("Error Description", "Just testing how it looks");
        	return builder.build();
        }
        return Health.up().build();
    }
     
    public int checkHealth() {
        // Logic to check health
        return 0;
    }
	

}
