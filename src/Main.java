import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
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
            System.out.println("Press c to continue a game\nPress n for new game\nPress r to replay game\nPress d to get a demo\nPress q to quit game");
            String input = s.next();

            switch (input) {
                case "c" -> gameOn = true;
                case "n" -> {
                    usedDeck = new Deck();
                    cardGrid = new CardGrid();
                    deck.setDeck(cardGrid.generateCardGrid(deck.getDeck()));
                    gameOn = true;
                }
                case "r" -> replayMoves(usedDeck, cardGrid, s);
                case "d" -> {
                    usedDeck = new Deck();
                    cardGrid = new CardGrid();
                    deck.setDeck(cardGrid.generateCardGrid(deck.getDeck()));
                    gameOn = false;
                    demo(usedDeck, cardGrid, deck, s);
                }
                case "q" -> {
                    playing = false;
                    gameOn = false;
                }
            }

            while (gameOn) {
                cardGrid.printGrid();
                System.out.println("Do you need a hint? (y/n) or press x to exit game");
                input = inputString(s.next());
                if (input.equals("y")) {
                    cardGrid.printGrid(cardGrid.returnHint());
                }

                System.out.println("Please enter the X coordinate of card 1");
                int posAX = inputInt(s.nextInt());
                System.out.println("Please enter the Y coordinate of card 1");
                int posAY = inputInt(s.nextInt());
                System.out.println("Please enter the X coordinate of card 2");
                int posBX = inputInt(s.nextInt());
                System.out.println("Please enter the Y coordinate of card 2");
                int posBY = inputInt(s.nextInt());
                System.out.println("Is there a third card?");
                input = inputString(s.next());
                if (input.equals("y")) {
                    System.out.println("Please enter the X coordinate of card 3");
                    int posCX = inputInt(s.nextInt());
                    System.out.println("Please enter the Y coordinate of card 3");
                    int posCY = inputInt(s.nextInt());
                    Card a = cardGrid.selectCard(posAX, posAY);
                    Card b = cardGrid.selectCard(posBX, posBY);
                    Card c = cardGrid.selectCard(posCX, posCY);
                    a.setPrevPos(posAX, posAY);
                    b.setPrevPos(posBX, posBY);
                    c.setPrevPos(posCX, posCY);

                    if (cardGrid.checkIfEleven(a, b, c)) {
                        usedDeck.addCard(a);
                        usedDeck.addCard(b);
                        usedDeck.addCard(c);
                        cardGrid.Cards[posAX][posAY] = deck.getDeck().pop();
                        cardGrid.Cards[posBX][posBY] = deck.getDeck().pop();
                        cardGrid.Cards[posCX][posCY] = deck.getDeck().pop();
                    } else {
                        System.out.println("Not a match!");
                    }

                } else if (input.equals("n")) {
                    Card a = cardGrid.selectCard(posAX, posAY);
                    Card b = cardGrid.selectCard(posBX, posBY);
                    a.setPrevPos(posAX, posAY);
                    b.setPrevPos(posBX, posBY);

                    if (cardGrid.checkIfEleven(a, b)) {
                        usedDeck.addCard(a);
                        usedDeck.addCard(b);
                        cardGrid.Cards[posAX][posAY] = deck.getCard();
                        cardGrid.Cards[posBX][posBY] = deck.getCard();
                    } else {
                        System.out.println("Not a match!");
                    }
                }

                gameOn = cardGrid.checkIfAbleToAdvance();
            }
            cardGrid.printGrid();
        }
    }

    public  static int inputInt(int s){
        boolean correctInput =true;
        while (correctInput){
            if(s>=0 && s<=2){
                correctInput=false;
            } else {
                System.out.println("Please enter a value between 0 and 2");
                s = new Scanner(System.in).nextInt();
            }
        }
        return s;
    }

    public  static String inputString(String s){
        boolean correctInput = true;
        while (correctInput){
            if(s.equals("y") || s.equals("n")){
                correctInput = false;
            } else {
                System.out.println("Please enter a y (yes) or n (no)");
                s = new Scanner(System.in).next();
            }
        }
        return s;
    }

    public static void replayMoves(Deck d, CardGrid cg, Scanner s) {
        d.reverse();
        for (Card c : d.getDeck()) {
            cg.Cards[c.getPrevPosX()][c.getPrevPosY()] = c;
        }
        cg.printGrid();
        d.reverse();
        for (Card c : d.getDeck()) {
            cg.Cards[c.getPrevPosX()][c.getPrevPosY()] = c;
            System.out.println(c.getFaceValue() + " was removed");
            s.next();
        }
    }

    public static void demo(Deck ud, CardGrid cg, Deck d, Scanner s) {
        var gameOn = true;
        while (gameOn) {
            cg.printGrid();
            var coordinates = cg.getDemoMove();
            if (coordinates != null) {
                int posAX = coordinates[0];
                int posAY = coordinates[1];
                int posBX = coordinates[2];
                int posBY = coordinates[3];

                Card a = cg.selectCard(posAX, posAY);
                Card b = cg.selectCard(posBX, posBY);
                System.out.println(a.getFaceValue() + " was removed");
                System.out.println(b.getFaceValue() + " was removed");



                a.setPrevPos(posAX, posAY);
                b.setPrevPos(posBX, posBY);

                if(coordinates.length == 6){
                    int posCX = coordinates[4];
                    int posCY = coordinates[5];
                    Card c = cg.selectCard(posCX, posCY);
                    c.setPrevPos(posCX, posCY);
                    System.out.println(c.getFaceValue() + " was removed");

                }

                ud.addCard(a);
                ud.addCard(b);
                cg.Cards[posAX][posAY] = d.getDeck().pop();
                cg.Cards[posBX][posBY] = d.getDeck().pop();

            } else {
                gameOn = false;
            }
        }
    }
}
