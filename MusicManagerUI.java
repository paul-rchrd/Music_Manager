import java.io.InterruptedIOException;
import java.util.*;


public class MusicManagerUI {


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        MusicManager m = new MusicManager();
        m.datenbankNutzen();
        int auswahl = 0;

        System.out.println("Bitte eine Aktion auswählen: ");
        System.out.println(" ");
        System.out.println("1  Song einstellen");
        System.out.println("2  Abstimmung erzeugen");
        System.out.println("3  Song zur Abstimmung hinzufügen");
        System.out.println("4  Abstimmung starten");
        System.out.println("5  Songs aus Abstimmung holen");
        System.out.println("6  Song suchen");
        System.out.println("7  Abstimmen");
        System.out.println("8  Playlist holen");
        System.out.println(" ");
        System.out.println("Ihre Auswahl: ");

        auswahl = Integer.parseInt(sc.nextLine());

        switch (auswahl){
            case 1 :
                //einstellen songs
                System.out.println("Bitte Song Nummer angeben: ");
                int songNr = Integer.parseInt(sc.nextLine());
                System.out.println("Bitte Titel angeben: ");
                String titel = sc.nextLine();
                System.out.println("Bitte die Spieldauer angeben (gerundet auf Minuten): ");
                int spieldauer = Integer.parseInt(sc.nextLine());
                System.out.println("Bitte den Interpreten angeben: ");
                String interpret = sc.nextLine();



                m.einstellenSong(0,songNr,titel,spieldauer,interpret,0);
                System.out.println("Song eingestellt");
                break;

            case 2:
                //erzeugen Abstimmung
                break;
            case 3:
                //hinzufuegen Song zur Abstimmung
                break;
            case 4:
                //starte Abstimmung
                break;
            case 5:
                //hole Songs der Abstimmung
                break;
            case 6:
                //suche Song
                break;
            case 7:
                //abstimmen
                break;
            case 8:
                //hole Playlist
                break;

        }



    }
}
