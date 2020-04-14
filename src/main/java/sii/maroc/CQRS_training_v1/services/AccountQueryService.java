package sii.maroc.CQRS_training_v1.services;

import sii.maroc.CQRS_training_v1.entities.AccountQueryEntity;

import java.util.List;

public interface AccountQueryService {
        public List<Object> listEventsForAccount(String accountNumber);
        public AccountQueryEntity getAccount(String accountNumber);
}
