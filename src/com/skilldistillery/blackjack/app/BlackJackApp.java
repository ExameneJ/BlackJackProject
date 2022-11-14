package com.skilldistillery.blackjack.app;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	private Dealer dealer;
	private Player player;
	Hand dealerHandHand = new BlackJackHand();
	Hand playerHand = new BlackJackHand();
	Scanner scanner = new Scanner(System.in);
	Deck testDeck = new Deck();

	public static void main(String[] args) {
		BlackJackApp gameApp = new BlackJackApp();
		gameApp.startRound();

	}

	public void startRound() {

		testDeck.shuffleDeck();
		// Create the People
		dealer = new Dealer();
		player = new Player();

		dealerHandHand.addCard(dealer.getHand().dealFromDeck(testDeck));
		dealerHandHand.addCard(dealer.getHand().dealFromDeck(testDeck));

		System.out.println("Dealer card = " + dealerHandHand.getCard(0));

		playerHand.addCard(player.getHand().dealFromDeck(testDeck));
		playerHand.addCard(player.getHand().dealFromDeck(testDeck));

		System.out.println("Player = " + playerHand.toString());

		if (((BlackJackHand) dealerHandHand).hasBlackjack()) {

			if (((BlackJackHand) playerHand).hasBlackjack()) {
				System.out.println("You both have 21 - Push.");

			} else {
				System.out.println("Dealer has BlackJack. You lose.");
				System.out.println(dealerHandHand.toString());

			}
		}
		if (((BlackJackHand) playerHand).hasBlackjack()) {
			System.out.println("You have Blackjack! You win!");

		}
		if (!((BlackJackHand) dealerHandHand).hasBlackjack() && !((BlackJackHand) playerHand).hasBlackjack()) {
			System.out.println();
			startDecision();

		}

	}

	public void startDecision() {
		boolean isContinue = true;
		int hitOrStand = 0;
		while (isContinue) {
			System.out.println("Would you like to: 1) Hit or 2) Stand");
			hitOrStand = scanner.nextInt();
			if (hitOrStand == 1) {
				playerHand.addCard(player.getHand().dealFromDeck(testDeck));
				System.out.println("Player = " + playerHand.toString());
				System.out.println();
				if (((BlackJackHand) playerHand).hasBlackjack()) {
					break;
				}
				if (((BlackJackHand) playerHand).isBust()) {
					System.out.println("You busted");
					break;

				}

			} else {
				isContinue = false;
				checkDealerDecisionWinner();
			}

		}

	}

	public void checkDealerDecisionWinner() {
		System.out.println(dealerHandHand.toString());
		while (dealerHandHand.getHandValue() < 17) {
			dealerHandHand.addCard(dealer.getHand().dealFromDeck(testDeck));
			System.out.println(dealerHandHand.toString());

		}
		if (((BlackJackHand) dealerHandHand).isBust()) {
			System.out.println("Dealer busts");

		} else if (dealerHandHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("You lose.");

		} else if (playerHand.getHandValue() > dealerHandHand.getHandValue()) {
			System.out.println("You win.");

		} else {
			System.out.println("Push.");
		}

	}

}
