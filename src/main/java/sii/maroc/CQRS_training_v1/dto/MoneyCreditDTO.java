package sii.maroc.CQRS_training_v1.dto;

public class MoneyCreditDTO {
    private double creditAmount;
    private String currency;

    public double getCreditAmount() {
        return this.creditAmount;
    }

    public String getCurrency() {
        return this.currency;
    }
}
