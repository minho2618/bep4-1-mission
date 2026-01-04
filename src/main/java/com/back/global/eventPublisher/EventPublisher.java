package com.back.global.eventPublisher;

import com.back.standard.event.HasEventName;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublisher {
    // private final ApplicationEventPublisher applicationEventPublisher; // Spring Event를 사용할때
    private final KafkaTemplate<String, Object> kafkaTemplate; // Kafka를 사용할 때

    /*public void publish(Object event) {
        applicationEventPublisher.publishEvent(event); // Spring Event를 사용할때
    }*/

    public void publish(HasEventName event) {
        kafkaTemplate.send(event.getEventName(), event); // Kafka로 이벤트를 생성
    }

}
