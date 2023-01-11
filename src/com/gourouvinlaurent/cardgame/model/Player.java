package com.gourouvinlaurent.cardgame.model;

public class Player {
    /**
     * Attributs
     */
    private String name;
    private Hand hand;

    /**
     * Constructor
     */
    public Player(String name) {
        super();
        this.name = name;
        hand = new Hand();
    }

    /**
     * Getters
     */
    public PlayingCard getCard(int index) {
        return hand.getCard(index);
    }

    /**
     * Methods
     */
    public void addCardToHand(PlayingCard pc) {
        hand.addCard(pc);
    }

    public PlayingCard removeCard() {
        return hand.removeCard();
    }

}
