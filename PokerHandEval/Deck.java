package PokerHandEval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		String[] ranks = {"2", "3","4","5","6","7","8","9", "10", "J", "Q","K","A"};
		char[] suits = {'H','D','S','C'};
		
		for (String r : ranks) {
			for (char s :suits) {
				//.out.println("here " + cards);
				cards.add(new Card(r + s));
			}
		}
	}
	
	public List<Card> uniqueDeck(){
		//System.out.println(cards);
		return cards;
	}
	
	
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
	public List<Card> dealplayerhand(){
			
		List<Card> hand = new ArrayList<>();
		Random rand = new Random();
		int r = rand.nextInt(cards.size());
		
		cards.get(r);
		hand.add(cards.get(r));
		cards.remove(r);
		
		r = rand.nextInt(cards.size());
		hand.add(cards.get(r));
		cards.remove(r);

		return hand;
		
	}
	
	
	
}
