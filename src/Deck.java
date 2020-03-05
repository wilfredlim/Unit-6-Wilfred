import java.util.ArrayList;

public class Deck {
    public static void main(String[] args) {
        Deck newDeck = new Deck();

        System.out.println(newDeck.toString());

        System.out.println("\n"+"Testing shuffle: ");
        newDeck.shuffle();

        System.out.println(newDeck.toString());

        System.out.println("\n"+"Drawing the top card: " + newDeck.drawTop().toString());
        System.out.println("Drawing a random card: " + newDeck.drawRandom().toString());
    }
    private ArrayList<Card> myDeck = new ArrayList<>();

    public Deck(){
        Card current;
        for(int i = 1; i < 5; i++){
            for (int j = 2; j < 15; j++) {
                current = new Card(i,j);
                myDeck.add(current);
            }
        }
    }

    public void shuffle(){
        Card temp;
        int random;
        for(int i = 0; i < myDeck.size(); i++){
            random = (int)(Math.random()*52);
            temp = myDeck.get(i);
            myDeck.set(i, myDeck.get(random));
            myDeck.set(random, temp);
        }
    }

    public Card drawRandom(){
        return myDeck.get((int)(Math.random()*(myDeck.size())));
    }

    public Card drawRemoveRandom(){
        int random = (int)(Math.random()*(myDeck.size()));
        Card plsReturn = myDeck.get(random);
        myDeck.remove(random);
        return plsReturn;
    }

    public Card drawTop(){
        return myDeck.get(0);
    }

    public Card drawRemoveTop(){
        Card plsReturn = myDeck.get(0);
        myDeck.remove(0);
        return plsReturn;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < myDeck.size(); i++){
            str += myDeck.get(i).toString();
            str += " ";
        }
        return str;
    }
}