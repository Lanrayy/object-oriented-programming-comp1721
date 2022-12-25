package comp1721.cwk2;

import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a Baccarat playing hand.
 * Inherits from the CardCollection class.
 *
 * @author Olanrewaju Sodeinde
 */
//The Baccarat Hand class
public class BaccaratHand extends CardCollection{

    protected List<BaccaratCard> cards;

    /**
     * Creates an empty Baccarat Hand.
     */
    public BaccaratHand() {
        cards = new LinkedList<>();
    }


    /**
     * Returns a two character string representation for each card in the hand
     * Overwrites toString() method from CardCollection class
     */
    @Override
    public String toString() {
        String output = "";

        for (BaccaratCard c : cards) {
            output = output + c.toString() + " ";
        }
        return output.trim();
    }

    /**
     * Adds the given card to this collection.
     *
     * @param c Card to be added
     */
    public void add(BaccaratCard c) {
        cards.add(c);
    }

    /**
     * Calculates the sum in the hand and checks to see whether the hand is natural
     *
     * @return true or false
     */
    public boolean isNatural(){
        int sum = 0;

        for(BaccaratCard c: cards){
            sum = sum + c.value();
        }

        if(sum == 9 || sum == 8){
            return true;
        }
        return false;
    }

    /**
     * Calculates the value of the hand
     *
     * If the value of the hand is double digits, the first digit is dropped
     * @return The value of the hand
     */
    @Override
    public int value() {
        int output;
        int sum = 0;
        for (BaccaratCard card: cards) {
            sum += card.value();
        }

        if(sum >= 10 && sum < 20){
            output = sum - 10;
        }else if(sum >= 20 && sum < 30){
            output = sum - 20;
        }else if(sum >= 30 && sum < 40){
            output = sum - 30;
        }
        else{
            output = sum;
        }

        return output;
    }

    /**
     * Provides the number of cards in the hand.
     *
     * @return Number of cards
     */
    public int size() {
        return cards.size();
    }
}
