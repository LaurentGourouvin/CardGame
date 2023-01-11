package com.gourouvinlaurent.cardgame.model;

public enum Rank {
    /**
     * Valeur des cartes
     * Association d'un entier à une valeur de carte
     */
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    JACK (10),
    QUEEN (11),
    KING (12),
    ACE (13);

    /**
     * Attributs
     */
    int rank;

    /**
     * Constructeur
     */
    private Rank(int value) {
        rank = value;
    }

    public int value() {
        return rank;
    }
}
