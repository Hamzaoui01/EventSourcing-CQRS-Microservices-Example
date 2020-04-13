package sii.maroc.CQRS_training_v1.commands;


import sii.maroc.CQRS_training_v1.bases.BaseCommand;

public class DebitMoneyCommand extends BaseCommand<String> {
    public final double debitAmount;
    public final String currency;
    public DebitMoneyCommand(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}