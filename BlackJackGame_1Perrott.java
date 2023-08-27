// Name: Samuel Perrott
// Assignment: Inherits-A6: BlackJack Game 

import java.util.ArrayList;
import java.util.Scanner;

enum Symbol {SPADES, CLUBS, DIAMONDS, HEARTS};

/**
   The BlackJackGame_1Perrott class houses
   the main method that plays a BlackJackGame
   by calling play() on a BlackJackGame
   object.
   
   @author Samuel Perrott
*/
public class BlackJackGame_1Perrott {
   /**
      Main method that creates an instance
      of BlackJackGame and calls play() on it.
      
      @param args an array of String
   */
   public static void main(String[] args) {
      BlackJackGame b = new BlackJackGame(new Scanner(System.in));
      b.play();
   }
}

/**
   Class containing all the necessary
   fields and methods to execute a 
   game of blackjack.
*/
class BlackJackGame {
   private Deck deck;
   private Dealer dealer;
   private ArrayList<Player> players;
   private ArrayList<Hand> rankings;
   private Scanner input;
   
   /**
      Constructor that initializes all fields, such as the players
      in the game, the leaderboards (rankings), and the deck.
      
      @param input Scanner to retrieve player's names and move choices.
   */
   public BlackJackGame(Scanner input) {
      players = new ArrayList<>();
      rankings = new ArrayList<>();
      this.input = input;
      deck = new Deck();
      dealer = new Dealer("Dealer");
      
      System.out.println("*********************BLACKJACK*********************");
      System.out.println("Overview: you are dealt 2 cards. The total value of");
      System.out.println("your hand is equal to the sum of the number values");
      System.out.println("of your cards (facecards all count as 10 though).");
      System.out.println("Aces can count as either 1 or 11. The goal is to");
      System.out.println("obtain a hand as close to 21 as possible");
      System.out.println("without surpassing 21. You may \"hit\" to draw");
      System.out.println("more cards until you are satisified with your hand;");
      System.out.println("or you exceed 21 and \"bust.\" If your hand is closer to");
      System.out.println("21 than the dealer's (without going over), you win.");
      System.out.println("***************************************************");
      
      System.out.println("\nGood luck!\n");
      
      do {
         System.out.println("Enter player's name: ");
         players.add(new Player(input.nextLine()));
         System.out.print("Would you like to add more players? ");
      } while (Character.toUpperCase(input.nextLine().charAt(0)) == 'Y');
      for (Player p : players) {
         rankings.add(p);
      }
      rankings.add(dealer);
      System.out.println();
   }
   
   /**
      Core of Blackjack game's operations. Deals
      2 cards per player in the beginning and then
      proceeds to deal more as requested. The
      dealer earns a point every time a player loses
      and each player earns a point for every win.
   */
   public void play() {
      Card dealtCard = null;
      do {
         // Deal 2 cards to the hands (don't show the cards yet)
         for (Player p : players) {
            p.clear();
            dealtCard = deck.deal();
            p.add(dealtCard);
            dealtCard = deck.deal();
            p.add(dealtCard);
         }
         
         // Deal 2 cards to the dealer
         dealer.clear();
         dealtCard = deck.deal();
         dealer.add(dealtCard);
         dealtCard = deck.deal();
         dealer.add(dealtCard);
         
         // Then you can display the cards:
         for (Player p : players) {
            System.out.println(p + "\n");
         }
         
         System.out.println("Dealer's Hand:\n" + dealer);
               
         // then ask user for additional cards (repeatedly):
         for (Player p : players) {
            System.out.print(p.getName() + ": ");
            while (p.getUserChoice() == 'H') {
               System.out.println();
               // If they "hit", then deal another card to the hand
               dealtCard = deck.deal();
               p.add(dealtCard);
               System.out.println(p + "\n");
               if (Math.abs(p.getHandValue()) > 21) {
                  break;
               }            
            }
            System.out.println();
         }
         
         // ask dealer for cards:
         while (dealer.getAnother()) {
            dealtCard = deck.deal();
            dealer.add(dealtCard);
         }
         
         System.out.println(dealer.endDisplay());
         
         for (Player p : players) {
            System.out.println("\n" + p + "\n");
            if (Math.abs(p.getHandValue()) > 21) {
               if (Math.abs(dealer.getHandValue()) > 21) {
                  System.out.println("Both " + p.getName() + " and the dealer busted.");
               } else {
                  System.out.println("The dealer beat " + p.getName() + ".");
                  dealer.addPoint();
               }
            } else if (Math.abs(dealer.getHandValue()) > 21) {
               System.out.println(p.getName() + " beat the dealer!");
               p.addPoint();
            } else if (Math.abs(p.getHandValue()) > Math.abs(dealer.getHandValue())) {
               System.out.println(p.getName() + " beat the dealer!");
               p.addPoint();
            } else if (Math.abs(p.getHandValue()) == Math.abs(dealer.getHandValue())) {
               System.out.println(p.getName() + " tied with the dealer.");
            } else {
               System.out.println("The dealer beat " + p.getName() + ".");
               dealer.addPoint();
            }
         }
         
         System.out.println("\n" + scoreboard());
                 
         System.out.println("Would you like to play another round?");  
      } while (input.nextLine().charAt(0) == 'Y');
      
      System.out.println("Final " + scoreboard());
      System.out.println("Thanks for playing!\n");      
      
   }
   
   /**
      Returns the leaderboards of the game. The
      dealer and players are ranked based on how
      many points they have.
      
      @return String the leaderboards to be printed out
   */
   public String scoreboard() { 
      for (int i = 0; i < rankings.size() - 1; i++) {
         int maxIndex = i;
         for (int j = i + 1; j < rankings.size(); j++) {
            if (rankings.get(j).getPoints() > rankings.get(maxIndex).getPoints()) maxIndex = j;
         }
         rankings.set(i, rankings.set(maxIndex, rankings.get(i)));
      }
      
      String billboard = "Scoreboard:";
      billboard += "\n------------------------------------";
      billboard += "\n Rank | Points | Name";
      billboard += "\n------------------------------------";
      for (int i = 1; i <= rankings.size(); i++) {
         billboard += "\n " + i + "    | " + rankings.get(i - 1).getPoints()+ "      | " + rankings.get(i - 1).getName();
      }
      billboard += "\n------------------------------------";
      return billboard;
   }       

}

/**
   The player that represents the house is the dealer. The dealer
   follows an algorithm to determine whether or not to hit or
   stay. The Dealer class inherits methods of the Hand class
   to use such as add() and clear() in order to manage the
   dealer's hand without creating additional methods.
*/
class Dealer extends Hand {
   
   /**
      Constructor that calls the Hand constructor
      but gives a specific name for the dealer.
      In this program, the dealer's name
      is automatically set as "Dealer" in the BlackJackGame
      constructor.
      
      @param name is the Dealer's name 
   */
   public Dealer(String name) {
      super(name);
   }
         
   /**
      Returns true when the dealer's hand value is at most 16 or
      if it is 17 but with an ace counted as 11.
   
      @return whether the dealer should get another card
   */
   public boolean getAnother() {
      if (Math.abs(getHandValue()) <= 16
          || getHandValue() == -17) return true;
      else return false;
   }
   
   /**
      Returns a description of the dealer's hand, excluding the
      bottom card. Overrides the Hand toString because it hides
      the bottom card.
      
      @return description of dealer's hand without bottom card
   */
   @Override
   public String toString() {
      return dealerDisplay() + "\n";
   }
   
   /**
      Displays all cards in dealer's hand along with total value of
      the hand.
      
      @return description of dealer's entire hand
   */
   public String endDisplay() {
      return super.toString();
   }
   
}

/**
   Player class representing a Blackjack player.
   Said player can choose to hit or stay via
   the getUserChoice method. If hit is chosen,
   a card is added to the hand via the add method.
*/
class Player extends Hand {   
   
   /**
      Calls the Hand constructor and passes
      in the player's name as determined
      from the user.
      
      @param name the player's name
   */
   public Player(String name) {
      super(name);
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
         
}

/**
   Hand class represents a player's hand
   of cards in a game of Blackjack and
   has methods such as add and getHandValue.
*/
class Hand {
   
   private String name;
   private int wins;
   private ArrayList<Card> cards;
   
   /**
      No-args constructor to instantiate the ArrayList
      cards that holds the cards in the hand.
   */
   public Hand(String name) {
      this.name = name;
      wins = 0;
      cards = new ArrayList<>();
   }
   
   /**
      Clears the player's hand after a game
      so they can receive new cards without
      the old points adding on top.
   */
   public void clear() {
      cards.clear();
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
         else {
            aceCount++;
            handValue++;
         }
      for (int i = 0; i < aceCount; i++)
         if (handValue <= 11) {
            ace11 = true;
            handValue += 10;
         }
      if (ace11) handValue *= -1;
      return handValue;
   }
   
   /**
      Increments the number of wins for this
      player/dealer.
   */
   public void addPoint() {
      wins++;
   }
   
   /**
      Returns the player's/dealer's point
      total.
      
      @return int the total number of hands won.
   */
   public int getPoints() {
      return wins;
   }
   
   /**
      Returns a description of each card in the hand
      (including the card's point value) as well as
      the total hand value.
      
      @return a String description of the hand and its Blackjack value
   */
   public String toString() {
      String info = name + "'s hand:\n";
      for (Card c : cards)
         info += "" + c + "\n";
      info += "hand value = " + Math.abs(getHandValue());
      if (Math.abs(getHandValue()) > 21) {
         info += "\n\n" + name + " busted!";
      }
      return info;
   }
   
   /**
      Returns the player's/dealer's name.
      
      @return String the player's/dealer's name
   */
   public String getName() {
      return name;
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
      fillDeck();
   }
   
   /**
      Resupplies the deck to 52 cards and reshuffles it.
      This method is called once the number of cards in the deck
      goes below 26.
   */
   public void fillDeck() {
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
      Card dealtCard = cardStack.remove(cardStack.size() - 1);
      if (cardStack.size() < 26) {
         cardStack.clear();
         fillDeck();
      }
      return dealtCard;
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
