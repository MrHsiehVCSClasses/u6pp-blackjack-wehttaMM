package u6pp;

import java.util.Scanner;

public class Blackjack {
	
	private Scanner sc;
	
    public Blackjack(Scanner scanner) {
        this.sc = scanner;
        sc = new Scanner(System.in);
    }
	
    public void play() {
    	/*
    	 * Preconditions: To play the game of blackjack by interacting with the user
    	 * and taking in their response.
    	 * Postconditions: The dealer and the player are given a deck of cards to 
    	 * play the game of blackjack and a winner is chosen.
    	 */
    	//The method to be called to actually play a game. 
    	//This is where you implement the flow of the Game play.
    	System.out.println("Welcome to Blackjack! What is your name?");
    	String input = sc.next();
    	System.out.println("Hello " + input + " I am Gambletron 5000! Let's play some cards.");
    	while (true) {
    		//Deck ehllo = new Deck();
    		Card[] user = {Deck.deal(), Deck.deal()};
    		Card[] user2 = {Deck.deal(), Deck.deal()};
    		
    		System.out.println("Your Hand: " + user[0] + " " + user[1]);
            System.out.println("Dealer's Hand: " + user2[0] + " " + user2[1]);
    		
            //check to see if blackjack has been found
            if (isBlackjack(user)) {
            	System.out.println("Congrats " + input + ", you got a Blackjack!");
            	System.out.println("Result: User Wins");
            }
            // the user takes his turn
            else {
            	System.out.println("Would you like to (H)it or (S)tay: ");
            	String hitstay = sc.nextLine();
            	hitstay.toLowerCase();
            	
            	if (hitstay.equals("h")) {
            		user = hit(user);
                	System.out.println("Your new hand: " + user);
                	
                	if (isBust(user)) {
                		System.out.println(input + " I'm so sorry you busted!");
                		System.out.println("Result: User loses");
                	}
            	}
            	// other player takes their turn
            	else if (hitstay.equals("s")) {
            		while (dealerKeepHitting(user2)) {
                        user2 = hit(user2);
                    }
            		
            		String winner = determineResult(user, user2);
            		System.out.println("Result: " + winner);
            	}
            }
            System.out.println("Would you like to play again? (Y)es/(N)o: ");
        	String playagain = sc.nextLine();
        	playagain.toLowerCase();
        	if (!playagain.equals("y")) {
                System.out.println("Thanks for playing " + user + "! Have a great day!");
            }
    	}
    }
	
	
    @SuppressWarnings("unlikely-arg-type")
	public static int calcPoints(Card[] hand) {

    	// This method takes an array of Cards and returns the amount of points that hand is worth.

    	int points = 0;
    	
    	
		// for every card in your hand, add up the points its worth. (Calculate the points)
    	for (Card card : hand) {
    		if (card.getValue().equals("Ace")) {
        		points += 11;		
    		}
    		else if (card.getValue().equals("King")) {
    			points += 10;
    		}
    		else if (card.getValue().equals("Queen")) {
    			points += 10;
    		}
    		else if (card.getValue().equals("Jack")) {
    			points += 10;
    		}
    		else if (card.getValue().equals("10")) {
    			points += 10;
    		}
    		else if (card.getValue().equals("9")) {
    			points += 9;
    		}
    		else if (card.getValue().equals("8")) {
    			points += 8;
    		}
    		else if (card.getValue().equals("7")) {
    			points += 7;
    		}
    		else if (card.getValue().equals("6")) {
    			points += 6;
    		}
    		else if (card.getValue().equals("5")) {
    			points += 5;
    		}
    		else if (card.getValue().equals("4")) {
    			points += 4;
    		}
    		else if (card.getValue().equals("3")) {
    			points += 3;
    		}
    		else if (card.getValue().equals("2")) {
    			points += 2;
    		}
    	}
    	
//    	int points = (user[0] += user[1])
		return points;
    	
    }
    
    
    private Card[] hit(Card[] hand) {
        Card[] handv2 = new Card[hand.length + 1];
        handv2[hand.length] = Deck.deal();
        return handv2;
    }
	
	
    public static String determineResult(Card[] userHand, Card[] dealerHand) {
    	/*
    	 * Preconditions: uses calcPoints to compare with dealerpoints to see who wins
    	 * Postconditions: Returns a String in one of the following formats: "User Wins", "User Loses", or "User Pushes". Does not alter parameters.
    	 */
    	
    	int userPoints = calcPoints(userHand);
    	int dealerPoints = calcPoints(dealerHand);
    	
    	if (userPoints > dealerPoints) {
    		return "User Wins";
    	}
    	else if (userPoints < dealerPoints) {
    		return "User Loses";
    	}
    	else {
    		return "User Pushes";
    	}
    	
    	//
    }
	
    public static boolean isBust(Card[] hand) {
    	/*
    	 * Preconditions: checks to see if card busted
    	 * Postconditions: checks to see if card is over 21
    	 */
    // returns true if the hand is a Bust, false otherwise. Does not alter parameters.
    	return calcPoints(hand) > 21;
    	
    }
	
    public static boolean isBlackjack(Card[] hand) {
    	/*
    	 * Preconditions: checks to see if starting hand is 21
    	 * Postconditions: returns true if the hand is a Blackjack, false otherwise. Does not alter parameters.
    	 */

    	return hand.length == 2 && calcPoints(hand) == 21;
    	
    }
	
	
    public static boolean dealerKeepHitting(Card[] hand) {
    	/*
    	 * Preconditions: sets a dealer standard
    	 * Postconditions: return true if the dealer should keep hitting (score of hand is 16 or less), false otherwise. 
    	 */
    	return calcPoints(hand) <= 16;
    	
    }
	
	
	
	
	
	
}