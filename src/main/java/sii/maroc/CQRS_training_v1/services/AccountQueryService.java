package sii.maroc.CQRS_training_v1.services;

import java.util.List;

public interface AccountQueryService {
        public List<Object> listEventsForAccount(String accountNumber);
}
