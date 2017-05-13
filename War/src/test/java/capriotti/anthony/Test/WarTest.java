package capriotti.anthony.Test;

import capriotti.anthony.Deck;
import capriotti.anthony.War;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by Anthony on 5/9/2017.
 */
public class WarTest {
    War war;
    Deck deck;


    @Before
    public void setup(){
        war = new War();
        deck = new Deck();
    }

    @Test
    //testing even split with player/opponent hand size
    public void setHandsTest(){
        int expected = 26;
        int actual = war.getPlayerHandCount();
        Assert.assertEquals("testing size of hands after set", expected, actual);
    }
    @Test
    //testing opponent hand size
    public void setHandsOpponentTest(){
        int expected = 26;
        int actual = war.getOpponentHandCount();
        Assert.assertEquals("Testing other LL size", expected, actual);
    }

    @Test
    public void playerWin(){
        war.playerWins();
        int expected = 28;
        int actual = war.getPlayerHandCount();
        Assert.assertEquals("Testing player win", expected,actual);
    }

    @Test
    public void oppenentWin(){
        war.opponentWins();
        int expected = 28;
        int actual = war.getOpponentHandCount();
        Assert.assertEquals("Testing opponent win", expected,actual);
    }

    @Test
    public void warTest(){}
}
