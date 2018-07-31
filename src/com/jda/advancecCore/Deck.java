package com.jda.advancecCore;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Deck {

	static boolean[][] distributedCards = new boolean[13][4];

	static List<String> cardsDistributed = new ArrayList<>();

	public static int randomCardNumber() {
		Random random = new Random();
		return random.nextInt(13);
	}

	public static int randomCardType() {
		Random random = new Random();
		return random.nextInt(4);
	}
//converts the number of card to String type
	public static String linkNumber(int cardNumber) {
		switch (cardNumber) {
		case 9: {
			return "Jack ";
		}
		case 10: {
			return "Queen ";
		}
		case 11: {
			return "King ";
		}
		case 12: {
			return "Ace ";
		}
		default: {
			return Integer.toString(cardNumber + 1) + " ";
		}
		}
	}
//converts the number to suit type
	public static String linkType(int cardType) {
		switch (cardType) {
		case 0: {
			return "Spades";
		}
		case 1: {
			return "Hearts";
		}
		case 2: {
			return "Clubs";
		}
		case 3: {
			return "Diamonds";
		}
		}
		return null;
	}

	public static List<String> distributeCards() {
		//stores the cards already distributed
		cardsDistributed = new ArrayList<>();
		for (int j = 0; j < 9; j++) {
			//gets the card using the Random class
			int cardNumber = randomCardNumber();
			int cardType = randomCardType();
			// checks if the card has already been allocated or not
			while(distributedCards[cardNumber][cardType] == true) {
				cardNumber = randomCardNumber();
				cardType = randomCardType();
			}
			
			String card = linkNumber(cardNumber) + "of " + linkType(cardType);
			cardsDistributed.add(card);
			distributedCards[cardNumber][cardType] = true;
		}
		return cardsDistributed;
	}

}