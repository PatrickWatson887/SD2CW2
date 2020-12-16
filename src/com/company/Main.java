package com.company;

public class Main {

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        Card[] deck = myDeck.getDeck();

        var suit = "";
        for (int i = 1; i < 5; i++) {
            if (i == 1) {
                suit = "Diamond";
            } else if (i == 2) {
                suit = "Heart";
            } else if (i == 3) {
                suit = "Spade";
            } else {
                suit = "Club";
            }
            for (int j = 1; j < 14; j++) {
                var card = setCard(suit, Integer.toString(j));
                deck[i*j-1] = card;
            }
        }
        for (Card card : deck) {
            if (card != null) {
                System.out.println(card.getValue() + card.getSuit());
            }
        }
    }

    public static Card setCard(String suit, String value) {
        Card newCard = new Card();
        newCard.setCard(suit, value);
        return newCard;

    }
}
