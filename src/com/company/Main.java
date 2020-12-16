package com.company;


public class Main {

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        Card[] deck = myDeck.getDeck();


        var suit = "";
        var startPosition = 0;


        for (int i = 1; i < 5; i++) {
            if (i == 1) {
                suit = "Diamond";
            } else if (i == 2) {
                suit = "Heart";
                startPosition+=13;
            } else if (i == 3) {
                suit = "Spade";
                startPosition+=13;

            } else {
                suit = "Club";
                startPosition+=13;
            }
            for (int j = 1; j < 14; j++) {
                var card = setCard(suit, Integer.toString(j));
                deck[startPosition + j - 1] = card;
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
