package com.cs3750.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cs3750.game.Card.Ranking;

public class Dealer {

    public static int MIDDLE_LIMIT = 2;
    List<Card> middleCur = new ArrayList<>();
    List<Card> middleOld = new ArrayList<>();
    List<Card> playerOneCards, playerTwoCards;
    Deck deck;
    Player playerA, playerB;


    public Dealer(Deck deck) {
        this.deck = deck;
        Deck.shuffle(this.deck);

        playerOneCards = new ArrayList<>();
        playerTwoCards = new ArrayList<>();

        for (int i = 0; i < MIDDLE_LIMIT; i++) {
            middleCur.set(i, this.deck.popDeck());
        }
        
        for (Card card: middleCur) {
        	middleOld.add(card);
        }

        halfDeck(this.deck.getDeck(), playerOneCards, playerTwoCards);

        this.playerA = new Player(playerOneCards);
        this.playerB = new Player(playerTwoCards);

    }

    public static void halfDeck(List<Card> cards, List<Card> first, List<Card> second) {

        for (int i = cards.size() - 1; i >= 0 ; i--) {
            if (i % 2 == 0) {
                first.add(cards.remove(cards.size() - 1));
            } else {
                second.add(cards.remove(cards.size() - 1));
            }
        }
    }

    public void replaceMiddleCards() {
        middleCur = new ArrayList<>();
        Card temp = this.playerA.popMiddleSide();
        if (temp != null) {
            middleCur.set(0, temp);
            middleCur.set(1, this.playerB.popMiddleSide());
        }
    }

    
    
    public List<Card> getMiddleCur() {
		return middleCur;
	}

	public void setMiddleCur(List<Card> middleCur) {
		this.middleCur = middleCur;
	}

	public List<Card> getMiddleOld() {
		return middleOld;
	}

	public void setMiddleOld(List<Card> middleOld) {
		this.middleOld = middleOld;
	}

    public List<Card> getPlayerOneCards() {
        return playerOneCards;
    }

    public void setPlayerOneCards(List<Card> playerOneCards) {
        this.playerOneCards = playerOneCards;
    }

    public List<Card> getPlayerTwoCards() {
        return playerTwoCards;
    }

    public void setPlayerTwoCards(List<Card> playerTwoCards) {
        this.playerTwoCards = playerTwoCards;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getPlayerAName() {
        return playerA.getName();
    }

    public void setPlayerAName(String name) {
        this.playerA.setName(name); 
    }

    public String getPlayerBName() {
        return playerB.getName();
    }

    public void setPlayerBName(String name) {
        this.playerB.setName(name); 
    }

    public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

	// boolean[] can be replaced by a specific type of Message once the Message factory is done.
    public boolean[] playerRequestToCoverCard(Player player, Card cardFromPlayer,
                                            int value ) {
        // results[0]: if there's any change
        // results[1]: if the player is winning.
    	// results[2]: if the middle cards need to be replaced
        boolean[] results = new boolean[3];
        Card target =  new Card(Ranking.values()[value - 1]);
        if (middleCur.contains(target)) {
        	if (cardFromPlayer.isNeighbor(target)) {
        		player.removeHandCard(cardFromPlayer);
        		middleCur.remove(target);
        		middleCur.add(cardFromPlayer);
        		results[0] = true;
                if (player.getCardsOnHand().size() == 0 && player.getCardsOnSide().size() == 0) {
                    results[1] = true;
                }
        	}
        }
        
        results[3] = solveStuck();

        return results;
    }

    public boolean solveStuck() {
		
    	for (Card card: playerA.getCardsOnHand()) {
    		if (card.isNeighbor(middleCur.get(0))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    			return false;
    		};
    		if (card.isNeighbor(middleCur.get(1))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    			return false;
    		};
    	}	
    	
    	for (Card card: playerB.getCardsOnHand()) {
    		if (card.isNeighbor(middleCur.get(0))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    			return false;
    		};
    		if (card.isNeighbor(middleCur.get(1))) {
    	    	middleOld.set(0, middleCur.get(0));
    	    	middleOld.set(1, middleCur.get(1));
    			return false;
    		};
    	}
    	
    	middleOld.set(0, middleCur.get(0));
    	middleOld.set(1, middleCur.get(1));
    	
    	middleCur.set(0, getPlayerA().popMiddleSide());
    	middleCur.set(1, getPlayerB().popMiddleSide());
    	
    	return true;
    }
    
    public static void main(String[] args) {

        Deck deck = new Deck(1);
        Dealer dealer = new Dealer(deck);
        System.out.println(dealer.getMiddle());
        System.out.println(dealer.getPlayerA().getCardsOnHand());
        System.out.println(dealer.getPlayerB().getCardsOnHand());
        System.out.println(dealer.getPlayerA().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerB().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerA().getCardsOnSide());
        System.out.println(dealer.getPlayerB().getCardsOnSide());
        System.out.println("Deck: " + dealer.getDeck().getDeck());
        dealer.replaceMiddleCards();
        System.out.println(dealer.getPlayerA().getCardsOnMiddleSide());
        System.out.println(dealer.getPlayerB().getCardsOnMiddleSide());
        System.out.println(dealer.getMiddle());
        dealer.replaceMiddleCards();
        dealer.getPlayerA().flipCardToOnHand();
    }
}
