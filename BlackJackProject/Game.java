import java.util.ArrayList;
import java.util.Scanner;
public class Game
{
    private Player playerOne;
    private Player dealer;
    private Deck deckOfCards;
    
    public Game()
    {
        this.deckOfCards = new Deck();
        playerOne = new Player("Lane", 50);
        dealer = new Dealer();
        System.out.println("Get ready to begin");
        System.out.println("\nHere is " + playerOne.getMoney() + " dollars");
        System.out.println();
        playGame();
    }
    
    public void playGame()
    {
        this.deckOfCards.initializeDeck();
        this.deckOfCards.shuffle();
        int bet = playerOne.bet();
        this.playerOne.hand = this.deckOfCards.deal();
        this.dealer.hand = this.deckOfCards.deal();
        playerTurn();
        dealerTurn();
        int win = determineWinner();

        if(win == 0) {
            System.out.println("\nIt's a tie");
            playerOne.addMoney(bet);
            System.out.println("\nYou have " + dealer.getMoney() + " dollars");
        }
        else if(win == 1) {
            System.out.println("\nYou win");
            playerOne.addMoney(2 * bet);
            System.out.println("\nYou have " + playerOne.getMoney() + " dollars");
        }
        else {
            System.out.println("\nThe dealer wins");
            System.out.println("\nYou have " + playerOne.getMoney() + " dollars");
        }
        System.out.println("Do you want to play again? Yes or No?");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        
        if(answer.equals("Yes")) {
            playGame();
        }
        else {
            endGame();
        }
        
    }
    
    public int determineWinner()
    {
        int playerOneTotal = playerOne.handTotal();
        int dealerTotal = dealer.handTotal();
        
        //player wins if winner = 1, the dealer wins if winner = 2, 0 is a tie
        int winner = 0;
        
        if(dealerTotal > 21 && playerOneTotal <= 21) {
            winner = 1;
        }
        else if(playerOneTotal > 21 && dealerTotal <= 21) {
            winner = 2;
        }
        else if(playerOneTotal <= 21 && dealerTotal <= 21) {
            if(playerOneTotal > dealerTotal)  {
                winner = 1;
            }
            else {
                winner = 2;
            }
        }
        
        return winner;
    }
    
    public void endGame()
    {
        System.out.println("You ended with " + + playerOne.getMoney() + " dollars");
    }
    
    public void printPlayerHand()
    {
        System.out.println("\nYour hand is: ");
        for(Card c : playerOne.hand) {
            System.out.println(c);
        }
    }
    
    public void playerTurn()
    {
        while (true) {
            if(playerOne.handTotal() >= 21) {
                printPlayerHand();
                System.out.println("\nThe dealer is showing: ");
                System.out.println(dealer.hand.get(0));
                break;
            }
            
            printPlayerHand();
            System.out.println("\nThe dealer is showing: ");
            System.out.println(dealer.hand.get(0));
            System.out.println("\nDo you want to hit or stand?");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            
            if(choice.equals("hit")) {
                this.playerOne.hand.add(deckOfCards.getTopCard());
            }
            else {
                break;
            }
        }
    }
    
    public void dealerTurn()
    {
        while(dealer.handTotal() < 17){
            this.dealer.hand.add(deckOfCards.getTopCard());
        }
        
        System.out.println("\nThe dealer has: ");
        for(Card c : dealer.hand){
            System.out.println(c);
        }
    }
    
    public void showHands()
    {
        System.out.println("Player hand");
        for(Card c: playerOne.hand){
            System.out.println(c);
        }
        System.out.println("Dealer hand");
        for(Card c: dealer.hand){
            System.out.println(c);
        }
    }

}