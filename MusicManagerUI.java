import java.io.InterruptedIOException;
import java.sql.ResultSet;
import java.util.*;


public class MusicManagerUI {


    public static void main(String[] args) throws Exception{

        MusicManagerUI mui1 = new MusicManagerUI();
        mui1.menue();
    }

    public void menue() throws Exception{
        Scanner sc = new Scanner(System.in);
        MusicManager m = new MusicManager();
        m.datenbankErstellen();
        Abstimmung a = new Abstimmung("test", 2, 3);
        m.datenbankNutzen();
        a.datenbankNutzen();
        int auswahl = 0;

        System.out.println("Bitte eine Aktion auswählen: ");
        System.out.println(" ");
        System.out.println("1  Song zur Abstimmung hinzufügen");
        System.out.println("2  Abstimmung erzeugen");
        System.out.println("3  Abstimmung starten");
        System.out.println("4  Songs aus Abstimmung holen");
        System.out.println("5  Song suchen");
        System.out.println("6  Abstimmen");
        System.out.println("7  Playlist holen");
        System.out.println(" ");
        System.out.println("Ihre Auswahl: ");

        auswahl = Integer.parseInt(sc.nextLine());

        switch (auswahl){
            case 1 :
                //hinzufuegen SOng zur Abstimmung
                //System.out.println("Bitte Song Nummer angeben: ");
                //int songNr = Integer.parseInt(sc.nextLine());
                System.out.println("Bitte Titel angeben: ");
                String titel = sc.nextLine();
                System.out.println("Bitte die Spieldauer des Songs angeben (gerundet auf Minuten): ");
                int spieldauer = Integer.parseInt(sc.nextLine());
                System.out.println("Bitte den Interpreten angeben: ");
                String interpret = sc.nextLine();


                m.einstellenSong( titel,spieldauer,interpret,0);

                System.out.println("Song eingestellt");
                
                menue();


            case 2:
                //erzeugen Abstimmung

                System.out.println("Bitte Bezeichnung angeben: ");
                String bezeichnung = sc.nextLine();

                System.out.println("Bitte Abstimmdauer angeben (in Min): ");
                int abstimmdauer = Integer.parseInt(sc.nextLine());

                System.out.println("Bitte Spieldauer der Playlist angeben (in Min): ");
                int spieldauerp = Integer.parseInt(sc.nextLine());

                m.erzeugeAbstimmung(bezeichnung, abstimmdauer, spieldauerp, null ,1, 0,0);

                menue();

            case 3:
                //starte Abstimmung
            a.starten();
            
                menue();
            case 4:
                //hole Songs der Abstimmung
                menue();
            case 5:
                //suche Song
                menue();
            case 6:
                //abstimmen
                menue();
            case 7:
                //hole Playlist
                menue();

        }
    }
}
