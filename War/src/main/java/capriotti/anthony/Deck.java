package capriotti.anthony;

import java.util.ArrayList;

/**
 * Created by Anthony on 5/9/2017.
 */
public class Deck {

    ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();
        Card tempCard;
        int deckSize = 52;
        int index;

        for(int suit = 0; suit < 4; suit++){

            for (int rank = 0; rank < 13; rank++){
                deck.add(new Card(suit, rank));
            }
        }

        while(deckSize > 0){

            index = ((int)Math.floor(Math.random() * deckSize));
            tempCard = deck.get(index);
            deck.set(index, deck.get(deckSize - 1));
            deck.set(deckSize - 1, tempCard);
            deckSize--;
        }
    }

    public int getDeckSize(){
        return deck.size();
    }

    public Card draw(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
}
