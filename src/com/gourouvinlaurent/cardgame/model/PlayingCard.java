package com.gourouvinlaurent.cardgame.model;

public class PlayingCard {
    /**
     * Attributs
     */
    private Rank rank;
    private Suit suit;
    private boolean faceUp;

    /**
     * Constructor
     */
    public PlayingCard(Rank rank, Suit suit){
        super();
        this.rank = rank;
        this.suit = suit;
    }
    /**
     * Getters
     */
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }
    public boolean isFaceUp() {
        return faceUp;
    }

    /**
     * Methods
     */
    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
}
