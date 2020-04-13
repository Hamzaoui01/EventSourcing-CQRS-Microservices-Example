package sii.maroc.CQRS_training_v1.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import sii.maroc.CQRS_training_v1.commands.CreateAccountCommand;
import sii.maroc.CQRS_training_v1.commands.CreditMoneyCommand;
import sii.maroc.CQRS_training_v1.commands.DebitMoneyCommand;
import sii.maroc.CQRS_training_v1.events.*;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String id;
    private double accountBalance;
    private String currency;
    private String status;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent){
        this.id = accountCreatedEvent.id;
        this.accountBalance = accountCreatedEvent.accountBalance;
        this.currency = accountCreatedEvent.currency;
        //this.status = String.valueOf(Status.CREATED);
        AggregateLifecycle.apply(new AccountActivatedEvent(this.id,"ACTIVATED"));
    }
    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent){
        this.status = String.valueOf(accountActivatedEvent.status);
    }
    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand){
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount, creditMoneyCommand.currency));
    }
    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent){
        if (this.accountBalance < 0 & (this.accountBalance + moneyCreditedEvent.creditAmount) >= 0){
            AggregateLifecycle.apply(new AccountActivatedEvent(this.id, "ACTIVATED"));
        }
        this.accountBalance += moneyCreditedEvent.creditAmount;
    }
    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand){
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
    }
    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent){
        if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.debitAmount) < 0){
            AggregateLifecycle.apply(new AccountHeldEvent(this.id,"HOLD"));
        }
        this.accountBalance -= moneyDebitedEvent.debitAmount;
    }
    @EventSourcingHandler
    protected void on(AccountHeldEvent accountHeldEvent){
        this.status = String.valueOf(accountHeldEvent.status);
    }
}