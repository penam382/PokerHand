package model;

/*
 * @Author: Marco Pena
 */

public enum HandType {
	ROYALFLUSH(1), STRAIGHTFLUSH(2), FOUROFKIND(3), FULLHOUSE(4), FLUSH(5), STRAIGHT(6),
	THREEOFKIND(7), TWOPAIR(8), PAIR(9), HIGHCARD(10);
	
	private int value;
	
	HandType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
