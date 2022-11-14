package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.skilldistillery.cardgame.Hand;

public class Deck {

	// create a list to hold cards
	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				deck.add(new Card(suit, rank));
				
			}

		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
		
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public Card dealCard(Hand hand) {
		return deck.remove(0);
	}

	@Override
	public String toString() {
		return String.format("Deck [deck=%s]", deck);
	}

	

}
