package com.kang.job.common.events;

import java.util.List;

/**
 * @author kanghouchao
 */
public interface DomainEvents {

    void publish(DomainEvent event);

    default void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }
}
