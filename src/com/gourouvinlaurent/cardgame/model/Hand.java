package com.gourouvinlaurent.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    /**
     * Attributs
     */
    private List<PlayingCard> cards;

    /**
     * Constructor
     */
    public Hand() {
        cards = new ArrayList<PlayingCard>();
    }

    /**
     * Getters
     */
    public PlayingCard getCard(int index) {
        return cards.get(index);
    }

    /**
     * Methods
     */
    public void addCard(PlayingCard pc) {
        cards.add(pc);
    }

    public PlayingCard removeCard() {
        return cards.remove(0);
    }

}
