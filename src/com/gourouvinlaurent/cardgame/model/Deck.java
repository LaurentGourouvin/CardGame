package com.gourouvinlaurent.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    /**
     * Attributs
     */
    private List<PlayingCard> cards;

    /**
     * Constructor
     */
    public Deck () {
        // Je créer une collection qui vas contenir des objets de type "PlayingCard"
        cards = new ArrayList<PlayingCard>();

        // Création des 52 cartes
        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                System.out.println("Creating card [" + rank + "][" + suit + "]");
                cards.add(new PlayingCard(rank,suit));
            }
        }

        shuffle();
    }
    /**
     * Getters
     */
    public List<PlayingCard> getCards() {
        return cards;
    }

    /**
     * Methods
     */

    // Mélanger les cartes
    private void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            Collections.swap(cards, i, random.nextInt (cards.size()));
        }
    }

    // Tirer la première carte du paquet
    public PlayingCard removeTopCard() {
        return cards.remove(0);
    }
    // Remettre la carte dans le paquet
    public void returnCardToDeck(PlayingCard pc) {
        cards.add(pc);
    }
}
