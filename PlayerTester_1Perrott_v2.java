// Name: Samuel Perrott
// Assignment: AList-A10: Player and Hand classes 

import java.util.ArrayList;
import java.util.Scanner;

enum Symbol {SPADES, CLUBS, DIAMONDS, HEARTS};

/**
   The PlayerTester class tests the Player class
   by calling its methods add and getUserChoice.
      
   @author Samuel Perrott
*/
public class PlayerTester_1Perrott_v2 {
   
   /**
      Main method that calls methods on
      Player class.
      
      @param args standard input
   */
   public static void main(String[] args) {
      // Create the deck:
      Deck deck = new Deck();
      
      // Create the player hand:
      Player player = new Player();
      
      // Deal 2 cards to the hand (don't show the cards yet)
      Card dealtCard = deck.deal();
      player.add(dealtCard);
      dealtCard = deck.deal();
      player.add(dealtCard);
      
      // Then you can display the cards:
      System.out.println(player);
            
      // then ask user for additional cards (repeatedly):
      while (player.getUserChoice() == 'H') {
        // If they "hit", then deal another card to the hand
        dealtCard = deck.deal();
        player.add(dealtCard);
        // Then you can display the cards and value of hand:
        System.out.println("\n" + player);
      }
      
      System.out.println("Thanks for playing!");      
   }
   
}

/**
   Player class representing a Blackjack player.
   Said player can choose to hit or stay via
   the getUserChoice method. If hit is chosen,
   a card is added to the hand via the add method.
*/
class Player {

   private Hand hand;
   
   /**
      No-args constructor that instantiates hand.
   */
   public Player() {
      hand = new Hand();
   }
   
   /**
      Add method adds a card to the player's hand.
      
      @param dealtCard is the Card object to be added to hand
   */
   public void add(Card dealtCard) {
      hand.add(dealtCard);
   }
   
   
   /**
      Determines whether the user wants to hit or stay.
      
      @return H representing "hit" or S representing "stay"
   */
   public char getUserChoice() {
      Scanner input = new Scanner(System.in);
      boolean validChoice = false;
      char choice;
      do {
         System.out.print("Enter \"H\" for hit or \"S\" for stay: ");
         choice = input.next().toUpperCase().charAt(0);
         if (choice == 'H' || choice == 'S') validChoice = true;
         else System.out.println("Sorry, please try again.");
      } while (!validChoice);
      return choice;
   }
   
   /**
      Prints out cards in hand
      (including the hand's total Blackjack value).
      
      @return description of hand
   */
   public String toString() {
      return "" + hand + "\n";
   }
   
}

/**
   Hand class represents a player's hand
   of cards in a game of Blackjack and
   has methods such as add and getHandValue.
*/
class Hand {

   private ArrayList<Card> cards;
   
   /**
      No-args constructor to instantiate the ArrayList
      cards that holds the cards in the hand.
   */
   public Hand() {
      cards = new ArrayList<>();
   }
   
   /**
      Adds the card dealt by the dealer to the hand.
      
      @param dealtCard the card to be added to the hand
   */
   public void add(Card dealtCard) {
      cards.add(dealtCard);
   }
   
   /**
      Returns the hand's Blackjack value, which is
      the sum of the point values of each card where
      an ace is counted as 1 unless counting the ace as
      11 will not cause the hand's total value to
      exceed 21. The point value of a face card is
      counted as 10. All number cards have the same
      point value as their number.
      
      @return the Blackjack value of the hand
   */
   public int getHandValue() {
      int handValue = 0, aceCount = 0;
      for (Card c : cards)
         if (c.getValue() != 1) handValue += c.getValue();
         else aceCount++;
      for (int i = 0; i < aceCount; i++)
         if (21 - handValue >= 10) handValue += 11;
         else handValue++;
      return handValue;
   }
   
   /**
      Returns a description of each card in the hand
      (including the card's point value) as well as
      the total hand value.
      
      @return a String description of the hand and its Blackjack value
   */
   public String toString() {
      String info = "";
      for (Card c : cards)
         info += "" + c + "\n";
      return info + "hand value = " + getHandValue();
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
   
   /**
      Constructor that initializes a card's
      rank, suit, and Blackjack point value.
      
      @param rank an integer between 1 and 13 inclusive corresponding to Ace through King
      @param suit the card's suit
   */
   public Card(int rank, Symbol suit) {
      this.rank = rank;
      this.suit = suit;
      if (rank > 10) value = 10;
      else value = rank;
   }
   
   /**
      Gets the value of the card. An ace's value is
      default set to 1.
      
      @return Blackjack value of the card
   */
   public int getValue() {
      return value;
   }
   
   /**
      Returns a description of the card, with its face value,
      suit, and Blackjack point value.
      
      @return a String describing the card
   */
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

   private ArrayList<Card> cardStack;
   
   /**
      No args constructor that instantiates
      and initializes the ArrayList cardStack
      with the 52 standard playing cards,
      shuffled.
   */
   public Deck() {
      cardStack = new ArrayList<>(52);
      for (int i = 1; i < 14; i++) {
         cardStack.add(new Card(i, Symbol.SPADES));
         cardStack.add(new Card(i, Symbol.CLUBS));
         cardStack.add(new Card(i, Symbol.DIAMONDS));
         cardStack.add(new Card(i, Symbol.HEARTS));
      }
      shuffle();
   }
   
   /**
      Shuffles the ArrayList cardStack.
   */
   public void shuffle() {
      for (int i = 0; i < cardStack.size(); i++) {
         cardStack.set(i, cardStack.set((int)(Math.random()*cardStack.size()), cardStack.get(i)));
      }
   }

   /**
      Deals out a card from the ArrayList cardStack.
      The dealt card is removed from cardStack.
      
      @return the Card object representing the card dealt
   */
   public Card deal() {
      return cardStack.remove(cardStack.size() - 1);
   }
   
}