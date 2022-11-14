package com.skilldistillery.cardgame;

import java.util.ArrayList;

import com.skilldistillery.cards.Card;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
		super();

	}

	@Override
	public int getHandValue() {
		// variable to count number of aces, and current total value
		ArrayList<Card> hand = getHand();
		int value = 0;
		int aceCount = 0;

		// For each card in this hand
		for (Card card : hand) {
			// Add the card value to the hand
			value += card.getRankValue();
			// Count how many aces have been added
			if (card.getRankValue() == 11) {
				aceCount++;
			}
		}
		// if we have a scenario where we have multiple aces, as may be the case of
		// drawing 10, followed by two or more aces, (10+11+1 > 21)
		// go back and set each ace to 1 until get back under 21, if possible
		if (value > 21 && aceCount > 0) {
			while (aceCount > 0 && value > 21) {
				aceCount--;
				value -= 10;
			}
		}
		return value;
	}

	public boolean hasBlackjack() {
		if (this.getHandValue() == 21) {
			
			return true;
		} else {
			return false;
		}

	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			System.out.println("You have gone over 21.");
			return true;

		} else {
			return false;
		}
	}

}
