package tests;

/**
 * A unit test for enum Suit
 * 
 * @author Rick Mercer
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Suit;

public class SuitTest {

	@Test
	public void testSuitNamesAreInOfTypeSuit() {
		// Kind of silly, but there is not much to test in enum Suit
		assertTrue(Suit.CLUBS instanceof Suit);
		assertTrue(Suit.DIAMONDS instanceof Suit);
		assertTrue(Suit.HEARTS instanceof Suit);
		assertTrue(Suit.SPADES instanceof Suit);
	}

	@Test
	public void testSuitWithTheBuiltInMethodValues() {
		String result = "";
		for (Suit suit : Suit.values())
			result += suit + "_";
		assertEquals("CLUBS_DIAMONDS_HEARTS_SPADES_", result);
	}

}