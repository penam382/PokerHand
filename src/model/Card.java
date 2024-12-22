package model;

import static model.Rank.*;

/*
 * @Author: Marco Pena
 */

public class Card implements Comparable<Card> {
	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {

		char suitIcon = '\u2663';
		if (suit == Suit.DIAMONDS)
			suitIcon = '\u2666';
		if (suit == Suit.HEARTS)
			suitIcon = '\u2665';
		if (suit == Suit.SPADES)
			suitIcon = '\u2660';

		String rankIcon = String.valueOf(this.getValue());
		if (rank == ACE)
			rankIcon = "A";
		else if (rank == JACK)
			rankIcon = "J";
		else if (rank == QUEEN)
			rankIcon = "Q";
		else if (rank == KING)
			rankIcon = "K";

		return rankIcon + "" + suitIcon;
	}

	@Override
	public int compareTo(Card other) {
		if (this.getValue() > other.getValue())
			return 1;
		else if (this.getValue() < other.getValue())
			return -1;
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Card))
			return false;
		Card card = (Card) other;

		if (this.getRank() == card.getRank() && this.getSuit() == card.getSuit())
			return true;

		return false;
	}

}