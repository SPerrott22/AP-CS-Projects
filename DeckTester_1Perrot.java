// Name: Samuel Perrott
// Assignment: AList-A7: Deck o' Cards 

import java.util.ArrayList;

enum Symbol {SPADES, CLUBS, DIAMONDS, HEARTS};

/**
   The DeckTester class tests the Deck class
   by creating and dealing out a deck of 
   cards.
      
   @author Samuel Perrott
*/
public class DeckTester_1Perrot {

   public static void main(String[] args) {
      System.out.println("Testing Deck:\n");
      Deck d = new Deck();      
      d.shuffle();      
      for (int i = 0; i < 52; i++) {
         System.out.println(d.deal());
      }      
   }
   
}

/**
   Objects of the Card class represent
   one of the 52 possible playing cards
   (excluding jokers), and have the
   attributes rank, suit, and Blackjack
   playing value. 
*/
class Card {

   private int rank, value;
   private Symbol suit;
   
   public Card(int rank, Symbol suit) {
      this.rank = rank;
      this.suit = suit;
      if (rank > 10) value = 10;
      else value = rank;
   }
   
   public int getValue() {
      return value;
   }
   
   public String toString() {
      if (rank == 1 || rank > 10)
         switch (rank) {
         // no break statements needed because return terminates method.
            case 1:
               // Blackjack rules allow players to count an Ace as either 1 or 11.
               return "Ace of " + suit + " (point value = " + value + " or 11)";
            case 11:
               return "Jack of " + suit + " (point value = " + value + ")";
            case 12:
               return "Queen of " + suit + " (point value = " + value + ")";
            case 13:
               return "King of " + suit + " (point value = " + value + ")";
         }
      return rank + " of " + suit + " (point value = " + value + ")";
   }
   
}

/**
   Objects of the Deck class represent a deck
   of 52 playing cards. These cards are
   stored in an ArrayList that is shuffled
   via the shuffle method (which the 
   constructor calls). The deal method
   removes the last card in the deck and
   returns it.
*/
class Deck {

   private ArrayList<Card> cards;
   
   public Deck() {
      cards = new ArrayList<>(52);
      for (int i = 1; i < 14; i++) {
         cards.add(new Card(i, Symbol.SPADES));
         cards.add(new Card(i, Symbol.CLUBS));
         cards.add(new Card(i, Symbol.DIAMONDS));
         cards.add(new Card(i, Symbol.HEARTS));
      }
      shuffle();
   }
   
   public void shuffle() {
      for (int i = 0; i < cards.size(); i++) {
         cards.set(i, cards.set((int)(Math.random()*cards.size()), cards.get(i)));
      }
   }

   
   public Card deal() {
      return cards.remove(cards.size() - 1);
   }
   
}