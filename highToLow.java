
public class highToLow {
    public static void main(String[] args){
        Kartenliste kartenliste = new Kartenliste(Integer.valueOf(args[0]), false);

        //System.out.print("Insertion: ");
        kartenliste.sortieren();


        //System.out.print("Selection: ");
        kartenliste.sortieren2();

    }

}
