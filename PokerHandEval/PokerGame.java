package PokerHandEval;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
	
	public static void main (String[] args) {
	
		Deck deck = new Deck();
		deck.shuffle();
		
		
		List<Card> p1hand = new ArrayList<>();
		p1hand = deck.dealplayerhand();
		
		List<Card> p2hand = new ArrayList<>();
		p2hand = deck.dealplayerhand();
		
		System.out.println("here is p1's hand: " + p1hand);
		System.out.println("here is p2's hand: " + p2hand);
		
		Player p1 = new Player("Jim", 100);
		Player p2 = new Player("Qayfong", 122);

		
		
		Board b = new Board(deck.uniqueDeck());
				

		
		
	
		
		
		

		List<Card> flop = b.dealFlop();
		System.out.println("here is the flop : " + flop);
		

		
		b.startFlopBetting(flop, b,p1,p2);
		
		
		
		
		System.out.println("p1 balance " + p1.balance);
		System.out.println("p2 balance " + p2.balance);
	

		
		
		
		
		
		
	}

}
