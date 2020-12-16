import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> deck;

    public Deck() {
        deck=new Stack<Card>();
    }

    public Stack<Card> getDeck() {
        return deck;
    }
    public void setDeck(Stack<Card> newDeck) { this.deck=newDeck; }
    public int returnDeckSize(){ return deck.size();}
    public void addCard(Card c){deck.push(c);}
    public void addCard(Card c, int posX, int posY){
        c.setPrevPos(posX,posY);
        deck.push(c);

    }

    public void generateDeck(){
        Stack<Card> newDeck = new Stack<Card>();

        //spades
        newDeck.push(new Card("\uD83C\uDCA1",1, "Ace of spades"));
        newDeck.push(new Card("\uD83C\uDCA2",2, "2 of spades"));
        newDeck.push(new Card("\uD83C\uDCA3",3,"3 of spades"));
        newDeck.push(new Card("\uD83C\uDCA4",4,"4 of spades"));
        newDeck.push(new Card("\uD83C\uDCA5",5, "5 of spades"));
        newDeck.push(new Card("\uD83C\uDCA6",6, "6 of spades"));
        newDeck.push(new Card("\uD83C\uDCA7",7,"7 of spades"));
        newDeck.push(new Card("\uD83C\uDCA8",8, "8 of spades"));
        newDeck.push(new Card("\uD83C\uDCA9",9, "9 of spades"));
        newDeck.push(new Card("\uD83C\uDCAA",10, "10 of spades"));
        newDeck.push(new Card("\uD83C\uDCAB",12, "King of spades"));
        newDeck.push(new Card("\uD83C\uDCAD",13, "Queen of spades"));
        newDeck.push(new Card("\uD83C\uDCAE",12, "Jack of spades"));

        //hearts
        newDeck.push(new Card("\uD83C\uDCB1",1, "Ace of hearts"));
        newDeck.push(new Card("\uD83C\uDCB2",2, "2 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB3",3,"3 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB4",4,"4 of hearts"));
        newDeck.push(new Card("\uD83C\uDCBA",5, "5 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB6",6, "6 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB7",7,"7 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB8",8, "8 of hearts"));
        newDeck.push(new Card("\uD83C\uDCB9",9, "9 of hearts"));
        newDeck.push(new Card("\uD83C\uDCBA",10, "10 of hearts"));
        newDeck.push(new Card("\uD83C\uDCBB",12, "King of hearts"));
        newDeck.push(new Card("\uD83C\uDCBD",13, "Queen of hearts"));
        newDeck.push(new Card("\uD83C\uDCBE",12, "Jack of hearts"));

        //Diamonds
        newDeck.push(new Card("\uD83C\uDCC1",1, "Ace of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC2",2, "2 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC3",3,"3 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC4",4,"4 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCCA",5, "5 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC6",6, "6 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC7",7,"7 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC8",8, "8 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCC9",9, "9 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCCA",10, "10 of diamonds"));
        newDeck.push(new Card("\uD83C\uDCCB",12, "King of diamonds"));
        newDeck.push(new Card("\uD83C\uDCCD",13, "Queen of diamonds"));
        newDeck.push(new Card("\uD83C\uDCCE",12, "Jack of diamonds"));


        //Clubs
        newDeck.push(new Card("\uD83C\uDCD1",1, "Ace of clubs"));
        newDeck.push(new Card("\uD83C\uDCD2",2, "2 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD3",3,"3 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD4",4,"4 of clubs"));
        newDeck.push(new Card("\uD83C\uDCDA",5, "5 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD6",6, "6 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD7",7,"7 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD8",8, "8 of clubs"));
        newDeck.push(new Card("\uD83C\uDCD9",9, "9 of clubs"));
        newDeck.push(new Card("\uD83C\uDCDA",10, "10 of clubs"));
        newDeck.push(new Card("\uD83C\uDCDB",12, "King of clubs"));
        newDeck.push(new Card("\uD83C\uDCDD",13, "Queen of clubs"));
        newDeck.push(new Card("\uD83C\uDCDE",12, "Jack of clubs"));

        this.deck = newDeck;
    }
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public void reverse(){
        Card[] c = new Card[returnDeckSize()];
        Card[] data = deck.toArray(c);
        for(int i = 0; i < returnDeckSize() / 2; i++)
        {
            Card temp =data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
        }
        deck = new Stack<Card>();
        for(Card C: data){
            deck.push(C);
        }
    }




}
