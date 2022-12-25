package comp1721.cwk2;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Representation of a Baccarat Shoe.
 * Inherits from the CardCollection class.
 *
 * @author Olanrewaju Sodeinde
 */

public class Shoe extends CardCollection{
    protected List<BaccaratCard> cards = new LinkedList<>();

    /**
     * Default constructor for creating a shoe.
     *
     * @param decks The number of decks that should be in the shoe
     * @throws CardException if number of decks is not 6 or 8
     */
    public Shoe(int decks){
        if(decks == 6 || decks == 8){
            makeShoe(decks);
        }else{
            throw new CardException("Illegal number of decks");
        }
    }


    /**
     * This method returns the number of Card objects in the shoe
     *
     */
    public int size() {
        return cards.size();
    }


    /**
     * This method shuffles all the cards in the shoe
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }


    /**
     * The method removes and returns the first card from the shoe
     */
    public BaccaratCard deal(){
        if(cards.isEmpty()){
            throw new CardException("Shoe is empty");
        }

        return cards.remove(0);
    }


    /**
     * This method creates the specified number of decks
     *
     * @param decks The number of decks to be added to shoe
     */
    private void makeShoe(int decks){
        int num = decks;
        while(num > 0)
        {
            //Create a full deck of Baccarat Cards & adds it to shoe
            for(Card.Suit s: Card.Suit.values()){
                for(Card.Rank r: Card.Rank.values()){
                    //get the symbol for the rank and suit for each card
                    String rankSymbol = r.toString().toUpperCase();
                    String suitSymbol = s.toString().toUpperCase();

                    //create a new rank and suit with the symbols
                    Card.Rank cardRank = Card.Rank.valueOf(rankSymbol);
                    Card.Suit cardSuit = Card.Suit.valueOf(suitSymbol);

                    //create a new card baccarat card object and add it to the shoe
                    BaccaratCard card = new BaccaratCard(cardRank, cardSuit);
                    cards.add(card);
                }
            }
            num--;
        }
    }

}