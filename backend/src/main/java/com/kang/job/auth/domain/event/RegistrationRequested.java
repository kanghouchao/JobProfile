package com.kang.job.auth.domain.event;

import com.kang.job.common.events.DomainEvent;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

/**
 * @author kanghouchao
 */
@Value
public class RegistrationRequested implements DomainEvent {

    @Override
    public UUID getEventId() {
        return null;
    }

    @Override
    public Instant getWhen() {
        return null;
    }
}
