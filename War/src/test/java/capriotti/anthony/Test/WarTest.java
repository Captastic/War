package capriotti.anthony.Test;

import capriotti.anthony.Card;
import capriotti.anthony.Deck;
import capriotti.anthony.War;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by Anthony on 5/9/2017.
 */
public class WarTest {
    War war;
    Deck deck;
    LinkedList<Card> playerHand;
    LinkedList<Card> opponentHand;

    @Before
    public void setup(){
        deck = new Deck();
        war = new War();
        playerHand = new LinkedList<>();
        opponentHand = new LinkedList<>();
    }

    @Test
    //testing even split with player/opponent hand size
    public void setHandsTest(){

    }
}
