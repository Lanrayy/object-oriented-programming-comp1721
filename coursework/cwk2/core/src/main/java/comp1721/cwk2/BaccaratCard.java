package comp1721.cwk2;

/**
 * Representation of a Baccarat playing card.
 * Inherits from the Card class.
 *
 * @author Olanrewaju Sodeinde
 */
public class BaccaratCard extends Card{
    /**
     * Default two parameter constructor for Baccarat Card class.
     *
     * @param r .Rank of the BaccaratCard object
     * @param s .Suit of the BaccaratCard object
     */
    public BaccaratCard(Card.Rank r, Card.Suit s){
        super(r,s);
    }


    /**
     * Calculates and returns the value of each baccarat card.
     *Face cards return a value of 0.
     *
     * @return the value of the baccarat card.
     */
    @Override
    public int value() {
        int value = super.value();

        if(value == 10){
            return 0;
        }
        return value;
    }
}
