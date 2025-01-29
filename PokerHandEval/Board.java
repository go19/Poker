package PokerHandEval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Board {
	
	private List<Card> cards;
	private int potsize;

	
	public Board (List<Card> cards) {
		this.cards = cards;
		//this.deck = deck;
		//sortCards();
		//System.out.println("This is deck: " + deck);
		//System.out.println("sorted cards: " + cards);
	}
	
	private void sortCards() {
		cards.sort(Comparator.comparingInt(Card::getRankValue));
	}
	
	

	public List<Card> dealFlop (){
		List<Card> flop = new ArrayList<>(cards.subList(0, 3));
		System.out.println(cards);
		return flop;
	}
	
	public List<Card> dealTurn(List<Card> Flop){
		
		List<Card> turn = new ArrayList<>();
		turn = cards.subList(0,4);
		System.out.println("turn : " + turn);
		return turn;
	}
	
	public List<Card> dealRiver(List<Card> Turn){
		
		List<Card> river = new ArrayList<>();
		river = cards.subList(0, 5);
		System.out.println("river: " + river);
		return river;
	}
	
	
	public void Bet() {
		
	}

	
	public void startFlopBetting(List<Card> flop, Board b, Player p1, Player p2) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("p1! X or B?");
		String input = scanner.nextLine().toLowerCase();
		
		//prepare turn card in advance
		int bet = 0;
		flop = b.dealTurn(flop);
		potsize = 0;
			
		if (input.equals("x")) {
			System.out.println("p2! X or B?");
			input = scanner.nextLine().toLowerCase();
			
			if(input.equals("x")) { 
				System.out.println("here is the turn: " + flop);
			}else {
				System.out.println("p2! how much do you want to bet?");
				input = scanner.nextLine().toLowerCase();
				bet = Integer.parseInt(input);
				p2.balance = p2.balance - bet;
				potsize += bet;
			
				System.out.println("p1! C or F p2's bet of $ " + bet + "?");
				input = scanner.nextLine().toLowerCase();
				if(input.equals("c")) {
					
					p1.balance = p1.balance - bet;
					potsize += bet;
					
				}else if(input.equals("f")) {
					System.out.println("p2! you win $ " + potsize);
					p2.balance += potsize;
				}
			}
		}else { 
			System.out.println("p1! how much do you want to bet?");
			input = scanner.nextLine().toLowerCase();
			bet = Integer.parseInt(input);
			potsize += bet;
			p1.balance = p1.balance - bet;
			System.out.println("p2! C or F p1's bet of $ " + bet + "?");
			
			input = scanner.nextLine().toLowerCase();
			if(input.equals("c")) {
				p2.balance = p2.balance - bet;
				potsize += bet;
				System.out.println("here is the turn: " + flop);
			}else {
				System.out.println("p1! you win $" + potsize);
				p1.balance += potsize;
			}
		}
		scanner.close();
	}
	
	
	
	
	public String evaluate() {
		Map<String, Integer> rankCount = getRankCounts();
		Map<Character, Integer> suitCount = getSuitCounts();
		  	
		boolean isFlush = suitCount.containsValue(5);
		boolean isStraight = checkStraight();
		
		if (isFlush && isStraight) {
			return "Straight Flush";
		}else if(rankCount.containsValue(4)) {
			return "Four of a Kind";
		}else if(rankCount.containsValue(3) && rankCount.containsValue(2)) {
			return "Full House";
		}else if(isFlush) {
			return "Flush";
		}else if(isStraight) {
			return "Straight";
		}else if(rankCount.containsValue(3)) {
			return "Three of a Kind";
		}else if(Collections.frequency(new ArrayList<>(rankCount.values()),2)==2){
			return "Two Pair";
		}else if(rankCount.containsValue(2)) {
			return "One Pair.";
		}else {
			return "High Card.";
		}
	}

	private boolean checkStraight() {
		for(int i = 0; i <cards.size()-1; i++) {
			if(cards.get(i+1).getRankValue() - cards.get(i).getRankValue() != 1) {
				return false;
			}
		}
		return true;
	}
	
	private Map<String, Integer> getRankCounts(){
		Map<String, Integer> rankCount = new HashMap<>();
		int i = 0; 
		
		for (Card c : cards) {
			i = rankCount.getOrDefault(c.rank,0) + 1;
			rankCount.put(c.rank, i);
			//System.out.println(c.rank +  " here: " + rankCount.get(c.rank));
			//rankCount.put(c.rank, rankCount.getOrDefault(c.rank,0) +1 );
		}
		return rankCount;	
	}
	private Map<Character, Integer> getSuitCounts(){
		Map<Character, Integer> suitCount = new HashMap<>();
		int i = 0;
		
		for(Card c : cards) {
			i = suitCount.getOrDefault(c.suit, 0) + 1;
			suitCount.put(c.suit, i);
			//System.out.println(card.suit +  " here: " + suitCount.get(card.suit));
		}
		return suitCount;
	}
}
