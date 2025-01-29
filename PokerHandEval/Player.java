package PokerHandEval;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	String name;
	int balance;
	
	public Player(String name, int balance){
		this.name = name;
		this.balance = balance;

	}

	
	public List<Card> receiveHand(Player p, Deck d) {
		
		List<Card> hand = new ArrayList<>();
		return hand;
	}

}
