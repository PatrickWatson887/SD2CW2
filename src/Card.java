public class Card extends Deck {
    private String suit;
    private int value;
    private int prevPosX;
    private int prevPosY;
    private String faceValue;

    public Card(String suit, int value, String faceValue) {
        this.setSuit(suit);
        this.setValue(value);
        this.setFaceValue(faceValue);
    }

    public void setCard(String suit, int value) {
        this.setSuit(suit);
        this.setValue(value);
    }
    public void setPrevPos(int posX, int posY){
        setPrevPosX(posX);
        setPrevPosY(posY);
    }

    public void setPrevPosX(int x){this.prevPosX=x;}
    public void setPrevPosY(int y){this.prevPosY=y;}
    public int getPrevPosX(){ return prevPosX;}
    public int getPrevPosY(){ return prevPosY;}
    public String getFaceValue(){ return faceValue; }

    public void setFaceValue(String fv){
        this.faceValue = fv;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() { return value; }

}
