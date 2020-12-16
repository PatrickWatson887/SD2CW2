package com.company;

import java.util.Random;

public class Deck {

    private Card[] deck;
    private static final int NUMBER_OF_CARDS = 52;


    public Deck() {
        this(NUMBER_OF_CARDS);
    }

    public Deck(int capacity) {
        deck = new Card[capacity];
    }


    public Card[] getDeck() {
        return deck;
    }
}
