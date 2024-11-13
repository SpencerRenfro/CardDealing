package application;

import java.util.ArrayList;



public class Deck {
	private static ArrayList<Card> deck = new ArrayList<>();

	public class Card {

		private String suit;
		private String rank;
		int imageNumber;

		public Card(String suit, String rank, int imageNumber ) {
			this.suit = suit;
			this.rank = rank;
			this.imageNumber = imageNumber;
		}

		@Override
		public String toString() {
			return rank + " of " + suit + "[ " + imageNumber + " ]";
		}
	}

	public Deck() {

		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		String[] suites = { "SPADES", "HEARTS", "DIAMONDS", "CLUBS" };
		
		int k = 1;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card card = new Card(suites[i], ranks[j], k);
				deck.add(card);
				k++;
			}
		}

	}

	public static void printSuit(String suit) {
		System.out.println("Cards for suit: " + suit);
		for (int i = 0; i < deck.size(); i++) {
			Card card = deck.get(i);
			if (card.suit.equals(suit)) {
				System.out.println(card);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("This deck contains: \n");

		for (Card card : deck) {
			s.append(card.toString()).append("\n");
		}
		return s.toString();
	}

	public static ArrayList<Card> dealRandomCards(int num_cards) {
		ArrayList<Card> randomized_cards = new ArrayList<>();
		java.util.Collections.shuffle(deck);
		for(int i = 0; i < num_cards; i++) {
			randomized_cards.add(deck.get(i));
		}
		return randomized_cards;
	}
}
