package sii.maroc.CQRS_training_v1.configurations;


import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sii.maroc.CQRS_training_v1.aggregates.AccountAggregate;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<AccountAggregate> repository = EventSourcingRepository.builder(AccountAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
