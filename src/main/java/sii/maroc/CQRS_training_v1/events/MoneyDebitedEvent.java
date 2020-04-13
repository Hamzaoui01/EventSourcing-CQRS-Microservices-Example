package sii.maroc.CQRS_training_v1.events;

import sii.maroc.CQRS_training_v1.bases.BaseEvent;

public class MoneyDebitedEvent extends BaseEvent<String> {
    public final double debitAmount;
    public final String currency;
    public MoneyDebitedEvent(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
