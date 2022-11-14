package com.skilldistillery.cards;

public enum Rank {
	ACE(11), TWO( 2), THREE(3), FOUR(4), FIVE(5), SIX(6),
	SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10),
	KING(10);

	private int rankValue;


	Rank(int rankValue) {
		this.rankValue = rankValue;
	}


	public int getRankValue() {
		return rankValue;
	}


	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

	
}
