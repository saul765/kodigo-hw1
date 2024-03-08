package domain;

import enums.CardType;

public class CreditCard {

    private String cardPan;

    private Double creditLimit;

    private CardType cardType;

    public CreditCard(String cardPan, Double creditLimit, CardType cardType) {
        this.cardPan = cardPan;
        this.creditLimit = creditLimit;
        this.cardType = cardType;
    }

    public String getCardPan() {
        return cardPan;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "- " +
                "cardPan='" + cardPan + '\'' +
                ", creditLimit=" + creditLimit +
                ", cardType=" + cardType;
    }
}
