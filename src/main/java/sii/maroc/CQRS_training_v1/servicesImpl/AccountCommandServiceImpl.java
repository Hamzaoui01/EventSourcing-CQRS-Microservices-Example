package sii.maroc.CQRS_training_v1.servicesImpl;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sii.maroc.CQRS_training_v1.commands.CreateAccountCommand;
import sii.maroc.CQRS_training_v1.commands.CreditMoneyCommand;
import sii.maroc.CQRS_training_v1.commands.DebitMoneyCommand;
import sii.maroc.CQRS_training_v1.dto.AccountCreateDTO;
import sii.maroc.CQRS_training_v1.dto.MoneyCreditDTO;
import sii.maroc.CQRS_training_v1.dto.MoneyDebitDTO;
import sii.maroc.CQRS_training_v1.services.AccountCommandService;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        String id = UUID.randomUUID().toString();
        System.out.println("-------- Id :"+id);
        return commandGateway.send(new CreateAccountCommand(id, accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}
