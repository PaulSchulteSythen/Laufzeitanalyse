import java.util.concurrent.ThreadLocalRandom;
/**
 * Write a description of class Sortieren here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kartenliste
{
    // instance variables - replace the example below with your own
    private List<Spielkarte> karten_liste;
    private List<Spielkarte> karten_liste1;


    /**
     * Constructor for objects of class Sortieren
     */
    public Kartenliste(int anzahl)
    {
        // initialise instance variables
        karten_liste = new List<Spielkarte>();
        karten_liste1 = new List<Spielkarte>();

        for(int i = 0; i < anzahl; i++){
            int number = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            karten_liste.append(new Spielkarte(number));
            karten_liste1.append(new Spielkarte(number));
        }

        
    }
    public Kartenliste(int anzahl, boolean lowToHigh){
        if(lowToHigh){
            karten_liste = new List<Spielkarte>();
            karten_liste1 = new List<Spielkarte>();

            for(int i = 0; i < anzahl; i++){
                karten_liste.append(new Spielkarte(i));
                karten_liste1.append(new Spielkarte(i));
            }
        }else{
            karten_liste = new List<Spielkarte>();
            karten_liste1 = new List<Spielkarte>();

            for(int i = anzahl; i > 0; i--){
                karten_liste.append(new Spielkarte(i));
                karten_liste1.append(new Spielkarte(i));
            }
        }
    }

    public void karteEinfuegen(Spielkarte pKarte) {
        // Spielkarte hinten in der Liste einfügen
        karten_liste.append(pKarte);

    }

    public void Kartenliste_ausgeben() {
        System.out.println("Liste 1:");
        //Die Liste muss vom Anfang durchlaufen werden. 
        karten_liste.toFirst();
        //Solange es ein aktuelles Objekt gibt, 
        while (karten_liste.hasAccess()) {
            // Es soll ein Objekt vom Datentyp Buch erstellt werden, das den Content von Büchern durchläuft. 
            Spielkarte akt = karten_liste.getContent();
            // Es sollen die aktuellen Bücher ausgegeben werden. 
            System.out.println(akt.Kartenwert);
            //Die Liste soll weiter durchlaufen werden. 
            karten_liste.next();
        }

        System.out.println("Liste 2:");
        //Die Liste muss vom Anfang durchlaufen werden. 
        karten_liste1.toFirst();
        //Solange es ein aktuelles Objekt gibt, 
        while (karten_liste1.hasAccess()) {
            // Es soll ein Objekt vom Datentyp Buch erstellt werden, das den Content von Büchern durchläuft. 
            Spielkarte akt = karten_liste1.getContent();
            // Es sollen die aktuellen Bücher ausgegeben werden. 
            System.out.println(akt.Kartenwert);
            //Die Liste soll weiter durchlaufen werden. 
            karten_liste1.next();
        }
    }

    public void sortieren()
    {

        // save starttime
        long start = System.currentTimeMillis();

        List<Spielkarte> hilfsliste = new List<Spielkarte>();

        // erstes Element der alten Liste auswählen
        karten_liste.toFirst();

        // solange die Liste nicht leer ist
        while(karten_liste.hasAccess()){

            karten_liste.toFirst();
            // nehme erstes Element aus der alten Liste und loesche es aus der Liste
            Spielkarte aktuelle_Karte = karten_liste.getContent();
            karten_liste.remove();

            hilfsliste.toFirst();

            // solange aktuelles Element der Hilfsliste existiert und das aktuelle groesser als das aktuelle aus der Hilfsliste ist
            while(hilfsliste.hasAccess() && aktuelle_Karte.Kartenwert > hilfsliste.getContent().Kartenwert){
                hilfsliste.next();
            }

            if(!hilfsliste.hasAccess()){
                hilfsliste.append(aktuelle_Karte);
            }else{
                // aktuelle Karte in Hilfsliste einfuegen
                //hilfsliste.next();
                hilfsliste.insert(aktuelle_Karte);

            }

        }

  
        // Mit diesem Befehl, werden die Hilfslist und die Originalliste zusammengeführt.
        karten_liste.concat(hilfsliste);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);

    }


    public void sortieren2()
    {

        // save starttime
        long start = System.currentTimeMillis();

        List<Spielkarte> hilfsliste = new List<Spielkarte>();

        // erstes Element der alten Liste auswählen
        karten_liste1.toFirst();

        // solange die Liste nicht leer ist
        while(karten_liste1.hasAccess()){

            karten_liste1.toFirst();
            // nehme erstes Element aus der alten Liste und loesche es aus der Liste
            Spielkarte aktuelle_Karte = karten_liste1.getContent();

            while(karten_liste1.hasAccess()){
                if(aktuelle_Karte.Kartenwert > karten_liste1.getContent().Kartenwert){
                    aktuelle_Karte = karten_liste1.getContent();
                }
                karten_liste1.next();
            }

            karten_liste1.toFirst();

            while(karten_liste1.hasAccess() && karten_liste1.getContent().Kartenwert != aktuelle_Karte.Kartenwert){
                karten_liste1.next();
            }

	        karten_liste1.remove();
	        hilfsliste.append(aktuelle_Karte);
        }


        // Mit diesem Befehl, werden die Hilfslist und die Originalliste zusammengeführt.
        karten_liste1.concat(hilfsliste);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);

    }

    
}
