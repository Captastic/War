package capriotti.anthony;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anthony on 5/9/2017.
 */
public class War {
    Deck deck = new Deck();
    LinkedList<Card> playerHand = new LinkedList<>();
    LinkedList<Card> opponentHan = new LinkedList<>();
    Card playerCard;
    Card opponentCard;

    public void setHands() {
        Card card;
        for (int i = 0; i < 52; i++) {
            card = deck.draw();
            if (i % 2 == 0) {
                playerHand.add(card);
            }
            if (i % 2 != 0) {
                opponentHan.add(card);
            }
        }
    }

    public void play(){
        setHands();
        while (playerHand.size() > 0 && opponentHan.size() >0){

            playerCard = playerHand.pop();
            opponentCard = opponentHan.pop();

            System.out.println("Player shows a" + playerCard.toString());
            System.out.println("Opponent shows a" + opponentCard.toString());

            if (playerCard.rank.getValue() > opponentCard.rank.getValue()){
                playerWins();
            }
            else if (playerCard.rank.getValue() < opponentCard.rank.getValue()){
                opponentWins();
            }
            else {
                System.out.println("War");
                war();
            }


            if (playerHand.size() == 0){
                System.out.println("You lose");
                break;
            }
            else if (opponentHan.size() == 0){
                System.out.println("you win");
                break;
            }
        }
    }

    public void playerWins(){
        playerHand.addLast(playerCard);
        playerHand.addLast(opponentCard);
        System.out.println("Player wins the round");
    }
    public void opponentWins(){
        opponentHan.addLast(playerCard);
        opponentHan.addLast(opponentCard);
        System.out.println("Opponent winds the round");
    }

    public void war(){
        List<Card> playerWar = new ArrayList<>();
        List<Card> opponentWar = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            if (playerHand.size() == 0 || opponentHan.size() == 0){
                break;
            }

            System.out.println("War card for player is xx\nWar card for opponent is xx");

            playerWar.add(playerHand.pop());
            opponentWar.add(opponentHan.pop());
        }

        if (playerWar.size() == 3 && opponentWar.size() == 3){
            System.out.println("Player war card is " + playerWar.get(0).toString());
            System.out.println("Opponent war card is " + opponentWar.get(0).toString());

            if (playerWar.get(2).rank.getValue() > opponentWar.get(2).rank.getValue()){
                playerHand.addAll(playerWar);
                playerHand.addAll(opponentWar);
                System.out.println("You win the war");
            }
            else {
                opponentHan.addAll(playerWar);
                opponentHan.addAll(opponentWar);
                System.out.println("You lost the war");
            }
        }
    }
}
