package capriotti.anthony;

/**
 * Created by Anthony on 5/9/2017.
 */
public class Card {

    public enum Suit {SPADE, HEARTS, CLUB, DIAMOND}
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
        QUEEN(12), KING(13), ACE(14);

        int value;

        Rank(int x){
            this.value = x;
        }

        public int getValue(){
            return value;
        }
    }

    Suit suit;
    Rank rank;

    public Card(int suit, int rank){
        this.suit = Suit.values()[suit];
        this.rank = Rank.values()[rank];
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    @Override
    public String toString(){
        return rank + "of" + suit;
    }

}
