public class Card {

    //seme (d,h,c,s)
    //number (1-13)
    //visible or not
    private seedcard seed;
    private numbercard number;
    private boolean visible;
    //constructor

    public Card(seedcard seed, numbercard number, boolean visible){
        this.seed=seed;
        this.number=number;
        this.visible=visible;
    }

    public seedcard getseed() {
        return seed;

    }

    public numbercard getnumber(){
        return number;

    }
    public boolean getvisible(){
        return visible;

    }

    public void setVisible(boolean b){
        this.visible=b;
    }

    public void printcard(){
        System.out.println(""+seed+number);
    }

}
