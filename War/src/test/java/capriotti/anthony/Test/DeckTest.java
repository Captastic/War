package capriotti.anthony.Test;

import capriotti.anthony.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Anthony on 5/9/2017.
 */
public class DeckTest {

    Deck deck;

    @Before
    public void setup(){
        deck = new Deck();
    }

    @Test
    public void deckSizeTest(){
        int expected = 52;
        int actual = deck.getDeckSize();
        Assert.assertEquals("testing deck size", expected, actual);
    }

    @Test
    public void drawTest(){

        deck.draw();
        int expected = 51;
        int actual = deck.getDeckSize();
        Assert.assertEquals("Testing draw cards", expected, actual);
    }


}
