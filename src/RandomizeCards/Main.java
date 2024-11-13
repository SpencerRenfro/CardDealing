package RandomizeCards;

import java.util.ArrayList;

import application.Deck;
import application.Deck.Card;

public class Main {

	public static void main(String[] args) {
		Deck deck = new Deck();
//		deck.printSuit("SPADES");
//		System.out.println(deck.toString());
		ArrayList<Card> randomCards = Deck.dealRandomCards(3);
		System.out.println(randomCards);

	}

}
