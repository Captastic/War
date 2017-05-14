package capriotti.anthony;

import java.util.*;

/**
 * Created by Anthony on 5/9/2017.
 */
public class War extends Exception {
    Scanner scan = new Scanner(System.in);
    Deck deck = new Deck();
    LinkedList<Card> playerHand = new LinkedList<>();
    LinkedList<Card> opponentHan = new LinkedList<>();
    private Card playerCard;
    private Card opponentCard;

    public War(){
        setHands();
    }

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

        while (playerHand.size() > 0 && opponentHan.size() >0){

            playerCard = playerHand.pop();
            opponentCard = opponentHan.pop();

            System.out.println("Player shows a" + playerCard.toString());
            System.out.println("Opponent shows a" + opponentCard.toString());

            if (playerCard.rank.getValue() > opponentCard.rank.getValue()){
                playerWins();
                keepPlaying();
            }
            else if (playerCard.rank.getValue() < opponentCard.rank.getValue()){
                opponentWins();
                keepPlaying();
            }
            else {
                System.out.println("War");
                battle();
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

    public void battle(){
        List<Card> playerWar = new ArrayList<>();
        List<Card> opponentWar = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            if (playerHand.size() == 0 || opponentHan.size() == 0){
                break;
            }

            System.out.println("War card for player is\nWar card for opponent is xx");

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

    public int getPlayerHandCount(){
        return playerHand.size();
    }

    public int getOpponentHandCount(){
        return opponentHan.size();
    }

    public void keepPlaying(){
        try {
            System.out.println("Continue? Y or N?");

            if (scan.next().equalsIgnoreCase("N")){
                System.out.println("Thanks for playing");
                System.exit(0);
            }else if (scan.next().equalsIgnoreCase("Y")){
                 play();
            }else {
                keepPlaying();
            }

        } catch (InputMismatchException e){
            System.out.println("One more time please..");
            keepPlaying();
        }

    }
}
