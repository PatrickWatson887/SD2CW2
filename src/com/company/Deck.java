package com.company;

public class Deck<C> {

    private C[] deck;
    private static final int NUMBER_OF_CARDS = 52;


    public Deck() {
        this(NUMBER_OF_CARDS);
    }

    public Deck(int capacity) {
        C[] tempDeck = (C[]) new Object[capacity];
        deck = tempDeck;
    }

    public void setCards() {
        var suit = "";
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                suit = "Diamond";
            } else if (i == 1) {
                suit = "Heart";
            } else if (i == 2) {
                suit = "Spade";
            } else {
                suit = "Club";
            }
            for (int j = 0; j < 13; j++) {
                new Card(suit, Integer.toString(j));
            }
        }
    }

    public void addNewEntry(C newEntry, int position) {
        deck[position] = newEntry;

    }
}
