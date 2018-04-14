public class Card
{
    private int value;
    private String suit;
    private String rank;

    public Card(int val, String st, String rk)
    {
        this.value = val;
        this.suit = st;
        this.rank = rk;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public String getSuit(){
        return this.suit;
    }

    public String getRank(){
        return this.rank;
    }
    
    public String toString(){
        return this.rank + " of " + this.suit + "'s";
    }
    
}