package com.skilldistillery.cardgame;

import java.util.ArrayList;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public abstract class Hand {
	private ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	
	public Card dealFromDeck(Deck deck){
		addCard(deck.dealCard());
        return deck.dealCard();
    }
	
	
	public void addCard(Card card){
        hand.add(card);
    }


	
	public String toString() {
		return "Hand [hand=" + hand + " ]"+ "value = " + getHandValue();
	}
	
	public abstract int getHandValue();


	public ArrayList<Card> getHand() {
		return hand;
	}


	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public Card getCard(int idx){
	    return hand.get(idx);
	}


	

	
	
	
}
