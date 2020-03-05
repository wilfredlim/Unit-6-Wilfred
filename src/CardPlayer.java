public class CardPlayer {
    public static void main(String[] args) {
        Deck theDeck = new Deck();
        Player p1 = new Player(1);
        Player p2 = new Player(2);

        //giving the players hands
        theDeck.shuffle();
        for(int i = 0; i < 26; i++){
            p1.addCard(theDeck.drawRemoveRandom());
        }
        for(int j = 0; j < 26; j++){
            p2.addCard(theDeck.drawRemoveRandom());
        }

        //playing the game
        boolean done = false;
        int rounds = 0;
        while(!done){
            if(p1.playCard(0).getValue() > p2.playCard(0).getValue()){
                p1.addCard(p1.playCard(0));
                p1.addCard(p2.playCard(0));
                p1.removeCard(0);
                p2.removeCard(0);
                if(p2.getSize() == 0){ done = !done;}
            }
            else if(p1.playCard(0).getValue() < p2.playCard(0).getValue()){
                p2.addCard(p2.playCard(0));
                p2.addCard(p1.playCard(0));
                p1.removeCard(0);
                p2.removeCard(0);
                if(p1.getSize() == 0){ done = !done;}
            }
            else if(p1.playCard(0).getValue() == p2.playCard(0).getValue()){
                int sum1 = 0;
                int sum2 = 0;
                Card hCard1 = new Card(1,1);
                Card hCard2 = new Card(1,1);
                int max1 = 0;
                int max2 = 0;
                for(int i = 0; i<4; i++){
                    if(p1.getSize() >= (i+1)){
                        sum1 += p1.playCard(i).getValue();
                        if(p1.playCard(i).getValue() > max1){hCard1 = p1.playCard(i);}
                    }
                    if(p2.getSize() >= (i+1)){
                        sum2 += p2.playCard(i).getValue();
                        if(p2.playCard(i).getValue() > max2){ hCard2 = p2.playCard(i);}
                    }
                }
                if(sum1 > sum2){
                    for(int j = 0; j < 4; j++){
                        if(p1.getSize() >= j+1){
                            p1.addCard(p1.playCard(0));
                            p1.removeCard(0);
                        }
                        if(p2.getSize() >= j+1){
                            p1.addCard(p2.playCard(0));
                            p2.removeCard(0);
                        }
                        if(p2.getSize() == 0) {
                            done = !done;
                            continue;
                        }
                    }
                }
                else if(sum1 < sum2){
                    for(int k = 0; k < 4; k++){
                        if(p1.getSize() >= (k+1)){
                            p2.addCard(p1.playCard(0));
                            p1.removeCard(0);
                        }
                        if(p2.getSize() >= (k+1)){
                            p2.addCard(p2.playCard(0));
                            p2.removeCard(0);
                        }
                        if(p1.getSize() == 0) {
                            done = !done;
                            continue;
                        }
                    }
                }
                else if(sum1 == sum2){
                    if(hCard1.getValue() > hCard2.getValue()){
                        for(int m = 0; m < 4; m++){
                            if(p1.getSize() >= m+1){
                                p1.addCard(p1.playCard(0));
                                p1.removeCard(0);
                            }
                            if(p2.getSize() >= m+1){
                                p1.addCard(p2.playCard(0));
                                p2.removeCard(0);
                            }
                            if(p2.getSize() == 0) {
                                done = !done;
                                continue;
                            }
                        }
                    }
                    else if(hCard1.getValue() < hCard2.getValue()) {
                        for(int n = 0; n < 4; n++){
                            if(p1.getSize() >= (n+1)){
                                p2.addCard(p1.playCard(0));
                                p1.removeCard(0);
                            }
                            if(p2.getSize() >= (n+1)){
                                p2.addCard(p2.playCard(0));
                                p2.removeCard(0);
                            }
                            if(p1.getSize() == 0) {
                                done = !done;
                                continue;
                            }
                        }
                    }
                    else if(hCard1.getValue() == hCard2.getValue()){
                        int winner = 0;
                        if(hCard1.getSuitVal() > hCard2.getSuitVal()){ winner = 1;}
                        if(hCard1.getSuitVal() < hCard2.getSuitVal()){ winner = 2;}
                        if(winner == 1){
                            for(int o = 0; o < 4; o++){
                                if(p1.getSize() >= o+1){
                                    p1.addCard(p1.playCard(0));
                                    p1.removeCard(0);
                                }
                                if(p2.getSize() >= o+1){
                                    p1.addCard(p2.playCard(0));
                                    p2.removeCard(0);
                                }
                                if(p2.getSize() == 0) {
                                    done = !done;
                                    continue;
                                }
                            }
                        }
                        if(winner == 2){
                            for(int k = 0; k < 4; k++){
                                if(p1.getSize() >= (k+1)){
                                    p2.addCard(p1.playCard(0));
                                    p1.removeCard(0);
                                }
                                if(p2.getSize() >= (k+1)){
                                    p2.addCard(p2.playCard(0));
                                    p2.removeCard(0);
                                }
                                if(p1.getSize() == 0) {
                                    done = !done;
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            rounds++;
        }
        System.out.println("Rounds: "+rounds);
    }
}