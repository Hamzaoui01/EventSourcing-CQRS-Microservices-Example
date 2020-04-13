package sii.maroc.CQRS_training_v1.events;

import sii.maroc.CQRS_training_v1.bases.BaseEvent;

public class AccountActivatedEvent extends BaseEvent<String> {
    public final String status;
    public AccountActivatedEvent(String id, String status) {
        super(id);
        this.status = status;
    }
}