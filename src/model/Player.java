package model;

/*
 * @Author: Marco Pena
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class Player {

	private int numOfPlayer;
	private double total;
	public ArrayList<Card> playerHand;
	public List<Card> startingHand;
	public PokerHand bestHand;

	public Player(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
		total = 100.00;
		playerHand = new ArrayList<>();
		bestHand = new PokerHand();
		startingHand = new ArrayList<>();
	}

	public PokerHand findHighestHand() {
		this.combine();
		return getBestHand();
	}

	private void combine() {
		combinationHelper(new PokerHand(), 0, playerHand.size() - 1, 5);
	}

	private void combinationHelper(PokerHand current, int start, int n, int k) {
		if (k == 0) {
			PokerHand currentPokerHand = new PokerHand(current);
			bestHand = bestHand.max(currentPokerHand);
			return;
		}

		for (int i = start; i <= n; i++) {
			current.addCard(playerHand.get(i));
			combinationHelper(current, i + 1, n, k - 1);
			current.removeCard(current.size() - 1);
		}
	}

	public void giveTwoCards(Card card1, Card card2) {
		startingHand.add(card1);
		startingHand.add(card2);
	}

	public String showTwoCards() {
		String cards = "";
		for (Card card : startingHand) {
			cards += card + " ";
		}
		return cards;
	}

	public void increaseTotal(double val) {
		total += val;
	}

	public void lowerTotal() {
		total -= 2;
	}

	public void giveCards(Card card) {
		playerHand.add(card);
	}

	public void reset() {
		playerHand = new ArrayList<>();
		bestHand = new PokerHand();
		startingHand = new ArrayList<>();
	}

	public int getNumOfPlayer() {
		return numOfPlayer;
	}

	public double getTotal() {
		return total;
	}

	public PokerHand getBestHand() {
		return bestHand;
	}

	public String toString() {
		return bestHand + "" + bestHand.getTypeOfHand() + " Player " + numOfPlayer + " " + total;
	}
}
