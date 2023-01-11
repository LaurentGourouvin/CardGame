package com.gourouvinlaurent.cardgame.controller;

import com.gourouvinlaurent.cardgame.model.*;

import java.util.ArrayList;
import java.util.List;

class View {
    public void something(){};
    public void setController(GameController gc){}
}
public class GameController {

    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed;
    }

    Deck deck;
    List<Player> players;
    Player winner;
    View view;
    GameState gameState;

    /**
     * Constructor
     */
    public GameController(Deck deck, View view) {
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<Player>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    /**
     * Methods
     */
    public void run() {
        while(gameState == GameState.AddingPlayers) {
            view.something();
        }

        switch(gameState) {
            case CardsDealt:
                view.something();
                break;
            case WinnerRevealed:
                view.something();
                break;
        }
    }

    // Définir des joueurs
    public void addPlayer(String playerName) {
        if(gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.something();
        }
    }

    // Démarrer le jeu
    public void startGame() {
        if(gameState != GameState.CardsDealt) {
            deck.shuffle();
            for (Player player : players) {
                player.addCardToHand(deck.removeTopCard());
                view.something();
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }

    // Montrer les cartes
    public void flipCards() {
        for (Player player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.something();
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    public void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players) {
            boolean newBestPlayer = false;

            if(bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                if(thisRank > bestRank) {
                    newBestPlayer = true;
                } else {
                    if(pc.getSuit().value() > bestSuit) {
                        newBestPlayer = true;
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }
    }
    public void displayWinner() {
        view.something();
    }

    public void rebuildDeck() {
        for (Player player : players) {
            deck.returnCardToDeck(player.removeCard());
        }
    }
}
