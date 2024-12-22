package model;

/*
 * @Author: Marco Pena
 */
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private double pot;
	private Deck<Card> deck;
	private PokerHand communityCards;
	private ArrayList<Player> players;

	public Dealer(ArrayList<Player> players) {
		pot = 0;
		deck = new Deck<>();
		communityCards = new PokerHand();
		this.players = players;
	}

	public void dealTwoCards() {
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			Card card1 = deck.topCard();
			Card card2 = deck.topCard();
			player.giveCards(card1);
			player.giveCards(card2);
			player.giveTwoCards(card1, card2);
		}
	}

	public void showCommunityCards() {

		for (int i = 0; i <= 4; i++) {
			Card card = deck.topCard();
			communityCards.addCard(card);
			for (int j = 0; j < players.size(); j++) {
				Player player = players.get(j);
				player.giveCards(card);
			}
		}
		out.println("Community Cards: " + communityCards);
		out.println();
	}

	public void ifTie(List<Player> winners) {
		double amount = pot / winners.size();
		amount = Math.floor(amount * 100) / 100;
		for (Player player : winners) {
			player.increaseTotal(amount);
		}
	}

	public void increasePot() {
		pot += 2;
	}

	public void collect() {
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			player.lowerTotal();
			this.increasePot();
		}
	}

	public ArrayList<Card> getCommunityCards() {
		return communityCards.getPokerHand();
	}

	public Deck<Card> getDeck() {
		return deck;
	}

	public double getPot() {
		return pot;
	}

	public void reset() {
		communityCards = new PokerHand();
		pot = 0;
		deck.reset();
	}

}
