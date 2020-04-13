package sii.maroc.CQRS_training_v1.servicesImpl;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;
import sii.maroc.CQRS_training_v1.services.AccountQueryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {
    private final EventStore eventStore;
    public AccountQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }
    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }
}
