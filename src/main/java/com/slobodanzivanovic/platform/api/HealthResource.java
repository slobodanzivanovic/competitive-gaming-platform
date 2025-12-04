package com.slobodanzivanovic.platform.api;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

/**
 * A resource class for providing application health checks.
 *
 * <p>K8s uses these endpoints to determine if the pod is alive and ready to
 * receive traffic. This implementation always returns a successful ("UP") response,
 * indicating that the application is running and ready to handle requests.
 *
 * @author Slobodan Zivanovic
 * @since 1.0.0
 */
@Readiness
@Liveness
@ApplicationScoped
public class HealthResource implements HealthCheck {

    /**
     * Performs a health check on the application.
     *
     * @return A {@link HealthCheckResponse} indicating that the application is health and running, with the service
     * name "competitive-gaming-platform"
     */
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("competitive-gaming-platform")
            .withData("status", "UP")
            .up()
            .build();
    }
}
