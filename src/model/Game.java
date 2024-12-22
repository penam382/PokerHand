package model;

/*
 * @Author: Marco Pena
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Game {

	private ArrayList<PokerHand> cards;
	private ArrayList<Player> players;
	private Scanner scanner;
	private Dealer dealer;
	List<Player> winners;

	public Game() {
		scanner = new Scanner(System.in);
		cards = new ArrayList<>();
		players = new ArrayList<>();
		winners = new ArrayList<>();
		this.newPlayers();
		dealer = new Dealer(players);

	}

	public void start() {
		dealer.collect();
		dealer.getDeck().shuffle();
		dealer.dealTwoCards();
		dealer.showCommunityCards();
		playerHands();
		dealer.ifTie(winners);
		winner();
		playAgain();
	}

	private void newPlayers() {
		out.print("How many players? ");
		int numOfPlayers = scanner.nextInt();
		for (int i = 1; i <= numOfPlayers; i++)
			players.add(new Player(i));
		out.println();
		return;
	}

	private void playerHands() {

		for (Player player : players) {
			PokerHand highestHand = player.findHighestHand();
			cards.add(highestHand);

			out.println(
					"Player " + player.getNumOfPlayer() + ": $" + player.getTotal() + " - " + player.showTwoCards());
			out.println("   " + "Best hand: " + highestHand + "   " + highestHand.getTypeOfHand());
			out.println();
		}

		Collections.sort(cards);

		PokerHand highestHand = cards.get(cards.size() - 1);
		for (Player player : players) {
			if (player.getBestHand().compareTo(highestHand) == 0)
				winners.add(player);
		}
	}

	private void winner() {

		for (Player player : winners) {
			PokerHand highestHand = player.findHighestHand();
			out.println("Winner: Player " + player.getNumOfPlayer() + " $" + player.getTotal());
			out.println("   " + "Best hand: " + highestHand + "   " + highestHand.getTypeOfHand());
		}
		out.println();
	}

	private void playAgain() {

		out.print("Play another game <y or n> ");
		String token = scanner.next();
		if (token.equals("n")) {
			close();
			return;
		}
		out.println("\n\n");
		reset();
		start();
	}

	public void reset() {
		cards = new ArrayList<>();
		winners = new ArrayList<>();
		dealer.reset();
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			player.reset();
		}
	}

	public void close() {
		scanner.close();
	}

}
