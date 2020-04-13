package sii.maroc.CQRS_training_v1.dto;

import lombok.ToString;

@ToString
public class AccountCreateDTO {
    private double startingBalance;
    private String currency;

    public double getStartingBalance() {
        return this.startingBalance;
    }

    public String getCurrency() {
        return this.currency;
    }
}
