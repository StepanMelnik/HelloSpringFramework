package com.sme.spring.mvcboot;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Component that checks that the local cache is in a valid state.
 */
@Component
class LocalCacheVerifier
{
    @Value("${cache.enabled}")
    private boolean enabledCache;

    private final ApplicationEventPublisher eventPublisher;

    LocalCacheVerifier(ApplicationEventPublisher eventPublisher)
    {
        this.eventPublisher = eventPublisher;
    }

    //@PostConstruct    <-- we cannot use PostConstruct here, because the annotation works with bean creating. And in general IOC container will not start at all.  
    void checkLocalCache()
    {
        AvailabilityChangeEvent.publish(this.eventPublisher, new RuntimeException("Waitig to start local cache"), ReadinessState.REFUSING_TRAFFIC);

        try
        {
            startCache();
        }
        catch (CacheCompletelyBroken ex)
        {
            AvailabilityChangeEvent.publish(this.eventPublisher, ex, LivenessState.BROKEN);
        }

        AvailabilityChangeEvent.publish(this.eventPublisher, new RuntimeException("Waitig to start local cache"), ReadinessState.ACCEPTING_TRAFFIC);

    }

    private void startCache() throws CacheCompletelyBroken
    {
        try
        {
            TimeUnit.MINUTES.sleep(1);
        }
        catch (InterruptedException e)
        {
            throw new CacheCompletelyBroken("Cache system cannot start!");
        }

        if (!enabledCache)
        {
            throw new CacheCompletelyBroken("Cache system should be disabled by design. Cannot start!");
        }
    }

    /**
     * Provides exception to notify a system about a broken cache.
     */
    private static class CacheCompletelyBroken extends RuntimeException
    {
        CacheCompletelyBroken(String message)
        {
            super(message);
        }
    }
}
