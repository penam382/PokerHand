package tests;

/**
 * Tests the CardHand class, last modified August 23
 * 
 * I think this a good unit test, if you add any other test cases please send them to Rick.
 * 
 * @author Rick Mercer
 */

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

public class PokerHandTestGrading {

	// This file contains all 52 cards to save you time with names like
	// C2 for the two of clubs
	// AS for the ace of spades

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	@Test
	public void testThreeOfKindWhenEqual() {
		PokerHand a = new PokerHand(D5, C5, H5, H9, H8);
		PokerHand b = new PokerHand(D5, C5, H5, H9, H8);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testThreeOfKind() {
		PokerHand a = new PokerHand(D5, C5, H5, H9, H8);
		PokerHand b = new PokerHand(D4, C4, H4, HA, HK);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
		assertTrue(b.compareTo(a) != 0);
	}

	@Test
	public void testThreeOfKind2() {
		PokerHand a = new PokerHand(D4, C4, H4, H9, H8);
		PokerHand b = new PokerHand(D4, C4, H4, H7, HA);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testThreeOfKind3() {
		PokerHand a = new PokerHand(D4, C4, H4, H9, H8);
		PokerHand b = new PokerHand(D4, C4, H4, H9, H6);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testThreeOfKind4() {
		PokerHand a = new PokerHand(D4, C4, H4, H9, H8);
		PokerHand b = new PokerHand(D4, C4, H4, H9, HA);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testFullHouseHands() {
		PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
		PokerHand b = new PokerHand(S3, D3, DA, CA, HA);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testFullHouseHands2() {
		PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
		PokerHand b = new PokerHand(C6, H6, DA, CA, HA);
		assertTrue(a.compareTo(b) == 0);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testFullHouseHands3() {
		PokerHand a = new PokerHand(S6, D6, DA, CA, HA);
		PokerHand b = new PokerHand(C7, H7, DA, CA, HA);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testThreeOfAKind() {
		PokerHand a = new PokerHand(S6, D7, DA, CA, HA);
		PokerHand b = new PokerHand(C5, H6, DA, CA, HA);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testThreeOfAKind3() {
		PokerHand a = new PokerHand(S7, D6, DA, CA, HA);
		PokerHand b = new PokerHand(C7, H6, DA, CA, HA);
		assertTrue(a.compareTo(b) == 0);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testFourOfAKind() {
		PokerHand a = new PokerHand(S7, CA, DA, HA, SA);
		PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
		assertTrue(a.compareTo(b) == 0);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testFourOfAKind4() {
		PokerHand a = new PokerHand(S8, CA, DA, HA, SA);
		PokerHand b = new PokerHand(D7, CA, DA, HA, SA);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testTwoStraightsFlushes() {
		PokerHand straight1 = new PokerHand(C3, C4, C5, C6, C7);
		PokerHand straight2 = new PokerHand(CJ, C10, C9, C8, CQ);
		assertTrue(straight1.compareTo(straight2) < 0);
		assertTrue(straight2.compareTo(straight1) > 0);
	}

	@Test
	public void testTwoStraights() {
		PokerHand straight1 = new PokerHand(C3, D4, H5, S6, C7);
		PokerHand straight2 = new PokerHand(CJ, H10, D9, C8, SQ);
		assertTrue(straight1.compareTo(straight2) < 0);
	}

	@Test
	public void testHighCard1() {
		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
		PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testHighCard2() {
		PokerHand a = new PokerHand(C3, C4, D6, D7, DQ);
		PokerHand b = new PokerHand(C2, C5, C7, DJ, DK);
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testHighCard3() {
		PokerHand a = new PokerHand(C3, C4, C6, CJ, DK);
		PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testHighCard4() {
		PokerHand a = new PokerHand(C3, C4, C7, CJ, DK);
		PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
		assertTrue(b.compareTo(a) > 0); // 5 > 4
	}

	@Test
	public void testHighCard5() {
		PokerHand a = new PokerHand(C3, C5, C7, CJ, DK);
		PokerHand b = new PokerHand(D2, D5, D7, DJ, SK);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testPair1() {
		PokerHand a = new PokerHand(C3, C4, C7, CJ, DJ);
		PokerHand b = new PokerHand(D2, D5, D7, D10, S10);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testPair3() {
		PokerHand a = new PokerHand(CA, CK, CQ, C5, D5);
		PokerHand b = new PokerHand(DQ, DK, DA, D6, S6);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testPair13() { // do I have some of these pair tests below?
		PokerHand a = new PokerHand(CA, CK, CQ, C5, D5);
		PokerHand b = new PokerHand(DQ, DK, DA, D4, S4);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testPairWhenTied() {
		PokerHand a = new PokerHand(H3, CA, D4, H6, SA);
		PokerHand b = new PokerHand(D3, C4, DA, HA, C6);
		assertTrue(a.compareTo(b) <= 0);
		assertTrue(b.compareTo(a) >= 0);
	}

	@Test
	public void testTwoPair1() {
		PokerHand a = new PokerHand(C4, CA, D4, H3, DA); // 2 aces, two 4s, 3
		PokerHand b = new PokerHand(H4, C10, HA, SA, S4); // 2 aces, two 4s, 10
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testTwoPair2() {
		PokerHand a = new PokerHand(C4, CA, D4, H3, DA); // 2 aces, two 4s, 3
		PokerHand b = new PokerHand(HQ, CJ, HK, SK, SQ); // 2 kings, two queens
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testTwoPair3() {
		PokerHand a = new PokerHand(C4, CA, D4, H3, DA);
		PokerHand b = new PokerHand(H4, C10, HA, SA, S4);
		assertTrue(a.compareTo(b) <= 0);
	}

	@Test
	public void testTwoPair4() {
		PokerHand a = new PokerHand(C4, CA, D4, H3, DA);
		PokerHand b = new PokerHand(H4, C10, HA, SA, S4);
		assertTrue(b.compareTo(a) >= 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual() {
		PokerHand a = new PokerHand(C4, HK, D4, H3, DK);
		PokerHand b = new PokerHand(H4, C10, CA, DA, S4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual2() {
		PokerHand a = new PokerHand(C8, D8, CA, SA, CK);
		PokerHand b = new PokerHand(H9, S9, HA, DA, HK); // 2 ACES, 2 FOURS
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testTwoPairWhenOnePairIsEqual3() {
		PokerHand a = new PokerHand(C9, D9, CK, DA, C2);
		PokerHand b = new PokerHand(H9, S9, HK, SA, C3);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(b) != 0);
		assertTrue(b.compareTo(a) != 0);
	}

	@Test
	public void testTwoPairWhenTwoPairsAreEqual4() {
		PokerHand a = new PokerHand(C2, D2, C5, D5, CJ);
		PokerHand b = new PokerHand(H2, S2, H5, S5, C10);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testTwoPairWhenTwoPairsAreEquaAndTheFifthCardHasSameRank() {
		PokerHand a = new PokerHand(C2, D2, C5, D5, CJ);
		PokerHand b = new PokerHand(H2, S2, H5, S5, SJ);
		assertTrue(a.compareTo(b) == 0);
		assertTrue(b.compareTo(a) == 0);
	}

	@Test
	public void testTwoPairWhenAtIndexesForCodeCoverage() {
		PokerHand a = new PokerHand(C2, D3, C5, D5, CJ);
		PokerHand b = new PokerHand(H2, S3, H3, S5, SJ);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testTwoPair6() {
		PokerHand a = new PokerHand(C2, C5, D2, D5, CJ);
		PokerHand b = new PokerHand(H5, S5, H2, S2, C10);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	// Trips
	@Test
	public void testTrips1() {
		PokerHand a = new PokerHand(H7, C7, D7, S9, S10);
		PokerHand b = new PokerHand(H9, C10, H6, C6, D6);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testTrips2() {
		PokerHand a = new PokerHand(CK, DK, HK, CQ, CJ);
		PokerHand b = new PokerHand(CA, DA, HA, H2, D2);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testTripsBeatsTwoPair() {
		PokerHand a = new PokerHand(C2, H2, S2, CQ, CJ);
		PokerHand b = new PokerHand(CA, DA, HK, SK, D2);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testTripsLosesToFourOfAKind() {
		PokerHand a = new PokerHand(CA, HA, SA, CQ, CJ);
		PokerHand b = new PokerHand(C2, D2, H2, S2, D8);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testFullHouse1() {
		PokerHand a = new PokerHand(H8, C8, D8, H4, C4);
		PokerHand b = new PokerHand(H7, C7, D7, S4, D4);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	@Test
	public void testFullHouse2() {
		PokerHand a = new PokerHand(H3, C3, D3, C4, D4);
		PokerHand b = new PokerHand(H5, C5, D5, H4, S4);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testFullHouse8() {
		PokerHand a = new PokerHand(H8, C8, D8, H4, C4);
		PokerHand b = new PokerHand(H7, C7, D7, S4, D4);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testFullHouseWhenPairsAreEqual() {
		PokerHand a = new PokerHand(C2, D2, C3, D3, H3);
		PokerHand b = new PokerHand(H2, S2, C4, D4, H4);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
	}

	@Test
	public void testFullHouseWhenPairIsGreaterThanTripsInOtherHandl() {
		PokerHand a = new PokerHand(C8, D8, C3, D3, H3);
		PokerHand b = new PokerHand(H7, S7, C4, D4, H4);
		assertTrue(b.compareTo(a) > 0);
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testFourOfKindWhenLast4Match() {
		PokerHand a = new PokerHand(CA, C2, D2, H2, S2);
		PokerHand b = new PokerHand(DA, C3, D3, H3, S3);
		b.toString();
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void compareFlushes() {
		PokerHand a = new PokerHand(CA, C4, C6, C8, C9);
		PokerHand b = new PokerHand(HA, H4, H6, H8, H9);
		b.toString();
		assertTrue(a.compareTo(b) == 0);
	}

	// TEST CARD HGH HANDS

	@Test
	public void testNothing0() {
		PokerHand nothing72 = new PokerHand(C2, C3, C4, C5, D7);
		PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
		assertTrue(nothing73.compareTo(nothing72) > 0);
	}

	@Test
	public void testNothing1() {
		PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);
		PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
		assertTrue(nothingJ.compareTo(nothing73) > 0);
	}

	@Test
	public void testNothing2() {
		PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
		PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
		assertTrue(nothingK8.compareTo(nothingJ) > 0);
	}

	@Test
	public void testNothing3() {
		PokerHand nothingK9 = new PokerHand(CK, CQ, CJ, D10, H9);
		PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
		assertTrue(nothingK9.compareTo(nothingK8) > 0);
	}

	@Test
	public void testNothing4() {
		PokerHand nothingK8 = new PokerHand(HK, HQ, HJ, H10, S8);
		PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
		assertTrue(nothingA.compareTo(nothingK8) > 0);
	}

	// TEST PAIRS
	@Test
	public void testPair9() {
		PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
		PokerHand pair2 = new PokerHand(C2, S2, CQ, CK, CA);
		assertTrue(pair2.compareTo(pair) > 0);
		assertTrue(pair.compareTo(pair2) < 0);
	}

	@Test
	public void testPair4() {
		PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
		PokerHand pair3 = new PokerHand(C3, H3, H4, H5, S6);
		assertTrue(pair3.compareTo(pair) > 0);
		assertTrue(pair.compareTo(pair3) < 0);
	}

	@Test
	public void testPair5() {
		PokerHand pairLow = new PokerHand(C2, D2, C3, H4, H5);
		PokerHand pairHigh = new PokerHand(HA, CA, CK, CQ, HJ);
		assertTrue(pairHigh.compareTo(pairLow) > 0);
	}

	@Test
	public void testPair6() {
		PokerHand pairHigh = new PokerHand(HA, CA, CK, CQ, HJ);
		PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
		assertTrue(pairHigh.compareTo(pair) > 0);
	}

	@Test
	public void testPair7() {
		PokerHand pairHigh = new PokerHand(HA, CA, CK, CQ, HJ);
		PokerHand nothingJ = new PokerHand(C8, C9, C10, SJ, D3);
		assertTrue(pairHigh.compareTo(nothingJ) > 0);
	}

	@Test
	public void testPair10() {
		PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
		PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
		assertTrue(pair.compareTo(nothingA) > 0);
	}

	// Test two pairs

	@Test
	public void testTwoPairs0() {
		PokerHand twoPair = new PokerHand(D2, H4, C3, C2, H3);
		PokerHand twoPair2 = new PokerHand(H9, D9, S2, H2, SJ);
		assertTrue(twoPair2.compareTo(twoPair) > 0);
	}

	@Test
	public void testTwoPairs1() {
		PokerHand twoPairA = new PokerHand(DA, CA, DK, CK, H7);
		PokerHand twoPair2 = new PokerHand(H9, D9, S2, H2, SJ);
		assertTrue(twoPairA.compareTo(twoPair2) > 0);
	}

	@Test
	public void testTwoPairs2() {
		PokerHand twoPairA = new PokerHand(DA, CA, DK, CK, H7);
		PokerHand twoPairLow = new PokerHand(C2, D2, C3, H3, D4);
		assertTrue(twoPairA.compareTo(twoPairLow) > 0);
	}

	@Test
	public void testTwoPairs() {
		PokerHand twoPairHigh = new PokerHand(CA, HA, CK, HK, CQ);
		PokerHand twoPairLow = new PokerHand(C2, D2, C3, H3, D4);
		assertTrue(twoPairHigh.compareTo(twoPairLow) > 0);
	}

	// TEST 3 OF A KIND

	@Test
	public void testThreeMiddle3AreTheSameForCodeCoverage() {
		PokerHand threeKind = new PokerHand(D2, S5, D5, H5, CA);
		PokerHand threeKind2 = new PokerHand(C2, S4, D4, H4, SA);
		assertTrue(threeKind.compareTo(threeKind2) > 0);
	}

	@Test
	public void testThreeOfAKind1() {
		PokerHand threeKind = new PokerHand(D2, H5, H2, H4, C2);
		PokerHand threeKind2 = new PokerHand(C5, D5, S5, HA, HK);
		assertTrue(threeKind2.compareTo(threeKind) > 0);
	}

	@Test
	public void testThreeOfAKind2() {
		PokerHand threeKind3 = new PokerHand(H6, S6, C6, H3, S2);
		PokerHand threeKind2 = new PokerHand(C5, D5, S5, HA, HK);
		assertTrue(threeKind3.compareTo(threeKind2) > 0);
	}

	@Test
	public void testThreeOfAHigh3() {
		PokerHand threeKindLow = new PokerHand(D2, C2, H2, H3, H4);
		PokerHand threeKindHigh = new PokerHand(CA, HA, SA, CK, CQ);
		assertTrue(threeKindHigh.compareTo(threeKindLow) > 0);
	}

	@Test
	public void testThreeOfAHigh4() {
		PokerHand threeKindHigh = new PokerHand(CA, HA, SA, CK, CQ);
		PokerHand threeKind3 = new PokerHand(H6, S6, C6, H3, S2);
		assertTrue(threeKindHigh.compareTo(threeKind3) > 0);
	}

	@Test
	public void testThreeOfAHigh5() {
		PokerHand threeKind = new PokerHand(D2, H5, H2, H4, C2);
		PokerHand threeKindHigh = new PokerHand(CA, HA, SA, CK, CQ);
		assertTrue(threeKindHigh.compareTo(threeKind) > 0);
	}

	@Test
	public void testStaights1() {
		PokerHand straight = new PokerHand(C4, C6, C2, C5, S3);
		PokerHand straightInDifferentSuit = new PokerHand(D2, D3, D4, D5, S6);
		assertTrue(straight.compareTo(straightInDifferentSuit) == 0);
	}

	@Test
	public void testStaights2() {
		PokerHand straightHigh = new PokerHand(C10, HJ, CQ, CK, CA);
		PokerHand straight = new PokerHand(C4, C6, C2, C5, S3);
		assertTrue(straightHigh.compareTo(straight) > 0);
	}

	// TEST FLUSHES
	private static PokerHand flush = new PokerHand(H7, H5, H3, H2, HJ);
	private static PokerHand flush2 = new PokerHand(S7, S5, S4, S2, SJ);
	private static PokerHand flushLow = new PokerHand(D2, D3, D4, D5, D7);
	private static PokerHand flushHigh = new PokerHand(CA, CK, CQ, CJ, C9);

	@Test
	public void testFlush() {
		assertTrue(flush.compareTo(flushLow) > 0);
	}

	@Test
	public void testFlush2() {
		assertTrue(flushHigh.compareTo(flushLow) > 0);
	}

	@Test
	public void testFlush3() {
		assertTrue(flush2.compareTo(flush) > 0);
	}

	@Test
	public void testFlush4() {
		assertTrue(flush2.compareTo(flushHigh) < 0);
	}

	// TEST FULL HOUSE
	// The higher triple wins
	@Test
	public void testFullHouse3() {
		PokerHand fullHouse = new PokerHand(CA, DA, C3, D3, H3);
		PokerHand fullHouse2 = new PokerHand(C2, D2, C4, D4, H4);
		assertTrue(fullHouse2.compareTo(fullHouse) > 0);
	}

	@Test
	public void testFullHouse4() {
		PokerHand fullHouse3 = new PokerHand(HK, DK, SK, CA, HA);
		PokerHand fullHouse2 = new PokerHand(C2, D2, C4, D4, H4);
		assertTrue(fullHouse3.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testFullHouse6() {
		PokerHand fullHouseLow = new PokerHand(C2, D2, H2, C3, H3);
		PokerHand fullHouseHigh = new PokerHand(CA, DA, HA, CK, HK);
		assertTrue(fullHouseHigh.compareTo(fullHouseLow) > 0);
	}

	// TEST FOUR OF A KIND

	@Test
	public void testFourOfAKind1() {
		PokerHand fourKindLow = new PokerHand(C2, D2, H2, S2, C3);
		PokerHand fourKindMid = new PokerHand(C8, D8, H8, S8, H3);
		assertTrue(fourKindMid.compareTo(fourKindLow) > 0);
		assertTrue(fourKindLow.compareTo(fourKindMid) < 0);
	}

	@Test
	public void testFourOfAKind2() {
		PokerHand fourKindLow = new PokerHand(C2, D2, H2, S2, C3);
		PokerHand fourKindHigh = new PokerHand(CA, DA, HA, SA, CK);
		assertTrue(fourKindHigh.compareTo(fourKindLow) > 0);
	}

	@Test
	public void testFourOfAKind3() {
		PokerHand fourKindMid = new PokerHand(C8, D8, H8, S8, H3);
		PokerHand fourKindHigh = new PokerHand(CA, DA, HA, SA, CK);
		assertTrue(fourKindHigh.compareTo(fourKindMid) > 0);
	}

	@Test
	public void testFourOfAKind5() {
		PokerHand fourKindLow = new PokerHand(C2, D2, H2, S2, C3);
		PokerHand fourKindMid = new PokerHand(C2, D2, H2, S2, H3);
		assertTrue(fourKindMid.compareTo(fourKindLow) == 0);
	}

	@Test
	public void testFourOfAKind6() {
		PokerHand fourKindLow = new PokerHand(C2, D2, H2, S2, C3);
		PokerHand fourKindMid = new PokerHand(C2, D2, H2, S2, H4);
		assertTrue(fourKindMid.compareTo(fourKindLow) > 0);
	}

	@Test
	public void testFourOfAKind7() {
		PokerHand a = new PokerHand(C2, D2, H2, S2, C4);
		PokerHand b = new PokerHand(C2, D2, H2, S2, H3);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testFourOfAKind8() {
		PokerHand a = new PokerHand(C5, D5, H5, S5, C4);
		PokerHand b = new PokerHand(C5, D5, H5, S5, H3);
		assertTrue(a.compareTo(b) > 0);
		assertTrue(b.compareTo(a) < 0);
	}

	// TEST FLUSH

	@Test
	public void testStraightFlush1() {
		PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
		PokerHand straightFlushMid = new PokerHand(H8, H9, H10, HJ, HQ);
		assertTrue(straightFlushMid.compareTo(straightFlush) > 0);
	}

	@Test
	public void testStraightFlush2() {
		PokerHand straightFlushHi = new PokerHand(C10, CJ, CQ, CK, CA);
		PokerHand straightFlushMid = new PokerHand(H8, H9, H10, HJ, HQ);
		assertTrue(straightFlushHi.compareTo(straightFlushMid) > 0);
	}

	@Test
	public void testStraightFlush3() {
		PokerHand straightFlushHi = new PokerHand(C10, CJ, CQ, CK, CA);
		PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
		assertTrue(straightFlushHi.compareTo(straightFlush) > 0);
	}

	// Put ranks above others
	@Test
	public void testManyRanks1() {
		PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
		PokerHand fourKindHigh = new PokerHand(CA, DA, HA, SA, CK);
		assertTrue(straightFlush.compareTo(fourKindHigh) > 0);
	}

	@Test
	public void testManyRanks01() {
		PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
		PokerHand pair2 = new PokerHand(C2, S2, CQ, CK, CA);
		assertTrue(straightFlush.compareTo(pair2) > 0);
	}

	@Test
	public void testManyRanks02() {
		PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
		PokerHand twoPair2 = new PokerHand(H9, D9, S2, H2, SJ);
		assertTrue(straightFlush.compareTo(twoPair2) > 0);
	}

	@Test
	public void testStraightFlushes() {
		PokerHand a = new PokerHand(CA, DK, CQ, DJ, H10);
		PokerHand b = new PokerHand(H2, S3, C4, D5, H6);
		assertTrue(a.compareTo(b) > 0);
	}

	@Test
	public void testStraightFlushes2() {
		PokerHand a = new PokerHand(DA, DK, DQ, DJ, D10);
		PokerHand b = new PokerHand(SK, SQ, SJ, S10, S9);
		assertTrue(a.compareTo(b) > 0);
	}

	// Test a variety

	PokerHand straightFlush = new PokerHand(H3, H4, H5, H6, H7);
	PokerHand fullHouse3 = new PokerHand(HK, DK, SK, CA, HA);
	PokerHand straight = new PokerHand(C4, C6, C2, C5, S3);
	PokerHand fullHouse2 = new PokerHand(C2, D2, C4, D4, H4);
	PokerHand straightHigh = new PokerHand(C10, HJ, CQ, CK, CA);
	PokerHand fourKindHigh = new PokerHand(CA, DA, HA, SA, CK);
	PokerHand fourKindMid = new PokerHand(C8, D8, H8, S8, H3);
	PokerHand threeKind2 = new PokerHand(C2, S4, D4, H4, SA);
	PokerHand threeKindHigh = new PokerHand(CA, HA, SA, CK, CQ);
	PokerHand threeKind3 = new PokerHand(H6, S6, C6, H3, S2);
	PokerHand straightFlushMid = new PokerHand(H8, H9, H10, HJ, HQ);
	PokerHand twoPairHigh = new PokerHand(CA, HA, CK, HK, CQ);
	PokerHand pairHigh = new PokerHand(HA, CA, CK, CQ, HJ);
	PokerHand nothingA = new PokerHand(S9, SJ, SQ, SK, CA);
	PokerHand pair = new PokerHand(D2, H2, D3, S7, H6);
	PokerHand pair3 = new PokerHand(C3, H3, H4, H5, S6);
	PokerHand pairLow = new PokerHand(C2, D2, C3, H4, H5);
	PokerHand nothing73 = new PokerHand(D2, D4, D5, D6, C7);

	@Test
	public void testManyRanks03() {
		assertTrue(straightFlush.compareTo(fullHouse3) > 0);
	}

	@Test
	public void testManyRanks04() {
		assertTrue(straightFlush.compareTo(straight) > 0);
	}

	@Test
	public void testManyRanks05() {
		assertTrue(straightFlush.compareTo(straightHigh) > 0);
	}

	@Test
	public void testManyRanks2() {
		assertTrue(fourKindHigh.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testManyRanks3() {
		assertTrue(fourKindMid.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testManyRanks13() {
		assertTrue(fourKindMid.compareTo(threeKind2) > 0);
	}

	@Test
	public void testManyRanks14() {
		assertTrue(fourKindMid.compareTo(threeKindHigh) > 0);
	}

	@Test
	public void testManyRanks4() {
		assertTrue(fullHouse2.compareTo(threeKind2) > 0);
	}

	@Test
	public void testManyRanks5() {
		assertTrue(fullHouse2.compareTo(threeKind3) > 0);
	}

	@Test
	public void testManyRanks6() {
		assertTrue(fullHouse2.compareTo(threeKind3) > 0);
	}

	@Test
	public void testManyRanks7() {
		assertTrue(threeKind3.compareTo(twoPairHigh) > 0);
	}

	@Test
	public void testManyRanks07() {
		assertTrue(threeKind3.compareTo(pairHigh) > 0);
	}

	@Test
	public void testManyRanks08() {
		assertTrue(threeKind3.compareTo(nothingA) > 0);
	}

	@Test
	public void testManyRanks8() {
		assertTrue(twoPairHigh.compareTo(pair) > 0);
	}

	@Test
	public void testManyRanks9() {
		assertTrue(twoPairHigh.compareTo(pair3) > 0);
	}

	@Test
	public void testManyRanks10() {
		assertTrue(twoPairHigh.compareTo(pairLow) > 0);
	}

	@Test
	public void testManyRanks11() {
		PokerHand threeKind2 = new PokerHand(C2, S4, D4, H4, SA);
		PokerHand threeKindHigh = new PokerHand(CA, HA, SA, CK, CQ);
		assertTrue(threeKind2.compareTo(threeKindHigh) < 0);
	}

	// Add three random tests to get to 100 @Tests
	@Test
	public void testStraightFlush00() {
		assertTrue(straightFlushMid.compareTo(fullHouse2) > 0);
	}

	@Test
	public void testManyRanks44() {
		assertTrue(fullHouse2.compareTo(threeKindHigh) > 0);
	}
}
