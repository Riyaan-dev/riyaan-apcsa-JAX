package cards;

import java.util.Random;

public class Deck {

    private Card[] cards;
    private int top;
    
    public Deck(){
        cards = new Card[52];
        int size = 0;
        for (int i = 0; i < 4; i++){
            for(int j = 0; j <=12; j++){
                cards[size] = new Card(i,j);
                size++;
            }

        }
        top = 0;
    }
    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i <52; i++){
            int i1 = rand.nextInt(52-top)+top;
            int i2 = rand.nextInt(52-top)+top;
            Card temp = cards[i1];
            cards[i1] = cards[i2];
            cards[i2] = temp;
        }
    

    }

    public void cut(int index){
        Card[] temp = new Card[index];
        for (int i = 0; i < index; i++){
            temp[i]=cards[i];
        }
        for(int i = index; i < cards.length; i++){
            cards[i-index]=cards[i];
        }
        for (int i = 0; i<index; i++){
            cards[cards.length - index + i]= temp[i]; 
        }
    }
    public Card draw(){
        if (top >= 52){
            return null;
        }
        Card card = cards[top];
        top ++;
        return card;

    
    }
    public void print(int count){
        for (int i = 0; i < count; i++){
            System.out.print(cards[top+i] + " ");
        }
        System.out.println("");
    }


}
