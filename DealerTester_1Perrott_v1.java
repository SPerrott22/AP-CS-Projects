// Name: Samuel Perrott
// Assignment: AList-A11: Dealer Class 

import java.util.ArrayList;
import java.util.Scanner;

enum Symbol {SPADES, CLUBS, DIAMONDS, HEARTS};

/**
   The DealerTester class tests the Dealer class
   by calling its add, getAnother, endDisplay,
   and toString methods.
      
   @author Samuel Perrott
*/
public class DealerTester_1Perrott_v1 {
   
   /**
      Main method that calls methods on
      Dealer and Player classes.
      
      @param args standard input
   */
   public static void main(String[] args) {
      // ROUND 1
      System.out.println("************\nROUND 1\n************\n");
      
      // Create the deck:
      Deck deck = new Deck();
      
      // Create the dealer hand:
      Dealer dealer = new Dealer();
      
      // Create the player hand:
      Player player = new Player();
      
      // Deal 2 cards to the hands (don't show the cards yet)
      Card dealtCard = deck.deal();
      player.add(dealtCard);
      dealtCard = deck.deal();
      player.add(dealtCard);
      
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      // Then you can display the cards:
      System.out.println("Player's Hand:\n" + player);
      System.out.println("Dealer's Hand:\n" + dealer);
            
      // then ask user for additional cards (repeatedly):
      while (player.getUserChoice() == 'H') {
        // If they "hit", then deal another card to the hand
        dealtCard = deck.deal();
        player.add(dealtCard);
        // Then you can display the cards and value of hand:
        System.out.println("\nPlayer's Hand:\n" + player);
      }
      
      // ask dealer for cards:
      while (dealer.getAnother()) {
         dealtCard = deck.deal();
         dealer.add(dealtCard);
      }
      
      System.out.println("\nDealer's Hand:\n" + dealer.endDisplay());
      
      System.out.println("Thanks for playing!\n");
      
      // ROUND 2
      System.out.println("************\nROUND 2\n************\n");
      
      // Create the deck:
      deck = new Deck();
      
      // Create the dealer hand:
      dealer = new Dealer();
      
      // Create the player hand:
      player = new Player();
      
      // Deal 2 cards to the hands (don't show the cards yet)
      dealtCard = deck.deal();
      player.add(dealtCard);
      dealtCard = deck.deal();
      player.add(dealtCard);
      
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      // Then you can display the cards:
      System.out.println("Player's Hand:\n" + player);
      System.out.println("Dealer's Hand:\n" + dealer);
            
      // then ask user for additional cards (repeatedly):
      while (player.getUserChoice() == 'H') {
        // If they "hit", then deal another card to the hand
        dealtCard = deck.deal();
        player.add(dealtCard);
        // Then you can display the cards and value of hand:
        System.out.println("\nPlayer's Hand:\n" + player);
      }
      
      // ask dealer for cards:
      while (dealer.getAnother()) {
         dealtCard = deck.deal();
         dealer.add(dealtCard);
      }
      
      System.out.println("\nDealer's Hand:\n" + dealer.endDisplay());
      
      System.out.println("Thanks for playing!\n");           

      // ROUND 3
      System.out.println("************\nROUND 3\n************\n");
      
      // Create the deck:
      deck = new Deck();
      
      // Create the dealer hand:
      dealer = new Dealer();
      
      // Create the player hand:
      player = new Player();
      
      // Deal 2 cards to the hands (don't show the cards yet)
      dealtCard = deck.deal();
      player.add(dealtCard);
      dealtCard = deck.deal();
      player.add(dealtCard);
      
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      dealtCard = deck.deal();
      dealer.add(dealtCard);
      // Then you can display the cards:
      System.out.println("Player's Hand:\n" + player);
      System.out.println("Dealer's Hand:\n" + dealer);
            
      // then ask user for additional cards (repeatedly):
      while (player.getUserChoice() == 'H') {
        // If they "hit", then deal another card to the hand
        dealtCard = deck.deal();
        player.add(dealtCard);
        // Then you can display the cards and value of hand:
        System.out.println("\nPlayer's Hand:\n" + player);
      }
      
      // ask dealer for cards:
      while (dealer.getAnother()) {
         dealtCard = deck.deal();
         dealer.add(dealtCard);
      }
      
      System.out.println("\nDealer's Hand:\n" + dealer.endDisplay());
      
      System.out.println("Thanks for playing!\n");           
   }
   
}

class Dealer {

   private Hand hand;
   
   /**
      No-args constructor that instantiates hand.
   */
   public Dealer() {
      hand = new Hand();
   }
   
   /**
      Add method adds a card to the dealer's hand.
      
      @param dealtCard is the Card object to be added to hand
   */
   public void add(Card dealtCard) {
      hand.add(dealtCard);
   }
   
   /**
      Returns true when the dealer's hand value is at most 16 or
      if it is 17 but with an ace counted as 11.
   
      @return whether the dealer should get another card
   */
   public boolean getAnother() {
      if (Math.abs(hand.getHandValue()) <= 16
          || hand.getHandValue() == -17) return true;
      else return false;
   }
   
   /**
      Returns a description of the dealer's hand, excluding the
      bottom card.
      
      @return description of dealer's hand without bottom card
   */
   public String toString() {
      return hand.dealerDisplay() + "\n";
   }
   
   /**
      Displays all cards in dealer's hand along with total value of
      the hand.
      
      @return description of dealer's entire hand
   */
   public String endDisplay() {
      return "" + hand + "\n";
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
      point value as their number. If an ace is
      counted as 11, the returned value is the negative
      of the point value. This is useful for the
      dealer's calculation.
      
      @return the Blackjack value of the hand
   */
   public int getHandValue() {
      int handValue = 0, aceCount = 0;
      boolean ace11 = false;
      for (Card c : cards)
         if (c.getValue() != 1) handValue += c.getValue();
         else aceCount++;
      for (int i = 0; i < aceCount; i++)
         if (21 - handValue >= 10) {
            ace11 = true;
            handValue += 11;
         } else handValue++;
      if (ace11) handValue *= -1;
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
      return info + "hand value = " + Math.abs(getHandValue());
   }
   
   /**
      Returns a description of the hand excluding the first card
      in the hand (i.e. the bottom card). Total point value calculation
      is excluded because of the unknown card.
   
      @return description of dealer's hand with bottom card hidden
   */
   public String dealerDisplay() {
      String info = "";
      for (int i = 1; i < cards.size(); i++) {
         info += "\n" + cards.get(i);
      }
      return "bottom card hidden" + info;
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
      for (int k = cardStack.size() - 1; k >= 0; k--) {
         cardStack.set(k, cardStack.set((int)(Math.random()*(k+1)),
                                        cardStack.get(k)));
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
