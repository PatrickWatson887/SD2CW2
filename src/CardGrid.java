import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public boolean isFaceCardAndUnique(Card card, Card[] faceCards) {
        if (card.getValue() == 15) {
            return true;
        } else if (card.getValue() == 16) {
            return true;
        } else return card.getValue() == 17;
    }

    public int[] getDemoMove(){
        var count = 0;
        List<Integer> faceCards = Arrays.asList(new Integer[3].clone());
        var countTemp = 0;
        Card[] faceCardTemp = new Card[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Card a = Cards[i][j];
                for(int k=0;k<3; k++){
                    Card b = Cards[j][k];
                    if(b.getValue()>=15){
                        if(!faceCards.contains(b.getValue())){
                            faceCards.add(b.getValue());
                        }
                    }
                    if(faceCards.size() ==3) {
                        return faceCards.toArray(new int[3]);
                    }
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

    public boolean checkIfEleven(Card A, Card B, Card C) {
        return A.getValue() + B.getValue() + C.getValue() == 48;
    }
}
