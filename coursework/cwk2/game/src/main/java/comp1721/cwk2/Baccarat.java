package comp1721.cwk2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Baccarat Class containing the main game loop .
 *
 * @author Olanrewaju Sodeinde
 */
public class Baccarat {
    private static int roundNumber = 1;
    private static int playerWins = 0;
    private static int bankerWins = 0;
    private static int ties = 0;
    private static boolean gamePlaying = true;

    public static void main(String[] args){
        Shoe shoe = null;

        //Check if default or automatic mode
        if(args.length == 0) {
            System.out.println("Default mode");

            //Create a shoe for the game and shuffle the shoe
            //NOTE: Number of decks can be either 6 or 8 but in the default mode,
            // the game is played without any human interaction
            shoe = new Shoe(6);
            shoe.shuffle();
        }
        else if(args.length == 1 && args[0].equals("-i")){
            System.out.println("Interactive mode");

            //Prompt user for the number of decks in the shoe;
            int numOfDecks = askForDecksInShoe();

            //Create a shoe for the game
            try{
                shoe = new Shoe(numOfDecks);
            } catch(CardException | NullPointerException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }

            //Shuffle the shoe
            shoe.shuffle();

        }
        else
        {
            System.out.println("Please supply the right command line argument (\"i\")");
        }

        //The main game loop
        while(gamePlaying)
        {
            //Display round number
            System.out.printf("\nRound %d \n", roundNumber);

            //Create hands and shoe
            BaccaratHand player = new BaccaratHand();
            BaccaratHand banker = new BaccaratHand();


            //Deal player's  and banker hands
            Card.useFancySymbols(true);
            assert shoe != null;
            Baccarat.dealHands(player, shoe);
            Baccarat.dealHands(banker, shoe);



            //Check the winner
            if(player.value() == 8 || player.value() == 9 || banker.value() == 8
                    || banker.value() == 9 )
            {
                //Displaying hands
                Baccarat.displayHands(player, banker);
                Baccarat.displayWinner(player, banker);
            }
            else if(player.value() == 6 || player.value() == 7)
            {
                Baccarat.displayHands(player, banker);
                if(banker.value() >= 0 && banker.value() <= 5){
                    System.out.println("Dealing third card to banker...");
                    dealThirdCard(banker, shoe);
                    Baccarat.displayHands(player, banker);
                }


                Baccarat.displayWinner(player, banker);

            }
            else
            {
                // if player value is between 0 & 5
                Baccarat.displayHands(player, banker);
                int bankerValue = banker.value();
                BaccaratCard playerThirdCard;

                System.out.println("Dealing third card to player...");
                playerThirdCard = dealThirdCard(player, shoe);

                if(bankerValue <= 2)
                {
                    System.out.println("Dealing third card to banker...");
                    dealThirdCard(banker, shoe);
                }
                else if(bankerValue == 3)
                {
                    if(playerThirdCard.value() != 8){
                        System.out.println("Dealing third card to banker...");
                        dealThirdCard(banker, shoe);
                    }
                }
                else if(bankerValue == 4)
                {
                    if(playerThirdCard.value() == 2 || playerThirdCard.value() ==  3 ||
                            playerThirdCard.value() == 4 || playerThirdCard.value() == 5 ||
                            playerThirdCard.value() == 6 || playerThirdCard.value() == 7)
                    {
                        System.out.println("Dealing third card to banker...");
                        dealThirdCard(banker, shoe);
                    }
                }
                else if(bankerValue == 5)
                {
                    if(playerThirdCard.value() == 4 || playerThirdCard.value() == 5 ||
                            playerThirdCard.value() == 6 || playerThirdCard.value() == 7)
                    {
                        System.out.println("Dealing third card to banker...");
                        dealThirdCard(banker, shoe);
                    }
                }
                else if(bankerValue == 6)
                {
                    if(playerThirdCard.value() == 6 || playerThirdCard.value() == 7)
                    {
                        System.out.println("Dealing third card to banker...");
                        dealThirdCard(banker, shoe);
                    }
                }


                //display the dealt hands and the winner
                displayHands(player, banker);
                displayWinner(player, banker);
            }



            //Check for default or interactive mode
            if (args.length != 0) {
                playInteractiveMode(shoe);
            } else {
                playDefaultMode(shoe);
            }
        }

        //Display the game summary
        displayGameSummary();

    }

    //Additional Methods
    /**
     * This method displays the hands for each of the player
     *
     * @param player player's hand
     * @param banker banker's hand
     */
    public static void displayHands(BaccaratHand player, BaccaratHand banker){
        System.out.printf("Player: %s = %s\n", player, player.value());
        System.out.printf("Banker: %s = %s\n", banker, banker.value());
    }

    /**
     * This method displays the results of the game at the end of the game
     */
    //This method displays the results of the game
    public static void displayGameSummary(){
        System.out.printf("\n%d rounds played\n", roundNumber);
        System.out.printf("%d player wins\n", playerWins);
        System.out.printf("%d banker wins\n", bankerWins);
        System.out.printf("%d ties\n", ties);
    }

    /**
     * This method updates the round number after each round
     */
    public static void updateRoundNumber(){
        roundNumber++;
    }


    /**
     * This method prompts the user for a new game
     * Parses the input and converts it to lower case
     *
     * @return the first character of user input
     */
    public static String askForNewGame(){
        //Ask if player wants to play a new game
        System.out.print("Another round? (y/n): ");
        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        userInput = userInput.substring(0,1);
        userInput = userInput.toLowerCase();
        return userInput;
    }

    /**
     * This method displays the winner after card is dealt in the round.
     * It calculates who has the higher value hand and displays the winner.
     *
     * @param player the players hand
     * @param banker the bankers hand
     */
    public static void displayWinner(BaccaratHand player, BaccaratHand banker){
        //Check who won
        if(player.value() > banker.value())
        {
            System.out.println("Player win!");
            playerWins++;
        }
        else if(banker.value() > player.value())
        {
            System.out.println("Banker win!");
            bankerWins++;
        }
        else{
            System.out.println("Tie!");
            ties++;
        }
    }

    /**
     * This method checks whether the number of cards in the shoe is greater than 6
     *
     * @param shoe The shoe that should be checked
     * @return The number of cards in the shoe
     */
    public static boolean checkForNumberOfCardsInShoe(Shoe shoe){
        if(shoe.size() < 6){
            return false;
        }
        return true;
    }

    /**
     * This method prompts the users for the number of decks that should be in the shoe
     * (6 or 8)
     *
     * @return specified number of decks
     */
    public static int askForDecksInShoe(){
        int numOfDecks = 0;
        do{
            System.out.print("How many decks should the shoe have? (6 or 8): ");
            Scanner input = new Scanner(System.in);

            try{
                numOfDecks = input.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error: input is not a number");
            }
        }
        while(numOfDecks != 6 && numOfDecks != 8);

        return numOfDecks;
    }


    /**
     * Deals two cards to the user specified in the parameters
     *
     * @param user The game user to be dealt, either banker or player
     * @param shoe The shoe to be dealt from
     */
    private static void dealHands(BaccaratHand user, Shoe shoe){
        BaccaratCard card;

        Card.useFancySymbols(true);
        try{
            card = shoe.deal();
            user.add(card);
            card = shoe.deal();
            Card.useFancySymbols(true);
            user.add(card);
        }catch(CardException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Deals a third card to the specified user from the specified shoe
     *
     * @param user the user to be dealt the card - player or banker
     * @param shoe the shoe where the card should be dealt from
     * @return the BaccaratCard object that was dealt
     */
    private static BaccaratCard dealThirdCard(BaccaratHand user, Shoe shoe){
        BaccaratCard thirdCard = null;

        try{
            thirdCard = shoe.deal();
            user.add(thirdCard);
        }catch(CardException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return thirdCard;
    }

    /**
     * Plays the interactive mode of the baccarat game
     *
     * @param shoe the shoe where the game should be played from
     */
    private static void playInteractiveMode(Shoe shoe){
        String newGame;
        do{
            newGame = askForNewGame();
        } while(!newGame.equals("y") && !newGame.equals("n"));

        if(newGame.equals("y") ){
            if(checkForNumberOfCardsInShoe(shoe))
            {
                updateRoundNumber();
                gamePlaying = true;
            }
        }
        else{
            gamePlaying = false;
        }
    }

    /**
     * Plays the default mode of the baccarat game
     *
     * @param shoe the shoe where the game should be played from
     */
    private static void playDefaultMode(Shoe shoe){
        if(checkForNumberOfCardsInShoe(shoe))
        {
            updateRoundNumber();
            gamePlaying = true;
        }
        else
        {
            gamePlaying = false;
        }
    }
}
