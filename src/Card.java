public class Card {
    public static void main(String[] args) {
        Card card1 = new Card(6, "spades");
        Card card2 = new Card((int)(Math.random()*12)+2, "hearts");

        System.out.println(card1.toString());
        System.out.println(card2.toString());

        System.out.println("Comparing card 1 to card 2: "+ card1.compare(card2));

        System.out.println("\n"+"Following tests with this card: " + card2);
        System.out.println("Suit: " + card2.getSuit());
        System.out.println("Name: " + card2.getName());
        System.out.println("Color: " + card2.getColor());
    }

    private String suit;
    private int suitVal;
    private String name;
    private String color;
    private int value;

    public Card(int value, String suit){
        this.value = value;
        if(suit.compareTo("Spades") == 0 || suit.compareTo("Spade") == 0 || suit.compareTo("spades") == 0 || suit.compareTo("spade") == 0){
            this.suit = "♠";
            suitVal = 1;
            color = "black";
        }
        if(suit.compareTo("Hearts") == 0 || suit.compareTo("Heart") == 0 || suit.compareTo("hearts") == 0 || suit.compareTo("heart") == 0){
            this.suit = "♥";
            suitVal = 2;
            color = "red";
        }
        if(suit.compareTo("Clubs") == 0 || suit.compareTo("Club") == 0 || suit.compareTo("club") == 0 || suit.compareTo("club") == 0){
            this.suit = "♣";
            suitVal = 4;
            color = "black";
        }
        if(suit.compareTo("Diamonds") == 0 || suit.compareTo("Diamond") == 0 || suit.compareTo("diamonds") == 0 || suit.compareTo("diamond") == 0){
            this.suit = "♦";
            suitVal = 3;
            color = "red";
        }
        if(value == 2){ name = "2";}
        if(value == 3){ name = "3";}
        if(value == 4){ name = "4";}
        if(value == 5){ name = "5";}
        if(value == 6){ name = "6";}
        if(value == 7){ name = "7";}
        if(value == 8){ name = "8";}
        if(value == 9){ name = "9";}
        if(value == 10){ name = "10";}
        if(value == 11){ name = "J";}
        if(value == 12){ name = "Q";}
        if(value == 13){ name = "K";}
        if(value == 14){ name = "A";}
    }

    public Card(int suit, int value){
        this.value = value;
        if(suit == 1){
            this.suit = "♠";
            suitVal = 1;
            color = "black";
        }
        if(suit == 2){
            this.suit = "♥";
            suitVal =2;
            color = "red";
        }
        if(suit == 3){
            this.suit = "♣";
            suitVal = 4;
            color = "black";
        }
        if(suit == 4){
            this.suit = "♦";
            suitVal = 3;
            color = "red";
        }
        if(value == 2){ name = "2";}
        if(value == 3){ name = "3";}
        if(value == 4){ name = "4";}
        if(value == 5){ name = "5";}
        if(value == 6){ name = "6";}
        if(value == 7){ name = "7";}
        if(value == 8){ name = "8";}
        if(value == 9){ name = "9";}
        if(value == 10){ name = "10";}
        if(value == 11){ name = "J";}
        if(value == 12){ name = "Q";}
        if(value == 13){ name = "K";}
        if(value == 14){ name = "A";}
    }

    public String getSuit(){
        return suit;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public int getValue(){
        return value;
    }

    public int getSuitVal() { return suitVal;}

    public String toString(){
        return name+suit;
    }

    public int compare(Card aCard){
        int comp = -1;
        if(value > aCard.getValue()){ comp = 1;}
        if(value == aCard.getValue()){ comp = 0;}
        if(value < aCard.getValue()){ comp = -1;}
        return comp;
    }
}