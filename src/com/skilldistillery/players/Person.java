package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackJackHand;
import com.skilldistillery.cardgame.Hand;

public abstract class Person {

 
    private String name;
    private Hand hand;

    /**
     * Create a new Person
     */
    public Person(){
        this.hand = new BlackJackHand();
        this.name = "";
    }
    
    
    public String getName(){
        return this.name;
    }
    public Hand getHand() {
		return hand;
	}


	public void setHand(Hand hand) {
		this.hand = hand;
	}


	public void setName(String name){
        this.name = name;

    }
	
	
	public void printHand(){
    	System.out.println(this.getHand() + "Value = " + getHand().getHandValue());
    	
    }
    
    
    



}
