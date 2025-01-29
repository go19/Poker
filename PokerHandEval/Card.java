package PokerHandEval;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {
	
	String rank;
	char suit;
	
	public Card(String card) {
		this.rank = card.substring(0, card.length() - 1);
		this.suit = card.charAt(card.length() - 1); 
	}
	
	public int getRankValue() {
		if("23456789".contains(rank)) {
			return Integer.parseInt(rank);
		}
		
		switch(rank) {
		case "T" : return 10;
		case "J" : return 11;
		case "Q" : return 12;
		case "K" : return 13;
		case "A" : return 14;
		default: return -1;
		}
	}
	@Override
	public String toString() {
		return rank + suit;
	}


	
	
}
