package sii.maroc.CQRS_training_v1.services;

import sii.maroc.CQRS_training_v1.dto.AccountCreateDTO;
import sii.maroc.CQRS_training_v1.dto.MoneyCreditDTO;
import sii.maroc.CQRS_training_v1.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
        public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
        public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
        public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
