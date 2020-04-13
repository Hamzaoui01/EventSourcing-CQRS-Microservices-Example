package sii.maroc.CQRS_training_v1.dto;

public class MoneyDebitDTO {
    private  double debitAmount;
    private String currency;

    public double getDebitAmount() {
        return this.debitAmount;
    }

    public String getCurrency() {
        return this.currency;
    }
}
