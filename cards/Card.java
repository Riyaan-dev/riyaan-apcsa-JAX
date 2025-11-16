package cards;

public class Card {

    private int suit;
    private int value;



    public Card(int suit, int value){
        this.suit=suit; 
        if(this.suit < 0){
            this.suit = 0;
        }
        if (this.suit >3 ){
            this.suit = 3;
        }
        this.value=value;
        if(this.value < 0){
            this.value = 0;
        }
        if(this.value > 12){
            this.value = 12;
        }
    }

    public int getValue(){

        return value; 

    }

    public String toString(){
        String suitStr;
        if(suit == 0){
            suitStr = "♦";
        }
        else if(suit == 1){
            suitStr = "♣";
        }
        else if(suit == 2){
            suitStr = "♥";
        }
        else{
            suitStr = "♠";
        }
        String valueStr;

        if(value == 0){
            valueStr = "A";
        }
        else if(value == 10 ){
            valueStr = "J";
        }
        else if (value == 11){
            valueStr = "Q";
        }
        else if (value ==12){
            valueStr = "K";
        }
        else {
            valueStr = "" + (value + 1);
        }

        return suitStr+valueStr;
    }


}
