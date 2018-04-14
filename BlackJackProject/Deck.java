import java.util.ArrayList;
import java.util.Random;
public class Deck
{
    private ArrayList<Card> deck;
    public Deck()
    {
        this.deck = new ArrayList();
    }
    
    public void initializeDeck(){
        String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
                            
        for (String s : suits){
            int value = 1;
            for (String r : ranks){
                if(value > 10){
                    FaceCard temp = new FaceCard(s, r);
                    this.deck.add(temp);
                } else{
                    Card temp = new Card(value, s, r);
                    this.deck.add(temp);
                }
                value++;
            }
        }
    }
    
    public void printDeck(){
        for(Card c: this.deck){
            System.out.println(c);
        }
    }
    
    public void shuffle(){
        ArrayList<Card> temp = new ArrayList();
        Random rng = new Random();
        int index;
        
        for(int i = 0; i < 52; i++){
            index = rng.nextInt(this.deck.size());
            temp.add(this.deck.get(index));
            this.deck.remove(index);
        }
        
        this.deck = temp;
    }
    
    public ArrayList<Card> deal(){
        ArrayList<Card> hand = new ArrayList();
        for(int i = 1; i < 3; i++){
            hand.add(this.deck.get(0));
            this.deck.remove(0);
        }
        return hand;
    }
    
    public Card getTopCard(){
        Card temp = this.deck.get(0);
        this.deck.remove(0);
        return temp;
    }

}