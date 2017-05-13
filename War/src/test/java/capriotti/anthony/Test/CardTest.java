package capriotti.anthony.Test;

import capriotti.anthony.Card;
import capriotti.anthony.Card.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;




/**
 * Created by Anthony on 5/9/2017.
 */
public class CardTest {

    Card card;

    @Before
    public void setup(){
        card = new Card(1, 12);
    }

    @Test
    public void suitTest(){
        Suit expected = Suit.HEARTS;
        Suit actual = card.getSuit();
        Assert.assertEquals("testing suit", expected, actual);
    }

    @Test
    public void rankTest(){
        Rank expected = Rank.ACE;
        Rank actual = card.getRank();
        Assert.assertEquals("testing rank", expected, actual);
    }

    @Test
    public void valueTest(){
        double expected = 14;
        double actual = card.getRank().getValue();
        Assert.assertEquals("testing value", expected, actual, 0);
    }

}
