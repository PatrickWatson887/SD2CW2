import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame(){
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffleDeck();
        Deck usedDeck = new Deck();
        CardGrid cardGrid = new CardGrid();
        deck.setDeck(cardGrid.generateCardGrid(deck.getDeck()));
        Scanner s = new Scanner(System.in);

        boolean gameOn = true;
        boolean playing = true;
        while (playing) {
            System.out.println("Press c to continue a game\nPress n for new game\nPress r to replay game");
            String input = s.next();

            if (input.equals("c")) {
                gameOn=true;
            } else if (input.equals("n")) {

                usedDeck = new Deck();
                cardGrid = new CardGrid();
                deck.setDeck(cardGrid.generateCardGrid(deck.getDeck()));
                gameOn = true;
            } else if(input.equals("r")){
                replayMoves(usedDeck,cardGrid,s);
            }

            while (gameOn) {
                cardGrid.printGrid();
                System.out.println("Do you need a hint? (y/n) or press x to exit game");
                input =s.next();
                if (input.equals("y")) {
                    cardGrid.printGrid(cardGrid.returnHint());
                }

                System.out.println("Please enter the X coordinate of card 1");
                int posAX = s.nextInt();
                System.out.println("Please enter the Y coordinate of card 1");
                int posAY = s.nextInt();
                System.out.println("Please enter the X coordinate of card 2");
                int posBX = s.nextInt();
                System.out.println("Please enter the Y coordinate of card 2");
                int posBY = s.nextInt();
                System.out.println("Is there a third card?");
                input = s.next();
                if(input.equals("y")){
                    System.out.println("Please enter the X coordinate of card 3");
                    int posCX = s.nextInt();
                    System.out.println("Please enter the Y coordinate of card 3");
                    int posCY = s.nextInt();
                    Card a = cardGrid.selectCard(posAX, posAY);
                    Card b = cardGrid.selectCard(posBX, posBY);
                    Card c = cardGrid.selectCard(posCX,posCY);
                    a.setPrevPos(posAX,posAY);
                    b.setPrevPos(posBX,posBY);
                    c.setPrevPos(posCX,posCY);

                    if (cardGrid.checkIfEleven(a, b,c)) {
                        usedDeck.addCard(a);
                        usedDeck.addCard(b);
                        usedDeck.addCard(c);
                        cardGrid.Cards[posAX][posAY] = deck.getDeck().pop();
                        cardGrid.Cards[posBX][posBY] = deck.getDeck().pop();
                        cardGrid.Cards[posCX][posCY] = deck.getDeck().pop();
                    } else {
                        System.out.println("Not a match!");
                    }

                } else if(input.equals("n")){
                    Card a = cardGrid.selectCard(posAX, posAY);
                    Card b = cardGrid.selectCard(posBX, posBY);
                    a.setPrevPos(posAX,posAY);
                    b.setPrevPos(posBX,posBY);

                    if (cardGrid.checkIfEleven(a, b)) {
                        usedDeck.addCard(a);
                        usedDeck.addCard(b);
                        cardGrid.Cards[posAX][posAY] = deck.getDeck().pop();
                        cardGrid.Cards[posBX][posBY] = deck.getDeck().pop();
                    } else {
                        System.out.println("Not a match!");
                    }
                }
                gameOn = cardGrid.checkIfAbleToAdvance();
            }
        }
    }
    public static void replayMoves(Deck d, CardGrid cg, Scanner s){
        d.reverse();
        for(Card c: d.getDeck()){
            cg.Cards[c.getPrevPosX()][c.getPrevPosY()] = c;
        }
        cg.printGrid();
        d.reverse();
        for(Card c: d.getDeck()){
            cg.Cards[c.getPrevPosX()][c.getPrevPosY()] = c;
            System.out.println(c.getFaceValue()+" was removed");
            cg.printGrid();
            s.next();
        }



    }
    public static void demo(){

    }


}
