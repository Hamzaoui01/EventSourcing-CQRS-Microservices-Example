package sii.maroc.CQRS_training_v1.events;

import sii.maroc.CQRS_training_v1.bases.BaseEvent;

public class AccountCreatedEvent extends BaseEvent<String> {
    public final double accountBalance;
    public final String currency;
    public AccountCreatedEvent(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}