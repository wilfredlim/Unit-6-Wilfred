import java.util.ArrayList;

public class Player {
    public static void main(String[] args) {
        Player p1 = new Player(1);
        Player p2 = new Player(2);

        Deck theDeck = new Deck();
        theDeck.shuffle();

        System.out.println("Filling each player's hands with random cards from a shuffled deck:");
        p1.addCard(theDeck.drawRandom());
        p1.addCard(theDeck.drawRandom());
        p1.addCard(theDeck.drawRandom());
        p1.addCard(theDeck.drawRandom());

        p2.addCard(theDeck.drawRandom());
        p2.addCard(theDeck.drawRandom());
        p2.addCard(theDeck.drawRandom());
        p2.addCard(theDeck.drawRandom());

        System.out.println("Player 1 Deck: " + p1.toString());
        System.out.println("Player 2 Deck: " + p2.toString());

        System.out.println("\n"+"Playing cards at index 1: ");
        System.out.println("Player 1 Card: " + p1.playCard(1));
        System.out.println("Player 2 Card: " + p2.playCard(1));

        System.out.println("\n"+"Playing a random card from each hand: ");
        System.out.println("Player 1 Card: " + p1.playRandom());
        System.out.println("Player 2 Card: " + p2.playRandom());

        System.out.println("\n"+"Removing the third cards:");
        p1.removeCard(2);
        p2.removeCard(2);
        System.out.println("Player 1 Deck: " + p1.toString());
        System.out.println("Player 2 Deck: " + p2.toString());
    }

    private ArrayList<Card> myHand = new ArrayList<>();
    private int playerNumber;

    public Player(int playerNumber){
        this.playerNumber = playerNumber;
    }

    public void addCard(Card aCard){
        myHand.add(aCard);
    }

    public void removeCard(int index){
        myHand.remove(index);
    }

    public Card playCard(int index){
        return myHand.get(index);
    }

    public Card playRandom(){
        return myHand.get((int)Math.random()*(myHand.size()+1));
    }

    public int getSize(){
        return myHand.size();
    }

    public String toString(){
        String returnString = "[ ";
        for(int i = 0; i < myHand.size(); i++){
            returnString += myHand.get(i).toString();
            returnString += " ";
        }
        returnString += "]";
        return returnString;
    }

}
