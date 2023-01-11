package com.gourouvinlaurent.cardgame.model;

public enum Suit {
    DIAMONDS (1),
    HEARTS (2),
    SPADES (3),
    CLUBS (4);

    /**
     * Attributs
     */
    int suit;

    /**
     * Constructor
     */
    private Suit (int value) {
        suit = value;
    }

    public int value() {
        return suit;
    }
}
