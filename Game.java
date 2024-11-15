import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private ArrayList<Card> Deck = new ArrayList<>();
    private ArrayList<Slot> TotSlots = new ArrayList();
    private int score;
    private boolean gameover;

    //constructor

    public Game(){
        score=0;
        gameover=false;
        seedcard[] semi=seedcard.values();
        // Get an array of all values of the enum
        numbercard[] numeri=numbercard.values();
        for(seedcard c: semi) {
            for(numbercard n: numeri) {

                Card carta = new Card(c, n, false);
                //append all them to deck
                Deck.add(carta);
            }
        }

        //inizializza gli slots e li metto in TotSlots
        slottype[] slottipi=slottype.values();
        for(slottype s:slottipi){
            Slot spazio= new Slot(s);
            TotSlots.add(spazio);
        }
        //shuffle deck
        Collections.shuffle(Deck); //printiamo? bo
        //metto deck in slot A
        slottype a= slottype.A;
        Slot A=getSlot(a);
        A.setline(Deck);

        //proviamo a stampare il deck per checking
        //System.out.println("ecco il deck mischiato");
        // A.printslot();

       // System.out.println("dim:"+A.getline().size());


        //poi metto le prime carte sul campo( ossia sugli altri slots) e le rendo tutte invisibili
        //e rendo l'ultima di ogni pila visibile

        for(int i=0; i<7; i++){
            slottype n=slottype.fromValue(i+1); //associo i a slottype
            Slot nSlot=getSlot(n); //trovato slot in uso attualmente( da 1 a 7)
            //ogni slot 1-7 è gia inizializzato ma è vuoto

            for(int j=0;j<=i;j++){
                ArrayList<Card> DeckA= A.getline();
                if(!DeckA.isEmpty()) {
                    Card c = DeckA.remove(DeckA.size() - 1); //prendo carta da D
                    c.setVisible(false); //la copro
                    //Deck i aggiugni c
                    nSlot.getline().add(c); //la metto in n slot
                }
            }

            int dim=nSlot.getline().size();
            nSlot.getline().get(dim-1).setVisible(true); //i make the last card visible

        //    nSlot.printslot(); //printiamo ogni slot
          //  System.out.println("fine slot");
        }

    }

    public void GamePrint(){
        //prima lista sono i valori
        int s=score;
        System.out.println("Score:"+s);

        List<String> list= new ArrayList<>();
        list.add("A ");
        list.add("P ");
        list.add("D ");
        list.add("H ");
        list.add("C ");
        list.add("S ");

        for(String e: list){
            System.out.print(e+"  ");
        }
        System.out.print("\n");

        List<String> primariga= new ArrayList<>();
       // list.add("[]"); //è il deck A
        //list of enum A-S
        List<slottype> stList= new ArrayList<>(); //slottype[] non funge come lista perche non posso fare add
        stList.add(slottype.A);
        stList.add(slottype.P);
        stList.add(slottype.D);
        stList.add(slottype.H);
        stList.add(slottype.C);
        stList.add(slottype.S);

        //list of enum 1-7
        List<slottype> stListnumber= new ArrayList<>(); //slottype[] non funge come lista perche non posso fare add
        stListnumber.add(slottype.ONE);
        stListnumber.add(slottype.TWO);
        stListnumber.add(slottype.THREE);
        stListnumber.add(slottype.FOUR);
        stListnumber.add(slottype.FIVE);
        stListnumber.add(slottype.SIX);
        stListnumber.add(slottype.SEVEN);


        for(slottype e: stList){
            Slot eslot=getSlot(e);
            int dim=eslot.getline().size();
            if(dim>0) {
                Card last = eslot.getline().get(dim - 1);

                seedcard seme=last.getseed(); //to convert in str and put in list primariga
                String semestr=seme.getStr();

                numbercard numero=last.getnumber(); //to convert in str and put in list primariga
                String numerostr;
                switch(numero.getValue()){
                    case 11: numerostr="J"; break;
                    case 12: numerostr="Q"; break;
                    case 13: numerostr="K"; break;
                    default: numerostr=String.valueOf(numero.getValue()); break;
                }
                String carta=semestr+numerostr;
                if(last.getvisible()==true) {
                    primariga.add(carta); //finnalllllyyy carta scoperta
                }
                else{
                    primariga.add("[]"); // carta coperta
                }
            }
            else if(dim==0){
                primariga.add("..");//it means empty slot
            }

        }

        for(String ss: primariga){
            if(ss.length()==2) System.out.print(ss+"  ");
            else if(ss.length()==3) System.out.print(ss+" ");
        }
        System.out.print("\n");

        for(int i=1; i<8;i++){
            System.out.print(i+"   ");
        }
        System.out.print("\n");  //println mette il \n in automatico, print no

        //faccio una lista per le prossime 13 righe

        List<ArrayList<String>> righeTot = new ArrayList<>();

        int numList=20;

        for(int indice=0; indice<numList; indice++){ //faccio 13 righe, forma la riga
            ArrayList<String> riga = new ArrayList<>();
            //cosa metto nelle righe?
           // for(int indice=0;i<7;i++) { // indice di ogni slot, forma la riga
                for (slottype e : stListnumber) { // slots iterativamente uno alla volta
                    Slot eslot = getSlot(e);
                    int dim = eslot.getline().size();
                    if(indice<dim) { // ossia ce carta analizzabile nello slot

                        Card carta = eslot.getline().get(indice);

                        seedcard seme=carta.getseed(); //to convert in str and put in list riga
                        String semestr=seme.getStr();

                        numbercard numero=carta.getnumber(); //to convert in str and put in list riga
                        String numerostr=String.valueOf(numero.getValue());
                        switch(numero.getValue()){
                            case 11: numerostr="J"; break;
                            case 12: numerostr="Q"; break;
                            case 13: numerostr="K"; break;
                            default: numerostr=String.valueOf(numero.getValue()); break;
                        }
                        String cartastr=semestr+numerostr;

                        if(carta.getvisible()==true) {
                            riga.add(cartastr); //finnalllllyyy carta scoperta
                        }
                        else{
                            riga.add("[]"); // carta coperta
                        }
                    }
                    else riga.add("..");
                }
                //it makes sense, really hard to get
            righeTot.add(riga);
        }
// fatto la lista di righe; mo printiamo
        for (ArrayList<String> r : righeTot) {
         //   System.out.println(r);  // da correggere
            for(String ss: r){
                if(ss.length()==2) System.out.print(ss+"  ");
                else if(ss.length()==3) System.out.print(ss+" ");
            }
            System.out.print("\n");
        }

    }

    public Slot getSlot(slottype s){
        Slot res=null;
        //dato lo slottipe, lo troviamo nella lista e la returniamo
        for(Slot e : TotSlots){
            if(e.getslottype()==s) return e;
        }
        System.out.println("non trovato Slot");
        return res;
    }

    //method quit
    public void quit(){
        gameover=true;
        System.out.println("Gameover");
    }

    public void draw() {
        System.out.println("Drawing..");
        slottype a= slottype.A;
        Slot A=getSlot(a);
        ArrayList<Card> DeckA= A.getline();
      //  System.out.println("dim A rn:"+DeckA.size());

        slottype p = slottype.P;
        Slot P = getSlot(p);
        ArrayList<Card> DeckP = P.getline();
     //   System.out.println("dim P rn:"+DeckP.size());
        if(DeckA.size()>0) {
            Card c = DeckA.remove(DeckA.size() - 1); //prendo carta da D
            c.setVisible(true); //la rendo visibile
            //in Deck p aggiungi c
            DeckP.add(c); //la metto in P
        }
        if(DeckA.size()==0){// se il deck in A è finito, risposto tutte le carte da p ad a
            System.out.println("Deck A finished, recycling..");
            int i=0;
            int dfisso=DeckP.size();
            for(i=0; i<dfisso; i++) { //oppure potevo fare while finchè P non è vuoto
                Card cc = DeckP.remove(DeckP.size() - 1);
                cc.setVisible(false);
                DeckA.add(cc);
            }
           // System.out.println("i:"+i);
        }
        //move 1 card from slot A to Slot P and make it visible
    }


    public void move(String cmd) {
        //cmd is uppercase
        List<slottype> stListnumber = new ArrayList<>();
        stListnumber.add(slottype.ONE);
        stListnumber.add(slottype.TWO);
        stListnumber.add(slottype.THREE);
        stListnumber.add(slottype.FOUR);
        stListnumber.add(slottype.FIVE);
        stListnumber.add(slottype.SIX);
        stListnumber.add(slottype.SEVEN);

        List<slottype> stListds = new ArrayList<>();
        stListds.add(slottype.D);
        stListds.add(slottype.H);
        stListds.add(slottype.C);
        stListds.add(slottype.S);

        int nmoves=1; //default value

        //error input if its incorrect
        if(cmd.length()==0 || cmd.length()>3) {
            System.out.println("Error input da terminal");
            return;
        }
            //interpretiamo input

            char slot1=cmd.charAt(0);
            Slot x1Slot = null;
            char slot2=cmd.charAt(1);
            Slot x2Slot = null;
            //if not apdhcs or 1234567 error

           if(slot1==slot2){
               System.out.println("invalid move");
               return;
           }

            //otteniamo slottype associato slot1
            //se è 1-7
            if(Character.isDigit(slot1)){
             //   System.out.println("slot 1-7 chosen");
                int i=Character.getNumericValue(slot1);
                if(i>7 || i<1){
                    System.out.println("error input move");
                    return;
                }
                slottype x=slottype.fromValue(i); //associo i a slottype
                x1Slot=getSlot(x);
            }
            else { //come associo PDHCS char ai valori slottype? (if A è invalid)
                //se è PDHCS
                switch(slot1){
                    case 'A':
                        System.out.println("u cant move from Deck! Draw from it first");
                        return;
                    case 'P':
                        slottype p=slottype.P;
                        x1Slot=getSlot(p);
                        break;
                    case 'D':
                        System.out.println("invalid move");
                        return;
                    case 'H':
                        System.out.println("invalid move");
                        return;
                    case 'C':
                        System.out.println("invalid move");
                        return;
                    case 'S':
                        System.out.println("invalid move");
                        return;
                    default:
                        System.out.println("Error input move slottype");
                        return;
                }
                //X1Slot trovato
            }

            //otteniamo slottype associato slot2
            //se è 1-7
            if(Character.isDigit(slot2)){
           //     System.out.println("slot 1-7 chosen");
                int i=Character.getNumericValue(slot2);
                if(i>7 || i<1){
                    System.out.println("error input move");
                    return;
                }
                slottype x=slottype.fromValue(i); //associo i a slottype
                x2Slot=getSlot(x);
            }
            else { //come associo PDHCS char ai valori slottype? (if A è invalid)
                //se è PDHCS
                switch(slot2) {
                    case 'A':
                        System.out.println("u cant move to Deck!");
                        return;
                    case 'P':
                        System.out.println("invalid move");
                        return;
                    case 'D':
                        slottype d = slottype.D;
                        x2Slot = getSlot(d);
                        break;
                    case 'H':
                        slottype h = slottype.H;
                        x2Slot = getSlot(h);
                        break;
                    case 'C':
                        slottype c = slottype.C;
                        x2Slot = getSlot(c);
                        break;
                    case 'S':
                        slottype s = slottype.S;
                        x2Slot = getSlot(s);
                        break;
                    default:
                        System.out.println("Error: Invalid character for slottype");
                        return;
                }
                //X2Slot trovato
            }  // slot trovati
       // print slottype for debugging
        slottype s1 = x1Slot.getslottype();
        slottype s2 = x2Slot.getslottype();
     //   System.out.println("slottype riconosciuti:"+s1+s2);  //funziona

         if(cmd.length()==3){
             char slot3=cmd.charAt(2);
             if(Character.isDigit(slot3)){
                 int i=Character.getNumericValue(slot3);
                 if(i>1) {
                     if(s1==slottype.P){ //checck?
                         System.out.println("invalid move");
                         return;
                     }



                     nmoves = i;
              //       System.out.println("nmoves modificato!");
                     //vedo un attimo la carta
                     ArrayList<Card> line1= x1Slot.getline();
                     if(nmoves<line1.size()) {
                         Card card1 = line1.get(line1.size() - nmoves);
                         if (card1.getvisible()==false){
                             //se la carta non è visibile, cmq è illegale
                             System.out.println("invalid move, card not visible");
                             return;
                         }

                     }

                 }
                 else if(i<1){
                     System.out.println("Error input numbers of moves");
                     return;
                 }
             }
             else {
                 System.out.println("Error input numbers of moves");
                 return;
             }

         }

        //checkka se la mossa è legal? e se nmoves è dentro le dimensioni delle piles
         //accesso alle 2 pile
          ArrayList<Card> line1= x1Slot.getline();
          ArrayList<Card> line2= x2Slot.getline();
          if(nmoves>line1.size()){
              System.out.println("number moves invalid");
              return;
          }
        //posso fare lo switch? ossia se è consecutive e alterno di colore
          Card card1=null;
          Card card2=null;
        boolean valid=false;
          if(line1.size()>0 && line2.size()>0) {
              card1 = line1.get(line1.size() - nmoves);  // (accedo alla carta dalla fine usando getline().get(size()-i))
              card2 = line2.get(line2.size() - 1); //if size==0 if trigger error

              //confronto card 2 sopra card1;
              seedcard seed1 = card1.getseed();
              seedcard seed2 = card2.getseed();
              numbercard n1 = card1.getnumber();
              numbercard n2 = card2.getnumber();
              //confronto
              if (stListnumber.contains(s2)){
                  if(n2.getValue() == n1.getValue() + 1) {

                      //are they sequential in order? //only if l2 is 1-7 type
                      if (seed2 == seedcard.d || seed2 == seedcard.h) {
                          if (seed1 == seedcard.c || seed1 == seedcard.s) {
                              valid = true; //move!
                              System.out.println("Valid move! Moving..");
                          } else {
                              System.out.println("invalid move, not compatible cards");
                              return;
                          }
                      } else if (seed2 == seedcard.c || seed2 == seedcard.s) {
                          if (seed1 == seedcard.d || seed1 == seedcard.h) {
                              valid = true; //move!
                              System.out.println("Valid move! Moving..");
                          } else {
                              System.out.println("invalid move, not compatible cards");
                              return;
                          }
                      }
                  }
                  else {
                      System.out.println("invalid move, not compatible cards");
                      return;
                  }
              }
              else if(stListds.contains(s2)) {
                  if (n1.getValue() == n2.getValue() + 1) {
                      //sono stesso seme?
                      int l1dim= x1Slot.getline().size();
                      int l1number=x1Slot.getline().get(l1dim-1).getnumber().getValue();
                      String l1seed=x1Slot.getline().get(l1dim-1).getseed().getStr();
                      int l2slottype=x2Slot.getslottype().getValue();
                      String l2slottypestr;
                      switch (l2slottype){
                          case 10:
                              l2slottypestr="D";
                              break;
                          case 11:
                              l2slottypestr="H";
                              break;
                          case 12:
                              l2slottypestr="C";
                              break;
                          case 13:
                              l2slottypestr="S";
                              break;
                          default:
                              l2slottypestr = "Unknown"; //shilla mi importa solo dhcs
                              System.out.println("chill");
                              break;
                      }

                      if(l1seed.equals(l2slottypestr)){
                          valid=true;
                          System.out.println("Valid move! Moving..");
                      } else {
                          System.out.println("invalid move, not compatible cards");
                          return;
                      }
                  }
                  else {
                      System.out.println("invalid move, not compatible cards");
                      return;
                  }
              }

          }
          else if(line1.size()>0 && line2.size()==0){
              //2 casi

                  int l1dim= x1Slot.getline().size();
                  int l1number=x1Slot.getline().get(l1dim-1).getnumber().getValue();
                  String l1seed=x1Slot.getline().get(l1dim-1).getseed().getStr();
                  int l2slottype=x2Slot.getslottype().getValue();
                  String l2slottypestr;
                  switch (l2slottype){
                      case 10:
                          l2slottypestr="D";
                          break;
                      case 11:
                          l2slottypestr="H";
                          break;
                      case 12:
                          l2slottypestr="C";
                          break;
                      case 13:
                          l2slottypestr="S";
                          break;
                      default:
                          l2slottypestr = "Unknown"; //shilla se è 1-7 uso getValue
                          System.out.println("chill");
                          break;
                  }


              if(s2==slottype.D || s2==slottype.H || s2==slottype.C || s2==slottype.S){
                  //if l2 è DHCS empty e l1 is ace and same sign,
                  //valid=true;
                  if(l1seed.equals(l2slottypestr) && l1number==1) { //se slot =seed dhcs e l1 è asso
                      valid=true;
               //       System.out.println("odio sta cosa");
                  }
                  else{
                      System.out.println("invalid move, not compatible cards");
                      return;
                  }
              }
              else {
                  //if l2 è 1-7 vuoto e l1 è K,
                  //valid=true;
                  if(l1number==13){
                      valid=true;
               //       System.out.println("odio sta cosa");
                  }
                  else{
                      System.out.println("invalid move, not compatible cards");
                      return;
                  }
              }
              //managed the 2 spacial cases
          }
          else if(line1.size()==0){
              System.out.println("invalid move, slot empty");
              return;
          }

       if(valid) {
           System.out.println("Updating score..");
           //save sublist
           List<Card> sub = line1.subList(line1.size() - nmoves, line1.size()); //line1.size() is excluded
           ArrayList<Card> subcopy = new ArrayList<>(sub); //copia lista
           //append to
           line2.addAll(subcopy);
           sub.clear(); //deletes from line1;
           System.out.println("moved!");

           // aggiorna score e printo

           //3 case of score
           // s1, s2 both numberlines  score +5
           int scor = 0;
           if (stListnumber.contains(s1) && stListnumber.contains(s2)) {
               scor = 5*nmoves;
               score = score + scor;
           }
           // s1 is P, s2 is D_H_C_S  score +10
           if (s1 == slottype.P && stListds.contains(s2)) {
               scor = 10*nmoves;
               score = score + scor;
           }
           //s1 is numberlines, s2 is D_H_C_S score +20
           if (stListnumber.contains(s1) && stListds.contains(s2)) {
               scor = 20*nmoves;
               score = score + scor;
           }
           System.out.println("+score:" + scor);

        //   System.out.println("moved!");
       }

    }

    public boolean isGameover(){
        return gameover;
    }
    public int getScore(){
        return score;
    }

    public void update(String cmd1) {
       // GamePrint();
        String cmd = cmd1.toUpperCase(); //considero tutto maiuscolo
        int sizeinput = cmd.length();

        // gives input cmd to the methods moves or draw

        if (sizeinput == 0 || sizeinput > 3) {
            System.out.println("Error input from terminal");
            GamePrint();
            return;
        }
        System.out.println("Updating..");
        if (sizeinput == 1) {
            //error input if its incorrect
            if (cmd.equals("Q")) {
                quit();
            }
            else if (cmd.equals("D")) {
                draw();
            }
            else {
                System.out.println("invalid cmd");
                GamePrint();
                return;
            }
        }

        if (sizeinput == 2 || sizeinput == 3) {
            //error input if its incorrect
            move(cmd); //cmd is already uppercase

        }

        //also make visible every last card of eachslot (if the slots are not empty)
        for (int i = 0; i < 7; i++) {
            slottype n = slottype.fromValue(i + 1); //associo i a slottype
            Slot nSlot = getSlot(n); //trovato slot in uso attualmente( da 1 a 7)
            int dim = nSlot.getline().size(); //eror null?
            if (dim > 0) {
                nSlot.getline().get(dim - 1).setVisible(true); //rendo ultima carta visible
            }
        }


        //check if DHCS last cards are king, if so gameover=true
        slottype d = slottype.D;
        slottype h = slottype.H;
        slottype c = slottype.C;
        slottype s = slottype.S;
        Slot D = getSlot(d);
        Slot H = getSlot(h);
        Slot C = getSlot(c);
        Slot S = getSlot(s);
        int dimd = D.getline().size();
        int dimh = H.getline().size();
        int dimc = C.getline().size();
        int dims = S.getline().size();
        if (dimd > 0 && dimh > 0 && dimc > 0 && dims > 0){
            Card dlast = D.getline().get(dimd - 1);
            Card hlast = H.getline().get(dimh - 1);
            Card clast = C.getline().get(dimc - 1);
            Card slast = S.getline().get(dims - 1);
        //checcka errori

        if (dlast.getnumber().getValue() == 13 && hlast.getnumber().getValue() == 13 && clast.getnumber().getValue() == 13 && slast.getnumber().getValue() == 13) {
            gameover = true;
            System.out.println("Gameover!");
        }
    }
        GamePrint();



    }
}
