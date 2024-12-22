package model;

/*
 * @Author: Marco Pena
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck<Type> {

	private ArrayList<Type> deck;

	public Deck() {
		deck = new ArrayList<>();
		newCards();
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void newCards() {
		for (int i = 0; i < Suit.values().length; i++) {
			Suit suit = Suit.values()[i];
			for (int j = 0; j < Rank.values().length; j++) {
				Rank rank = Rank.values()[j];
				Card card = new Card(rank, suit);
				deck.add((Type) card);
			}
		}
	}

	public ArrayList<Type> getCardDeck() {
		return deck;
	}

	public Card topCard() {
		return (Card) deck.remove(0);
	}

	public void reset() {
		deck = new ArrayList<>();
		newCards();
	}

}
