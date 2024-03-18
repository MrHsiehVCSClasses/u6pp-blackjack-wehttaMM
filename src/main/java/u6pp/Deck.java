package u6pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

//import java.util.Random;

// Creates 52 unique Cards based on the potential values and suits
public class Deck {
    //	private static Object length;
    /*
     * Pre-conditions: makes the deck of 52 cards
     * Post-Conditions: sets the 4 suits to the 13 values of cards and puts them into an array
     */
    private int deckNumber = 52;
    private Card[] deck = new Card[deckNumber];
    private static int currentIndex = 0;
    private static List<Card> cards; // makes card list specific to the array

    public Deck() {
        int cardIndex = 0;
        cards = new ArrayList<>();
        for (String suit : Card.SUITS) {
            for (String value : Card.VALUES) {
                Card card = new Card(suit, value);
                deck[cardIndex++] = card;
                cards.add(card);
            }
        }
        currentIndex = 0;
    }


    //Returns how many "un-dealt" cards are in Deck
    public int numLeft() {
        return cards.size() - currentIndex;
    }

    public static Card deal() {
//		private static Object length;
        /*
         * Pre-conditions: deal cards and put them in the array
         * Post-Conditions: returns top card if the current index is less than the size of the cards
         */
        if (currentIndex < cards.size()) {
            Card cardy = cards.get(currentIndex);
            currentIndex++;

            return cardy;
        } else {
            return null;
        }
    }

    //Restores the Deck to "full" and randomizes the order of the Cards to be dealt
    public void shuffle() {
        currentIndex = 0;
        Collections.shuffle(cards);
    }
}