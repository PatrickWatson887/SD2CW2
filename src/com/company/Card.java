package com.company;

public class Card extends Deck {
    private String suit;
    private String value;

    public Card() {
    }

    public void setCard(String suit, String value) {
        this.setSuit(suit);
        this.setValue(value);
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
}
