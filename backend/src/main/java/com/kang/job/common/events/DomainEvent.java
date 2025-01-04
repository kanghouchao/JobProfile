package com.kang.job.common.events;

import java.time.Instant;
import java.util.UUID;

/**
 * @author kanghouchao
 */
public interface DomainEvent {

    UUID getEventId();

    Instant getWhen();

}
