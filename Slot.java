import java.util.ArrayList;

public class Slot{

    //slot label (A;P;D;H;C;S;1234567)
    //Arraylist of card, this way i can put and move using an order
    private slottype slot;
    private ArrayList<Card> line = new ArrayList<>();

    //constructor
    public Slot(slottype slot){
        this.slot=slot;

    }
    public Slot(slottype slot,ArrayList<Card> line){
        this.slot=slot;
        this.line=line;
    }
    //methods
    public slottype getslottype(){
        return slot;
    }

    public ArrayList<Card> getline(){
        return line;
    }

    public void setline(ArrayList<Card> line){
        this.line=line;
    }

    //function to print all the cards
    public void printslot(){
        for(Card d: line){
            seedcard seme=d.getseed();
            numbercard numero=d.getnumber();
            System.out.println(""+seme+numero+": visible:" +d.getvisible());

        }
    }

    //function to get the card given the position in the arraylist
    //already implemented in arraylist



}
