import java.util.Stack;

public class CardGrid {
    public Card[][] Cards = new Card[3][3];

    public CardGrid() {

    }

    public Stack<Card> generateCardGrid(Stack<Card> cards) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cards[i][j] = cards.pop();
            }
        }
        return cards;
    }

    public Card selectCard(int posX, int posY) {
        return Cards[posX][posY];
    }

    public boolean checkIfAbleToAdvance(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Card a = Cards[i][j];
                for(int k=0;k<3; k++){
                    if(checkIfEleven(a,Cards[j][k])){
                        return true;
                    }
                }
            }
        }
        System.out.println("No move is possible");
        System.out.println("Game over");
        return false;
    }

    public void printGrid(Card[] cards){
        System.out.println("   (0)(1)(2)");
        for(int i=0;i<3;i++){
            System.out.print("("+i+")");
            for(int j=0; j<3;j++){
                if(cards[0].getSuit().equals(Cards[i][j].getSuit()) || cards[1].getSuit().equals(Cards[i][j].getSuit())) {
                    System.out.print("["+Cards[i][j].getSuit()+"]");
                } else {
                    System.out.print(" "+Cards[i][j].getSuit()+" ");
                }
            }
            System.out.println();
        }
    }

    public void printGrid(){
        System.out.println("   (0)(1)(2)");
        for(int i=0;i<3;i++){
            System.out.print("("+i+")");
            for(int j=0; j<3;j++){
                System.out.print(" "+Cards[i][j].getSuit()+" ");
            }
            System.out.println();
        }
    }

    public Card[] returnHint(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Card a = Cards[i][j];
                for(int k=0;k<3; k++){
                    Card b = Cards[j][k];
                    if(checkIfEleven(a,b)){
                      return new Card[]{a, b};
                    }
                }
            }
        }
        System.out.println("No move is possible");
        return null;
    }

    public int[] getDemoMove(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Card a = Cards[i][j];
                for(int k=0;k<3; k++){
                    Card b = Cards[j][k];
                    if(checkIfEleven(a, b)){
                        return new int[]{i,j,j,k};
                    }
                }
            }
        }
        System.out.println("No move is possible");
        return null;
    }

    public boolean checkIfEleven(Card A, Card B) {
        return A.getValue() + B.getValue() == 11;
    }

    public boolean checkIfEleven(Card a, Card b, Card c){
        return a.getValue() + b.getValue() + c.getValue() == 48;
    }

}
