package model;

/*
 * @Author: Marco Pena
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static model.HandType.*;
import static java.lang.System.out;

public class PokerHand implements Comparable<PokerHand> {

	private ArrayList<Card> cardList;
	private HandType typeOfHand;
	private Map<Rank, Integer> rankCountMap;

	public int[] arrayPairs;

	public PokerHand(Card card1, Card card2, Card card3, Card card4, Card card5) {

		cardList = new ArrayList<>();
		typeOfHand = HIGHCARD;
		arrayPairs = new int[5];
		rankCountMap = new HashMap<>();

		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);
		cardList.sort(null);
		this.getHighestHand(cardList);
	}

	public PokerHand() {
		cardList = new ArrayList<>();
		typeOfHand = HIGHCARD;
		arrayPairs = new int[5];
		rankCountMap = new HashMap<>();

	}

	public PokerHand(PokerHand currHand) {
		cardList = new ArrayList<>(currHand.getPokerHand());
		cardList.sort(null);
		typeOfHand = HIGHCARD;
		arrayPairs = new int[5];
		rankCountMap = new HashMap<>();

		this.getHighestHand(cardList);
	}

	@Override
	public int compareTo(PokerHand other) {

		HandType thisHand = this.getTypeOfHand();
		HandType otherHand = other.getTypeOfHand();
		if (thisHand.getValue() < otherHand.getValue())
			return 1;
		else if (thisHand.getValue() > otherHand.getValue())
			return -1;
		return breakTie(other.getMap(), other.getPokerHand(), other);
	}

	public void getHighestHand(ArrayList<Card> currCard) {
		Suit suit = currCard.get(0).getSuit();
		boolean threeFound = false;
		boolean straight = true;
		int suitCount = 1;
		int pairCount = 0;

		for (int i = 0; i < 5; i++) {

			Card card = currCard.get(i);
			arrayPairs[4] = Math.max(arrayPairs[4], card.getValue());
			Rank val = card.getRank();

			if (rankCountMap.containsKey(val)) {
				rankCountMap.merge(val, 1, Integer::sum);

				if (rankCountMap.get(val) == 2) {
					straight = false;
					pairCount += 1;
					if (pairCount == 2) {
						arrayPairs[2] = card.getValue();
						if (threeFound) {
							typeOfHand = FULLHOUSE;
							return;
						} else
							typeOfHand = TWOPAIR;
					} else {
						typeOfHand = PAIR;
						arrayPairs[3] = card.getValue();

					}

				} else if (rankCountMap.get(val) == 3) {
					threeFound = true;
					arrayPairs[1] = card.getValue();

					if (pairCount == 2) {
						typeOfHand = FULLHOUSE;
						return;

					} else
						typeOfHand = THREEOFKIND;

				} else {
					typeOfHand = FOUROFKIND;
					arrayPairs[0] = card.getValue();
					return;
				}

			} else {

				rankCountMap.put(val, 1);
				if (i == 0)
					continue;
				if (card.getSuit() == suit)
					suitCount += 1;
				if (card.getValue() - currCard.get(i - 1).getValue() != 1)
					straight = false;
			}
		}

		if (straight || suitCount == 5) {
			if (suitCount == 5 && straight) {
				if (currCard.get(0).getValue() == 10)
					typeOfHand = ROYALFLUSH;
				else
					typeOfHand = STRAIGHTFLUSH;

			} else if (straight)
				typeOfHand = STRAIGHT;
			else
				typeOfHand = FLUSH;
		}
		return;
	}

	private int breakTie(Map<Rank, Integer> oMap, ArrayList<Card> oList, PokerHand other) {

		if (typeOfHand == HIGHCARD)
			return this.findHighCard(oList);

		else if (typeOfHand == STRAIGHT || typeOfHand == STRAIGHTFLUSH)
			return this.comparePairsAt(other, 4);

		else if (typeOfHand == PAIR) {
			if (this.arrayPairs[3] == other.arrayPairs[3])
				return findHighCard(other.getPokerHand());

			else
				return this.comparePairsAt(other, 3);
		}

		else if (typeOfHand == TWOPAIR) {
			if (this.arrayPairs[2] == other.arrayPairs[2])
				if (this.arrayPairs[3] == other.arrayPairs[3])
					return findHighCard(other.getPokerHand());
				else
					return this.comparePairsAt(other, 3);
			else
				return this.comparePairsAt(other, 2);
		}

		else if (typeOfHand == THREEOFKIND)
			if (this.arrayPairs[1] == other.arrayPairs[1]) {
				return findHighCard(other.getPokerHand());
			} else
				return this.comparePairsAt(other, 1);

		else if (typeOfHand == FLUSH)
			return findHighCard(other.getPokerHand());

		else if (typeOfHand == FULLHOUSE) {
			if (this.arrayPairs[1] == other.arrayPairs[1]) {

				int i1 = 2;
				if (this.arrayPairs[1] == other.arrayPairs[2])
					i1 = 3;
				else
					i1 = 2;

				int i2 = 2;
				if (this.arrayPairs[1] == other.arrayPairs[2])
					i2 = 3;
				else
					i2 = 2;

				if (this.arrayPairs[i1] == other.arrayPairs[i2])
					return 0;
				else {
					if (this.arrayPairs[i1] > other.arrayPairs[i2])
						return 1;
					else
						return -1;
				}
			} else
				return this.comparePairsAt(other, 1);
		}

		else if (typeOfHand == FOUROFKIND)
			return this.comparePairsAt(other, 0);

		else
			return 0;
	}

	private int findHighCard(ArrayList<Card> other) {

		for (int i = cardList.size() - 1; i >= 0; i--) {

			int thisVal = this.cardList.get(i).getValue();
			int otherVal = other.get(i).getValue();

			if (thisVal > otherVal)
				return 1;
			else if (thisVal < otherVal)
				return -1;
		}
		return 0;
	}

	public void addCard(Card card) {
		cardList.add(card);
	}

	public int size() {
		return cardList.size();
	}

	public PokerHand max(PokerHand other) {
		if (this.compareTo(other) == 1)
			return this;
		else
			return other;
	}

	public void removeCard(int index) {
		cardList.remove(index);
	}

	private int comparePairsAt(PokerHand other, int index) {
		if (this.arrayPairs[index] > other.arrayPairs[index])
			return 1;
		else if (this.arrayPairs[index] < other.arrayPairs[index])
			return -1;
		return 0;
	}

	public ArrayList<Card> getPokerHand() {
		return cardList;
	}

	public HandType getTypeOfHand() {
		return typeOfHand;
	}

	public Map<Rank, Integer> getMap() {
		return rankCountMap;
	}

	@Override
	public String toString() {
		String result = "";
		for (Card card : cardList) {
			result += card.toString() + " ";
		}
		return result;
	}

}