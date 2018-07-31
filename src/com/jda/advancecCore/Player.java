package com.jda.advancecCore;
import com.jda.util.QueueLinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Player {

	static Player x = new Player();
	static QueueLinkedList<String> playerCards = new QueueLinkedList<>();

	class Sorter implements Comparator<String> {
		public int compare(String x, String y) {
			String suit1 = x.split(" ")[2];
			String suit2 = y.split(" ")[2];
			if (suit1.compareTo(suit2) < 0) {
				return -1;
			} else if (suit1.compareTo(suit2) > 0) {
				return 1;
			} else {
				int number1 = Integer.parseInt(mapToNumber(x.split(" ")[0]));
				int number2 = Integer.parseInt(mapToNumber(y.split(" ")[0]));
				if (number1 < number2) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

	public static String mapToNumber(String number) {
		switch (number) {
		case "Jack": {
			return "10";
		}
		case "Queen": {
			return "11";
		}
		case "King": {
			return "12";
		}
		case "Ace": {
			return "13";
		}
		default:
			return number;
		}
	}

	public static void pushToQueue() {
		List<String> allCards = sortByRank();
		for (String x : allCards) {
			playerCards.push(x);
		}
	}

	public static List<String> sortByRank() {
		List<String> allCards = Deck.distributeCards();
		Collections.sort(allCards, x.new Sorter());
		return allCards;
	}

}
