package sii.maroc.CQRS_training_v1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sii.maroc.CQRS_training_v1.services.AccountQueryService;

import java.util.List;

@RestController
@RequestMapping(value = "/bank-accounts")
//@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {
    private final AccountQueryService accountQueryService;
    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }
    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);
    }
}